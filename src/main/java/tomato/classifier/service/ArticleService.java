package tomato.classifier.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tomato.classifier.dto.ArticleDto;
import tomato.classifier.dto.CommentDto;
import tomato.classifier.entity.Article;
import tomato.classifier.repository.ArticleRepository;
import tomato.classifier.repository.CommentRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ArticleService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }
    //GET START
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleDto> articleDtos = new ArrayList<>();

        for (Article article : articles) {
            if (!article.isDeleteYn()) {
                ArticleDto articleDto = ArticleDto.convertDto(article);
                articleDtos.add(articleDto);
            }
        }
        return articleDtos;
    }
    @Transactional
    public void updateView(Integer articleId) {
        articleRepository.updateView(articleId);
    }

    @Transactional
    public ArticleDto getArticle(Integer articleId){
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("id err"));

        ArticleDto articleDto = ArticleDto.convertDto(article);

        return articleDto;
    }

    public List<CommentDto> getComments(Integer articleId) {
        List<CommentDto> allComments = commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.convertDto(comment))
                .collect(Collectors.toList());
        List<CommentDto> comments = new ArrayList<>();

        for (CommentDto comment : allComments) {
            if (!comment.isDeleteYn()) {
                comments.add(comment);
            }
        }

        return comments;
    }
    //GET FINISH
    //POST START
    @Transactional
    public ArticleDto write(ArticleDto articleDto){
        articleDto.setDeleteYn(false);
        articleDto.setUpdateYn(false);
        articleDto.setView(0);

        Article article = Article.convertEntity(articleDto);

        articleRepository.save(article);

        return articleDto;
    }
    @Transactional
    public ArticleDto edit(Integer articleId, ArticleDto articleDto){
        Article target = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("게시글 조회 실패!"));

        target.patch(articleDto);

        Article updated = articleRepository.save(target);

        ArticleDto updatedDto = ArticleDto.convertDto(updated);

        return updatedDto;
    }
    @Transactional
    public Article delete(Integer articleId){
        Article target = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("id err"));

        target.delete();

        Article deleted = articleRepository.save(target);

        return deleted;
    }
}

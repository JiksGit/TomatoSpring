package tomato.classifier.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tomato.classifier.dto.CommentDto;
import tomato.classifier.entity.Article;
import tomato.classifier.entity.Comment;
import tomato.classifier.repository.ArticleRepository;
import tomato.classifier.repository.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ArticleRepository articleRepository;

    private final CommentRepository commentRepository;

    public CommentDto write(Integer articleId, CommentDto commentDto){
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패, 게시글 조회 실패"));

        commentDto.setDeleteYn(false);
        commentDto.setUpdateYn(false);

        Comment comment = Comment.convertEntity(commentDto, article);

        commentRepository.save(comment);

        CommentDto dto = CommentDto.convertDto(comment);

        return dto;
    }

    public CommentDto edit(Integer commentId, CommentDto commentDto){
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("게시글 id 오류"));

        target.patch(commentDto);

        Comment updated = commentRepository.save(target);

        CommentDto updateDto = CommentDto.convertDto(updated);

        return updateDto;
    }

    public CommentDto delete(Integer commentId, CommentDto commentDto){
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 id 오류"));

        target.delete();

        Comment deleted = commentRepository.save(target);

        CommentDto deletedDto = CommentDto.convertDto(deleted);

        return deletedDto;
    }
}

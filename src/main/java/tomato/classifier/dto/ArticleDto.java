package tomato.classifier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tomato.classifier.entity.Article;
import tomato.classifier.entity.Comment;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private Integer articleId;

    private String title;

    private String articleWriter;

    private String content;

    private boolean deleteYn;

    private boolean updateYn;

    private String updateTime;

    private List<Comment> comments;

    private Integer view;

    private Integer commentCount;

    public static ArticleDto convertDto(Article target) {

        Integer count = 0;
        for (Comment comment : target.getComments()){
            if(!comment.isDelete_yn()){
                count++;
            }
        }
        return new ArticleDto(
                target.getArticleId(),
                target.getTitle(),
                target.getArticleWriter(),
                target.getContent(),
                target.isDeleteYn(),
                target.isUpdateYn(),
                target.getUpdate_time(),
                target.getComments(),
                target.getView(),
                count
        );
    }

}

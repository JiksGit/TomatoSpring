package tomato.classifier.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tomato.classifier.entity.Comment;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Integer commentId;

    private Integer articleId;

    private String commentWriter;

    private String content;

    private boolean deleteYn;

    private boolean updateYn;

    private String updateTime;

    public static CommentDto convertDto(Comment target) {
        return new CommentDto(
                target.getComment_id(),
                target.getArticle().getArticleId(),
                target.getComment_writer(),
                target.getContent(),
                target.isDelete_yn(),
                target.isUpdate_yn(),
                target.getUpdate_time()
        );
    }


}

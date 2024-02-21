package tomato.classifier.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import tomato.classifier.dto.ArticleDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Article extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;

    @Column
    private String title;

    @Column
    private String articleWriter;

    @Column
    private String content;

    @Column
    private boolean deleteYn;

    @Column
    private boolean updateYn;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL) // article 엔티티의 comments 필드의 주인은 반대편(commnet 엔티티)의 article필드
    private List<Comment> comments;


    public static Article convertEntity(ArticleDto target) {
        if(target.getArticleId() != null)
            throw new IllegalArgumentException("게시글 생성 실패, id가 존재");

        return new Article(
                target.getArticleId(),
                target.getTitle(),
                target.getArticleWriter(),
                target.getContent(),
                target.isDeleteYn(),
                target.isUpdateYn(),
                target.getView(),
                target.getComments()
        );
    }

    public void patch(ArticleDto articleDto) {
        if (this.articleId != articleDto.getArticleId()) {
            throw new IllegalArgumentException("게시글 수정 실패!");
        }
        if (articleDto.getTitle() != "") {
            this.title = articleDto.getTitle();
            this.updateYn = true;
        }
        if (articleDto.getContent() != "") {
            this.content = articleDto.getContent();
            this.updateYn = true;
        }

    }

    public void delete() {
        this.deleteYn = true;

        for (Comment comment : this.comments) {
            comment.delete();
        }
    }
}

package tomato.classifier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tomato.classifier.entity.Article;

@Repository
public interface ArticleRepository  extends JpaRepository<Article, Integer> {
    Article findByTitle(String titleA);

    @Modifying
    @Query("update Article p set p.view = p.view + 1 where p.articleId = :id")
    int updateView(@Param("id") Integer id);
}

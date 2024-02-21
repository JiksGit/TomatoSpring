package tomato.classifier.repository;

import tomato.classifier.entity.Comment;

import java.util.List;

public interface CommentCustomRepository {
    List<Comment> findByArticleId(Integer articleId);
}

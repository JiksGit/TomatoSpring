package tomato.classifier.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {

    @CreatedDate
    private String update_time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));

    @CreatedDate
    private String comment_time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
}

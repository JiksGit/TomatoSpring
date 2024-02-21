package tomato.classifier.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResultData {
    private String name;
    private Integer prob;
}

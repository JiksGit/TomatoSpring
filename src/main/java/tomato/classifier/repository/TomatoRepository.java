package tomato.classifier.repository;

import org.springframework.stereotype.Repository;
import tomato.classifier.data.ResultData;

@Repository
public class TomatoRepository {
    private static ResultData finalData = new ResultData();

    public ResultData save(ResultData data) {

        finalData = data;

        return finalData;
    }

    public ResultData find() {
        return finalData;
    }
}

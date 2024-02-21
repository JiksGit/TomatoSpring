package tomato.classifier.dto;

import lombok.*;
import tomato.classifier.data.ResultData;
import tomato.classifier.entity.Disease;

@Getter
@Setter
@ToString   // 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메서드
@NoArgsConstructor  // 인자 없이 객체 생성 가능
@AllArgsConstructor
public class DiseaseDto {
    private String id;
    private String d_name;
    private String src;
    private String solution;
    private Integer prob;


    public static DiseaseDto convertDto(Disease target, ResultData data) {
        return new DiseaseDto(
                target.getId(),
                target.getD_name(),
                target.getSrc(),
                target.getSolution(),
                data.getProb()
        );
    }
}

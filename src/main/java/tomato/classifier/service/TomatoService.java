package tomato.classifier.service;

import org.springframework.stereotype.Service;
import tomato.classifier.data.ResultData;
import tomato.classifier.dto.DiseaseDto;
import tomato.classifier.entity.Disease;
import tomato.classifier.repository.DiseaseRepository;
import tomato.classifier.repository.TomatoRepository;

@Service
public class TomatoService {

    private final TomatoRepository tomatoRepository;
    private final DiseaseRepository diseaseRepository;


    public TomatoService(TomatoRepository tomatoRepository, DiseaseRepository diseaseRepository) {
        this.tomatoRepository = tomatoRepository;
        this.diseaseRepository = diseaseRepository;
    }

    public void saveTomato(ResultData data){
        tomatoRepository.save(data);
    }

    public DiseaseDto result(){
        ResultData items = tomatoRepository.find();

        Disease target = diseaseRepository.findById(items.getName())
                .orElseThrow(() -> new IllegalArgumentException("질병 조회 실패"));

        DiseaseDto createdDto = DiseaseDto.convertDto(target,items);

        return createdDto;
    }
}

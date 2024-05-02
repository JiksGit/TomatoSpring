package tomato.classifier.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tomato.classifier.data.ResultData;
import tomato.classifier.dto.DiseaseDto;
import tomato.classifier.service.TomatoService;

@Controller
@Slf4j
public class MainController {

    private final TomatoService tomatoService;

    public MainController(TomatoService tomatoService) {
        this.tomatoService = tomatoService;
    }

    @ApiOperation(value = "메인 페이지", notes = "메인화면 뷰")
    @GetMapping("/")
    public String mainView() {
        return "main/mainPage";
    }

    @ApiOperation(value = "AI data전송", notes = "save Data")
    @PostMapping("/resultprocess")
    public String resultView(@RequestBody ResultData data){

        tomatoService.saveTomato(data);

        return "redirect:/result";
    }

    @ApiOperation(value = "AI 정확도 조회", notes = "densenet")
    @GetMapping("/result")
    public String resultView2(Model model){
        DiseaseDto createdDto = tomatoService.result();

        model.addAttribute("dto", createdDto);

        return "main/resultPage";
    }

    @ApiOperation(value = "KaKao Map API", notes = "카카오 맵 API")
    @GetMapping("/map")
    public String Map() {
        return "map/map";
    }

}

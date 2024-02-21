package tomato.classifier.controller;

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

    @GetMapping("/")
    public String mainView() {
        return "main/mainPage";
    }

    @PostMapping("/resultprocess")
    public String resultView(@RequestBody ResultData data){

        tomatoService.saveTomato(data);

        return "redirect:/result";
    }

    @GetMapping("/result")
    public String resultView2(Model model){
        DiseaseDto createdDto = tomatoService.result();

        model.addAttribute("dto", createdDto);

        return "main/resultPage";
    }

    @GetMapping("/map")
    public String Map() {
        return "map/map";
    }

}

package tomato.classifier.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tomato.classifier.data.ResultData;
import tomato.classifier.dto.DiseaseDto;
import tomato.classifier.entity.User;
import tomato.classifier.service.TomatoService;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/api/data")
    public ResponseEntity<Map<String, Object>> getData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Map<String, Object> response = new HashMap<>();
        response.put("username", user.getUsername());
        response.put("role", user.getRole().name());

        return ResponseEntity.ok(response); // Map으로 JSON 응답 반환
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

package tomato.classifier.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tomato.classifier.dto.ArticleDto;
import tomato.classifier.dto.CommentDto;
import tomato.classifier.entity.Article;
import tomato.classifier.entity.Comment;
import tomato.classifier.entity.User;
import tomato.classifier.repository.ArticleRepository;
import tomato.classifier.repository.CommentRepository;
import tomato.classifier.repository.UserRepository;
import tomato.classifier.service.ArticleService;
import tomato.classifier.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final UserRepository userRepository;

    private final ArticleService articleService;

    @GetMapping()
    public String articleMain(Model model) {

        List<ArticleDto> allArticles = articleService.getAllArticles();
        Collections.reverse(allArticles);
        model.addAttribute("articles", allArticles);

        return "article/articleMain";
    }

    @GetMapping("/add")
    public String articleAdd(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        log.info(username);

        model.addAttribute("writer", username);
        return "article/articleAdd";
    }

    @GetMapping("/{articleId}")
    public String articleDetail(@PathVariable Integer articleId, Model model, HttpSession session) {

        ArticleDto articledto = articleService.getArticle(articleId);
        List<CommentDto> comments = articleService.getComments(articleId);
        articleService.updateView(articleId);
        //예외처리 할 것
        if (session.getAttribute("SPRING_SECURITY_CONTEXT") != null) {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            String username = loggedInUser.getName();
            model.addAttribute("commentWriter", username);
        }
//        //예외처리 할 것
//        if (session.getAttribute("SPRING_SECURITY_CONTEXT") != null) {
//            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            if (principal instanceof UserDetails) {
//                String username = ((UserDetails) principal).getUsername();
//                model.addAttribute("commentWriter", username);
//            }
//        }
        model.addAttribute("article", articledto);
        model.addAttribute("comments", comments);


        return "article/articleDetail";
    }


    @GetMapping("/edit")
    public String edit(@RequestParam Integer articleId, Model model) {
        //예외처리 할 것
        ArticleDto article = articleService.getArticle(articleId);
        model.addAttribute("article", article);

        return "article/articleUpdate";
    }

}

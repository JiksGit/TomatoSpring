package tomato.classifier.api;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tomato.classifier.dto.ArticleDto;
import tomato.classifier.entity.Article;
import tomato.classifier.repository.ArticleRepository;
import tomato.classifier.service.ArticleService;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;

    @ApiOperation(value = "게시글 추가")
    @PostMapping("/add")
    public ResponseEntity<ArticleDto> write(@RequestBody ArticleDto articleDto) {

        ArticleDto write = articleService.write(articleDto);

        return ResponseEntity.status(HttpStatus.OK).body(write);
    }

    @ApiOperation(value = "게시글 수정")
    @PatchMapping("/edit/{articleId}")
    public ResponseEntity<ArticleDto> edit(@PathVariable Integer articleId, @RequestBody ArticleDto articleDto) {

        ArticleDto updatedDto = articleService.edit(articleId, articleDto);

        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping("/delete/{articleId}")
    public ResponseEntity<Article> delete(@PathVariable Integer articleId) {

        Article deleted = articleService.delete(articleId);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}


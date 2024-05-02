package tomato.classifier.api;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tomato.classifier.dto.CommentDto;
import tomato.classifier.service.CommentService;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;

    @Transactional
    @ApiOperation(value = "댓글 작성")
    @PostMapping("/article/{articleId}/comment-add")
    public ResponseEntity<CommentDto> write(@PathVariable Integer articleId, @RequestBody CommentDto commentDto) {

        CommentDto dto = commentService.write(articleId, commentDto);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Transactional
    @ApiOperation(value = "댓글 수정")
    @PatchMapping("/comment-edit/{commentId}")
    public ResponseEntity<CommentDto> edit(@PathVariable Integer commentId, @RequestBody CommentDto commentDto) {

        CommentDto edit = commentService.edit(commentId, commentDto);

        return ResponseEntity.status(HttpStatus.OK).body(edit);
    }


    @Transactional
    @ApiOperation(value = "댓글 삭제")
    @DeleteMapping("/comment-delete/{commentId}")
    public ResponseEntity<CommentDto> delete(@PathVariable Integer commentId, @RequestBody CommentDto commentDto) {

        CommentDto deleted = commentService.delete(commentId, commentDto);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
        // delete_yn 여부에 따라 프론트에 보여지는 건 아직 구현 안함
    }
}


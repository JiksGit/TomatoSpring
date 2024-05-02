package tomato.classifier.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import tomato.classifier.dto.UserDto;
import tomato.classifier.dto.ArticleDto;
import tomato.classifier.entity.Article;
import tomato.classifier.entity.User;
//import tomato.classifier.jwt.JwtTokenProvider;
import tomato.classifier.repository.UserRepository;
//import tomato.classifier.service.UserService;
import tomato.classifier.user.UserCreateForm;
//import tomato.classifier.user.UserDto;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class UserController {
    //JWT 전 코드

    private final UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @ApiOperation(value = "회원가입 페이지")
    @GetMapping("/register")
    public String signup(@ModelAttribute("userCreateForm") UserCreateForm userCreateForm) {
        return "auth/register";
    }

    @ApiOperation(value = "로그인 페이지")
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @ApiOperation(value = "회원가입 요청")
    @PostMapping("/register")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "auth/register";
        }

        try {
            User user = User.convertEntity(userCreateForm);
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "auth/register";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "auth/register";
        }

        return "redirect:/";
    }

    @ApiOperation(value = "마이페이지")
    @GetMapping("/mypage")
    public String mypage(Model model){
         // 오류발생. 필요에 따라 사용자 정보를 추가로 활용하려면 getPrincipal()을 사용하고, 간단한 사용자 이름 또는 ID가 필요하면 getName()을 사용
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = ((UserDetails) principal).getUsername();
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
        }else{
            return "redirect:/";
        }
        return "auth/mypage";
    }

    @ApiOperation(value = "마이페이지 수정")
    @GetMapping("/mypageUpdate")
    public String mypageUpdate(@ModelAttribute("userCreateForm") UserCreateForm userCreateForm, Model model){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
        }else{
            return "redirect:/";
        }

        return "auth/mypageUpdate";
    }

    @ApiOperation(value = "마이페이지 수정 요청")
    @PostMapping("/mypageUpdate")
    public String mypageupdate(@Valid UserCreateForm userCreateForm, BindingResult bindingResult, @AuthenticationPrincipal User currentUser) {
        if (bindingResult.hasErrors()) {
            return "auth/mypageUpdate";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "auth/mypageUpdate";
        }

        try {
//            세션 두번째 저장 충돌
            User curr_user = userRepository.findById(currentUser.getId())
                    .orElseThrow(() -> new IllegalArgumentException("유저 조회 실패!"));
            User target = User.convertEntity(userCreateForm);
            curr_user.patch(target);
            userRepository.save(curr_user);

            // 변경된 정보로 Authentication 객체를 새로 생성
            Authentication newAuthentication = new UsernamePasswordAuthenticationToken(
                    curr_user.getUsername(),
                    curr_user.getPassword(),
                    currentUser.getAuthorities()); // 현재 사용자의 권한을 그대로 유지
            // SecurityContextHolder에 새로운 Authentication 객체를 설정
            SecurityContextHolder.getContext().setAuthentication(newAuthentication);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "auth/mypageUpdate";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "auth/mypageUpdate";
        }

        return "redirect:/";
    }

    // 유저 삭제
//    @DeleteMapping("/mypageUpdate/{articleId}")
//    public ResponseEntity<Article> deleteUser(@PathVariable Integer articleId) {
//
//        Article deleted = articleService.delete(articleId);
//
//        return ResponseEntity.status(HttpStatus.OK).body(deleted);
//    }
}
    //JWT 코드
//    private final PasswordEncoder passwordEncoder;
//    private final JwtTokenProvider jwtTokenProvider;
//    private final UserRepository userRepository;
//    //회원가입
//    @GetMapping("/register")
//    public String signup(@ModelAttribute("userCreateForm") UserCreateForm userCreateForm){
//        return "auth/register";
//    }
//    //로그인
//    @GetMapping("/login")
//    public String login(){
//        return "auth/login";
//    }
//
//    // 회원가입 post
//    @PostMapping("/register")
//    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return "auth/register";
//        }
//
//        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
//            bindingResult.rejectValue("password2", "passwordInCorrect",
//                    "2개의 패스워드가 일치하지 않습니다.");
//            return "auth/register";
//        }
//
//        try {
//            User user = User.convertEntity(userCreateForm);
//            userRepository.save(user);
//        } catch(DataIntegrityViolationException e){
//            e.printStackTrace();
//            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
//            return "auth/register";
//        } catch(Exception e){
//            e.printStackTrace();
//            bindingResult.reject("signupFailed", e.getMessage());
//            return "auth/register";
//        }
//
//        return "redirect:/";
//    }

//    // 로그인
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
//        if (userDto.getUsername() == null || userDto.getPassword() == null) {
//            return ResponseEntity.badRequest().body("유효한 사용자 이름과 비밀번호를 입력하세요.");
//        }
//
//        User member = userRepository.findByUsername(userDto.getUsername())
//                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 사용자입니다."));
//
//        if (!passwordEncoder.matches(userDto.getPassword(), member.getPassword())) {
//            return ResponseEntity.badRequest().body("잘못된 비밀번호입니다.");
//        }
//
//        String token = jwtTokenProvider.createToken(member.getUsername(), member.getRole());
//        return ResponseEntity.ok().body(token);
//    }


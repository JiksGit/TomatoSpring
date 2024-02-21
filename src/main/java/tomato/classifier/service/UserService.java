//package tomato.classifier.service;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import tomato.classifier.entity.User;
//import tomato.classifier.repository.UserRepository;
//
//import javax.transaction.Transactional;
//
//@Service
//
//public class UserService {
//    private final UserRepository userRepository;
//
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Transactional
//    public User edit(User user){
//        User persist = userRepository.findById(user.getId()).orElseThrow(()->{
//            return new IllegalArgumentException("회원 찾기 실패");
//        });
//        String rawPassword = user.getPassword();
//        String encPassword = BCryptPasswordEncoder.encode(rawPassword);
//    }
//}

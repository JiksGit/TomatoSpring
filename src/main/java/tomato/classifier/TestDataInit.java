package tomato.classifier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tomato.classifier.entity.Role;
import tomato.classifier.entity.User;
import tomato.classifier.repository.UserRepository;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final UserRepository userRepository;

    /**
     * 확인용 초기 데이터 추가
     */
    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("test data init");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userRepository.save(new User(null, "qwer", "qwer", passwordEncoder.encode("qwer"), "qwer@qwer", Role.USER));

    }
}

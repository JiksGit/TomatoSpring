package tomato.classifier.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tomato.classifier.entity.Role;
import tomato.classifier.entity.User;
import tomato.classifier.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> siteUser = this.userRepository.findByUsername(username);
        if (siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        //회원 정보
        User user = siteUser.get();
        //권한 정보
        List<GrantedAuthority> authorities = new ArrayList<>();

        //사용자권한처리
        if("admin".equals(username)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }

        return new User(user.getId(),
                user.getUsername(),
                user.getNickname(),
                user.getPassword(),
                user.getEmail(),
                Role.USER
        );

    }
}

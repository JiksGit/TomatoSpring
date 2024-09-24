package tomato.classifier.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import tomato.classifier.dto.UserDto;
import tomato.classifier.dto.ArticleDto;
import tomato.classifier.user.UserCreateForm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String username; // 아이디

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 30)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

//    //JWT
//    @ElementCollection(fetch = FetchType.EAGER)
//    @Builder.Default
//    private List<String> roles = new ArrayList<>();

    public void patch(User user) {
        if (user.getUsername() != "") {
            this.username = user.getUsername();
        }
        if (user.getNickname() != "") {
            this.nickname = user.getNickname();
        }
        if (user.getPassword() != "") {
            this.password = user.getPassword();
        }
        if (user.getEmail() != "") {
            this.email = user.getEmail();
        }
    }

    public static User convertEntity(UserCreateForm user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return new User(
                null,
                user.getUsername(),
                user.getNickname(),
                passwordEncoder.encode(user.getPassword1()),
                user.getEmail(),
                Role.USER
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

////    //JWT
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.roles.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
//
//    //JWT
//    @Override
//    public static String getUsername() {
//        return username;
//    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
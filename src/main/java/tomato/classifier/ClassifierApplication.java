package tomato.classifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import tomato.classifier.repository.UserRepository;

//Querydsl설정
//@Import(QuerydslConfig.class)
@EnableJpaAuditing
@SpringBootApplication
public class ClassifierApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassifierApplication.class, args);
    }


    @Bean
    @Profile("local")
    public TestDataInit testDataInit(UserRepository userRepository) {
        return new TestDataInit(userRepository);
    }
}

//package tomato.classifier.TestUser;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//
//import javax.transaction.Transactional;
//
//@SpringBootTest
//@Rollback (false)
//public class TestUserRepositoryTest {
//
//    @Autowired
//    TestUserRepository testUserRepository;
//
//    @Test
//    @Transactional
//    public void testMember() throws Exception{
////        TestUser user = new TestUser();
////        user.setUsername("memberA");
////
////        String savedId = testUserRepository.save(user);
////        TestUser findUser = testUserRepository.find(savedId);
////
////        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());
////        Assertions.assertThat(findUser.getUsername()).isEqualTo(user.getUsername());
//    }
//}

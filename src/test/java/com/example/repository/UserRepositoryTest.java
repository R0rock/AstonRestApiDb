package [com.example.repository](com.example.repository);

import [com.example.entity.User](com.example.entity.User);
import [org.junit.jupiter.api.Test](org.junit.jupiter.api.Test);
import [org.springframework.beans.factory.annotation.Autowired](org.springframework.beans.factory.annotation.Autowired);
import [org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest](org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest);

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsernameShouldReturnUser() {
        User user = new User();
        [user.setUsername(](user.setUsername()"test");
        [userRepository.save(user)](userRepository.save(user));

        User foundUser = [userRepository.findByUsername(](userRepository.findByUsername()"test").orElse(null);
        assert(foundUser != null && [foundUser.getUsername().equals(](foundUser.getUsername().equals()"test"));
    }
}
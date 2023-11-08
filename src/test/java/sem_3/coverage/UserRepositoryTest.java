package sem_3.coverage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_3.tdd.User;
import sem_3.tdd.UserRepository;

class UserRepositoryTest {
    
    UserRepository userRepository;
    User user1;
    User user2;
    User admin;
    
    @BeforeEach
    void setup() {
        userRepository = new UserRepository();
        user1 = new User("User1", "Pass1", false);
        user1.authenticate("User1", "Pass1");
        userRepository.addUser(user1);
        user2 = new User("User2", "Pass2", false);
        user1.authenticate("User2", "Pass2");
        userRepository.addUser(user2);
        admin = new User("Admin", "Admin", true);
        admin.authenticate("Admin", "Admin");
        userRepository.addUser(admin);
    }
    
    @Test
    void testUnAuthentication() {
        userRepository.unAuthenticate();
        assertFalse(user1.isAuthenticate);
        assertFalse(user2.isAuthenticate);
        assertTrue(admin.isAuthenticate);
    }
}

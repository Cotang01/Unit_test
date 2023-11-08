package sem_3.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

class UserTest {
    
    MoodAnalyser moodAnalyser;
    
    @BeforeEach
    void setup() { 
        moodAnalyser = new MoodAnalyser();
    }
    
    @Test
    void testUserGoodMood() {
        assertThat(moodAnalyser.analyseMood("Это был отличный день")).isEqualTo("happy");
    }
    
    @Test
    void testUserBadMood() { 
        assertThat(moodAnalyser.analyseMood("Это был ужасный день")).isEqualTo("bad");
    }
    
    @Test
    void testUserSoSoMood() {
        assertThat(moodAnalyser.analyseMood("День такой себе")).isEqualTo("so so");
    }
}
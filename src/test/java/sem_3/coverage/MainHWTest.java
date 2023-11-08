package sem_3.coverage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sem_3.hw.MainHW;

class MainHWTest {
    
    @Test
    void testEvenNumber() {
        assertTrue(MainHW.evenOddNumber(2));
    }
    
    @Test 
    void testOddNumber() {
        assertFalse(MainHW.evenOddNumber(1));
    }
    
    @ParameterizedTest
    @CsvSource({"26","50","99"})
    void testNumberInInterval(int n) {
        assertTrue(MainHW.numberInInterval(n));
    }
    
    @Test 
    void testNumberLowerInterval() {
        assertFalse(MainHW.numberInInterval(15));
    }
    
    @Test
    void testNumberUpperInterval() {
        assertFalse(MainHW.numberInInterval(101));
    }
    
}

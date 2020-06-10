package duTask;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MethodsTest {

    Methods ex = new Methods(true, true, true);
    Methods ex2 = new Methods(false, true, false);

    @Test
    void getFlagH() {
        assertTrue(ex.getFlagH());
    }

    @Test
    void getFlagC() {
        assertTrue(ex.getFlagC());
    }

    @Test
    void getFlagSi() {
        assertTrue(ex.getFlagSi());
    }

    @Test
    void getHumanFormattedSizeAllFlags() {
        ArrayList<String> test = new ArrayList<>();
        test.add("[C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg] 284.674 Kb");
        File tested = new File("C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg");
        String test3 = "Sum = 284 Kb";
        assertEquals(ex.getHumanFormattedSize(ex.findLength(tested), tested), test);
        assertEquals(ex.s(), test3);

    }

    @Test
    void findLengthAllFlags() {
        ArrayList<Long> test2 = new ArrayList<>();
        test2.add(284674L);
        File tested = new File("C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg");
        assertEquals(ex.findLength(tested), test2);
    }

    @Test
    void falseGetFlagH() {
        assertFalse(ex2.getFlagH());
    }

    @Test
    void trueGetFlagC() {
        assertTrue(ex2.getFlagC());
    }

    @Test
    void FalseGetFlagSi() {
        assertFalse(ex2.getFlagSi());
    }

    @Test
    void getHumanFormattedSizeOnlyCFlag() {
        ArrayList<String> test = new ArrayList<>();
        test.add("[C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg] 284674 b");
        File tested = new File("C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg");
        String test3 = "Sum = 284674 b";
        assertEquals(ex2.getHumanFormattedSize(ex2.findLength(tested), tested), test);
        assertEquals(ex2.s(), test3);

    }

    @Test
    void findLengthOnlyCFlag() {
        ArrayList<Long> test2 = new ArrayList<>();
        test2.add(284674L);
        File tested = new File("C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg");
        assertEquals(ex2.findLength(tested), test2);
    }

}

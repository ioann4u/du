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
    void getListOfFiles() {
    }

    @Test
    void getHumanFormattedSize() {
        ArrayList<String> test = new ArrayList<>();
        test.add("[C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg] 284.674 Kb");
        File tested = new File("C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg");
        assertEquals(ex.getHumanFormattedSize(ex.findLength(tested), tested), test);
    }

    @Test
    void findLength() {
        ArrayList<Long> test2 = new ArrayList<>();
        test2.add(284674L);
        File tested = new File("C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg");
        assertEquals(ex.findLength(tested), test2);
    }

    @Test
    void s() {
        File tested = new File("C:\\Users\\mi2\\IdeaProjects\\du\\src\\test\\resources\\AncientMechs\\ancient_robot1.jpg");
        String test3 = "Sum = 1 Kb";
        assertEquals(ex.s(), test3);
    }

}

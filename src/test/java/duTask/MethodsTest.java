package duTask;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodsTest {


    @Test
    void commandParse() {
        Methods ex = new Methods();
        String[] command;
        command = "du -h -c --si ancient_robot1.jpg".split(" ");
        ex.commandParse(command);
        assertTrue(ex.getFlagH());
        assertTrue(ex.getFlagC());
        assertTrue(ex.getFlagSi());
    }

    @Test
    void findLength() throws URISyntaxException {
        Methods ex = new Methods();
        String[] command;
        command = "du -h -c --si ancient_robot1.jpg".split(" ");
        ex.commandParse(command);
        ex.findLength();
        List<Long> expected = new ArrayList<>();
        expected.add((long) 284674);
        assertEquals(expected, ex.lengths);
    }

    @Test
    void outputFileLength() {
        //ex.count();
    }
}
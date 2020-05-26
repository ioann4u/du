package duTask;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodsTest {

/**
    @Test
    void commandParseAllFlags() {
        Methods ex = new Methods();
        String[] command;
        Main.main(new String[]{"-c", "--si", "resources/AncientMechs/ancient_robot1.jpg"});
        //assertTrue(ex.getFlagH());
        assertTrue(ex.getFlagC());
        assertTrue(ex.getFlagSi());
        assertEquals(ex.outputFileLength(), ex.findLength());
    }

    @Test
    void commandParseHCFlag() {
        Methods ex = new Methods();
        String[] command;
        command = "du -h -c test/resources/AncientMechs/ancient_robot1.jpg".split(" ");
        ex.commandParse(command);
        assertTrue(ex.getFlagH());
        assertTrue(ex.getFlagC());
    }
    @Test
    void commandParseHSiFlag() {
        Methods ex = new Methods();
        String[] command;
        command = "du -h --si test/resources/AncientMechs/ancient_robot1.jpg".split(" ");
        ex.commandParse(command);
        assertTrue(ex.getFlagH());
        assertTrue(ex.getFlagSi());
    }
    @Test
    void commandParseCSiFlag() {
        Methods ex = new Methods();
        String[] command;
        command = "du -c --si test/resources/AncientMechs/ancient_robot1.jpg".split(" ");
        ex.commandParse(command);
        assertTrue(ex.getFlagC());
        assertTrue(ex.getFlagSi());
    }
    @Test
    void commandParseHFlag() {
        Methods ex = new Methods();
        String[] command;
        command = "du -h -c test/resources/AncientMechs/ancient_robot1.jpg".split(" ");
        ex.commandParse(command);
        assertTrue(ex.getFlagH());
    }
    @Test
    void commandParseCFlag() {
        Methods ex = new Methods();
        String[] command;
        command = "du -c test/resources/AncientMechs/ancient_robot1.jpg".split(" ");
        ex.commandParse(command);
        assertTrue(ex.getFlagC());
    }
    @Test
    void commandParseSiFlag() {
        Methods ex = new Methods();
        String[] command;
        command = "du --si test/resources/AncientMechs/ancient_robot1.jpg".split(" ");
        ex.commandParse(command);
        assertTrue(ex.getFlagSi());
    }

    @Test
    void findLength() throws URISyntaxException {
        Methods ex = new Methods();
        String[] command;
        command = "du -h -c --si test/resources/AncientMechs/ancient_robot1.jpg".split(" ");
        ex.commandParse(command);
        ex.findLength();
        List<Long> expected = new ArrayList<Long>();
        expected.add((long) 284674);
        assertEquals(expected, ex.getLengths());
    }

    @Test
    void outputFileLength() {
        //ex.count();
    }
    */
}
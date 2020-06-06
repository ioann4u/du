package duTask;

import com.sun.glass.ui.Size;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodsTest {
/**
    List<String> sizeList(String[] args) {
        List<String> listOfSize = new ArrayList<>();
        Methods ex = new Methods();
        List<File> fileList = ex.files();
        for (int j = 0; j < fileList.size(); j++) {
            Size element = new Size(fileList.get(j));
            listOfSize.add(ex.necessarySizeOutput(element.getSize()));
        }
        return listOfSize;

    }

    @Test
    void commandParseAllFlags() {
        Main.main(new String[]{"-h", "--si", "resources/AncientMechs/ancient_robot1.jpg"});
        assertEquals(Arrays.asList("[ancient_robot1.jpg] 284.674 Kb"), new String[]{"-h", "--si", "resources/AncientMechs/ancient_robot1.jpg"});
    }

/**
    Methods ex = new Methods();

     @Test
     void getFlagH() {
     assertFalse(ex.getFlagH());
     }

    @Test
    void getFlagC() {
        assertFalse(ex.getFlagC());
    }

    @Test
    void getFlagSi() {
        assertFalse(ex.getFlagSi());
    }

    @Test
    void getListOfFiles() {

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

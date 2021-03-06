package duTask;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    @Option(name = "-h", usage = "Size in formats")
    private boolean flagH;

    @Option(name = "-c", usage = "Sum of sizes")
    private boolean flagC;

    @Option(name = "--si", usage = "Another base")
    private boolean flagSi;

    @Argument(required = true, usage = "File names")
    private ArrayList<File> names;

    private void commandLineArgument(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        Methods method = new Methods(flagH, flagC, flagSi);
        try {
            if (!names.isEmpty()) {
                for (File name : names) {
                    System.out.println(method.getHumanFormattedSize(method.findLength(name), name));
                }
            }
            if (flagC) {
                System.out.println(method.s());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new Main().commandLineArgument(args);
    }
}

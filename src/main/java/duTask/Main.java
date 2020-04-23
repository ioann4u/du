package duTask;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        Methods methods = new Methods();
        methods.commandParse(args);
        methods.findLength();
        methods.outputFileLength();
    }

}

package duTask;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

class Methods {

    private Boolean flagH;
    private Boolean flagC;
    private Boolean flagSi;
    private List<String> names;
    public List<Long> lengths;
    private double sum;



    Methods() {
        this.flagH = false;
        this.flagC = false;
        this.flagSi = false;
        this.names = new ArrayList<String>();
        this.lengths = new ArrayList<Long>();
        this.sum = 0.0;
    }

    Boolean getFlagH() {
        return flagH;
    }

    Boolean getFlagC() {
        return flagC;
    }

    Boolean getFlagSi() {
        return flagSi;
    }

    List<Long> getLengths() {
        return lengths;
    }

    void commandParse(String[] args) {
        if (args[0].equals("du")) {
            for (String i : args) {
                if (i.equals("-h")) {
                    this.flagH = true;
                } else if (i.equals("-c")) {
                    this.flagC = true;
                } else if (i.equals("--si")) {
                    this.flagSi = true;
                } else if (!i.equals("du")) {
                    this.names.add(i);
                }
            }
        } else throw new IllegalArgumentException("Unknown method");
    }

    void findLength() throws URISyntaxException {

        for (String name : names) {
            URL res = getClass().getClassLoader().getResource("AncientMechs/" + name);
            File file = Paths.get(res.toURI()).toFile();
            if (file.exists()) {
                this.lengths.add(file.length());
            }
        }
    }

    List<Double> count(int base) {
        List<Double> outPut = new ArrayList<>();
        for (Long length : this.lengths) {
            if (length < base) {
                System.out.println(names.get(lengths.indexOf(length)) + " " + length + " B");
                outPut.add((double) length);
            } else if (length < (base * base)) {
                System.out.println(names.get(lengths.indexOf(length)) + " " + ((double) length) / base + " KB");
                outPut.add((double) length / base);
            } else if (length < (base * base * base)) {
                System.out.println(names.get(lengths.indexOf(length)) + " " + ((double) length) / (base * base) + " MB");
                outPut.add((double) length / (base * base));
            } else {
                System.out.println(names.get(lengths.indexOf(length)) + " " + ((double) length) / (base * base * base) + " GB");
                outPut.add((double) length / (base * base * base));
            }
            this.sum += length;
        }
        return outPut;
    }

    void outputFileLength() {
        int base = 0;
        if (this.flagSi) {
            base = 1000;
        } else base = 1024;
        if (this.flagH) {
            List<Double> countMethod = count(base);
        } else for (Long length : this.lengths) {
            System.out.println(names.get(lengths.indexOf(length)) + " " + ((double) length) / base);
            this.sum += length;
        }

        if (this.flagC) {
            System.out.println(this.sum / base);
        }
    }
}

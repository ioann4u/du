package duTask;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Methods {

    private Boolean flagH;
    private Boolean flagC;
    private Boolean flagSi;
    private List<String> names;
    private List<Long> lengths;

    Methods() {
        this.flagH = false;
        this.flagC = false;
        this.flagSi = false;
        this.names = new ArrayList<String>();
        this.lengths = new ArrayList<Long>();
    }

    public Boolean getFlagH() {
        return flagH;
    }

    public Boolean getFlagC() {
        return flagC;
    }

    public Boolean getFlagSi() {
        return flagSi;
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

    void findLength() {
        for (String name : names) {
            File file = new File(name);
            if (file.exists()) {
                this.lengths.add(file.length());
            }
        }
    }

    void outputFileLength() {
        double sum = 0;
        int base = 0;
        if (this.flagSi) {
            base = 1000;
        } else base = 1024;
        if (this.flagH) {
            for (Long length : this.lengths) {
                if (length < base) {
                    System.out.println(names.get(lengths.indexOf(length)) + " " + length + " B");
                } else if (length < (base * base)) {
                    System.out.println(names.get(lengths.indexOf(length)) + " " + ((double) length) / base + " KB");
                } else if (length < (base * base * base)) {
                    System.out.println(names.get(lengths.indexOf(length)) + " " + ((double) length) / (base * base) + " MB");
                } else {
                    System.out.println(names.get(lengths.indexOf(length)) + " " + ((double) length) / (base * base * base) + " GB");
                }
                sum += length;
            }
        } else for (Long length : this.lengths) {
            System.out.println(names.get(lengths.indexOf(length)) + " " + ((double) length) / base);
            sum += length;
        }

        if (this.flagC) {
            if (sum < base) {
                System.out.println(sum + "B");
            } else if (sum < (base * base)) {
                System.out.println(sum / base + "KB");
            } else if (sum < (base * base * base)) {
                System.out.println(sum / (base * base) + "MB");
            } else {
                System.out.println(sum + "GB");
            }
        }
    }
}

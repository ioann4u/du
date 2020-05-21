package duTask;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.util.Objects;

class Methods {

    private Boolean flagH;
    private Boolean flagC;
    private Boolean flagSi;
    private List<String> names;
    private List<Long> lengths;
    //private HashMap<String, Long> size;
    private double sum;
    private int base;


    public Methods() {
        this.flagH = false;
        this.flagC = false;
        this.flagSi = false;
        //this.size = new HashMap<String, Long>();
        this.names = new ArrayList<String>();
        this.lengths = new ArrayList<Long>();
        this.sum = 0.0;
        this.base = 0;
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


    private long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        int count = files.length;
        for (File file : files) {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += getFolderSize(file);
            }
        }
        return length;
    }

    public void findLength() {
        for (String name : names) {
            File file = new File(name);
            if (file.exists() && file.isDirectory()) {
                this.lengths.add(getFolderSize(file));
            } else if (file.exists() && !file.isDirectory()) {
                this.lengths.add(file.length());
            }
        }
    }

    public List<Double> count() {
        List<Double> outPut = new ArrayList<Double>();
        Long i = 0L;
        if (this.flagSi) {
            base = 1000;
        } else base = 1024;

        for (Long length : this.lengths) {
            for (Long c = length; c < base;) {
                c = length / base;
                i = c;
            }
            outPut.add((double) i);
            /**if (length < base) {
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
            }*/
            this.sum += i;
        }
        return outPut;
    }

    private void outputFileLength() {
        if (this.flagSi) {
            base = 1000;
        } else base = 1024;
        if (this.flagH) {
            List<Double> countMethod = count();
        } else for (Long length : this.lengths) {
            System.out.println(names.get(lengths.indexOf(length)) + " " + ((double) length) / base);
            this.sum += length;
        }
        if (this.flagC) {
            System.out.println(this.sum / base);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Methods meth = (Methods) o;
        return flagC == meth.flagC &&
                flagH == meth.flagH &&
                flagSi == meth.flagSi &&
                Objects.equals(names, meth.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flagC, flagH, flagSi, names);
    }
}

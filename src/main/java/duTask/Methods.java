package duTask;

//import com.sun.org.apache.xpath.internal.operations.Bool;

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
    private List<File> names;
    //private HashMap<String, Long> size;
    private int base;


    public Methods(Boolean fH, Boolean fC, Boolean fSi) {
        this.flagH = fH;
        this.flagC = fC;
        this.flagSi = fSi;
        //this.size = new HashMap<String, Long>();
        this.names = new ArrayList<File>();
        this.base = 0;
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

    public List<File> getNames() {
        return names;
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

    public List<Long> findLength() {
        List<Long> lengths = new ArrayList<>();
        for (File name : names) {
            if (name.exists() && name.isDirectory()) {
                lengths.add(getFolderSize(name));
            } else if (name.exists() && !name.isDirectory()) {
                lengths.add(name.length());
            }
        }
        return lengths;
    }

    public List<String> getHumanFormattedSize() {
        List<String> out = new ArrayList<String>();
        List<Long> fileSizes = new ArrayList<Long>(findLength());
        String[] n = new String[]{"Б", "Кб", "Мб", "Гб"};
        Long i = 0L;
        Long counter = 0L;
        int count = 0;
        if (this.flagSi) {
            base = 1000;
        } else base = 1024;

        for (Long length : findLength()) {

            for (Long c = length; c < base; ) {
                c /= base;
                i = c;
                count++;
            }
            counter++;
            out.add(names + " " + i.toString() + n[count]);
        }
        return out;
    }

    /**public String  count(List<Long> fileSizes) {
        List<Long> outPut = new ArrayList<Long>();
        fileSizes = findLength();
        String[] n = new String[]{"Б", "Кб", "Мб", "Гб"};
        Long i = 0L;
        Long counter = 0L;
        int count = 0;
        if (this.flagSi) {
            base = 1000;
        } else base = 1024;

        for (Long length : fileSizes) {

            for (Long c = length; c < base;) {
                c /= base;
                i = c;
                count++;
            }
            counter++;
            outPut.add(i);

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

            //this.sum += i;

        }
        return (names.get(findLength().indexOf(counter)) + findLength().toString() + n[count]);
    }
     */


    public List<String> outputFileLength() {
        List<String> outputValues = new ArrayList<String>();
        if (this.flagSi) {
            base = 1000;
        } else base = 1024;
        if (this.flagH) {
            List<Long> countMethod = findLength();
        } else for (Long length : findLength()) {
           // outputValues.add(names.get(findLength().indexOf(length)+ " " + (((toString()) length) /base);
            System.out.println(names.get(findLength().indexOf(length)) + " " + ((double) length) / base);
            //this.sum += length;
        }
        if (this.flagC) {
            //System.out.println(this.sum / base);
        }
        return outputValues;
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

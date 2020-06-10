package duTask;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Objects;

class Methods {

    private Boolean flagH;
    private Boolean flagC;
    private Boolean flagSi;
    private List<File> names;
    private int sum;


    public Methods(Boolean fH, Boolean fC, Boolean fSi) {
        this.flagH = fH;
        this.flagC = fC;
        this.flagSi = fSi;
        this.names = new ArrayList<>();
        this.sum = 0;
    }

    public void setFlagH(Boolean flagH) {
        this.flagH = flagH;
    }

    public Boolean getFlagH() {
        return flagH;
    }

    public void setFlagC(Boolean flagC) {
        this.flagC = flagC;
    }

    public Boolean getFlagC() {
        return flagC;
    }

    public void setFlagSi(Boolean flagSi) {
        this.flagSi = flagSi;
    }

    public Boolean getFlagSi() {
        return flagSi;
    }


    public List<File> files(File testFile) {
        ArrayList<File> fileList = new ArrayList<>();
        fileList.add(testFile);
        return fileList;
    }

    private static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            } else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }

    public List<Long> findLength(File file) {
        List<Long> lengths = new ArrayList<>();
        for (File name : files(file)) {
            if (name.exists() && name.isDirectory()) {
                lengths.add(getFolderSize(name));
            } else if (name.exists() && !name.isDirectory()) {
                lengths.add(name.length());
            }
        }
        return lengths;
    }

    public List<String> getHumanFormattedSize(List<Long> fileSizes, File file) {
        List<String> out = new ArrayList<String>();
        fileSizes = new ArrayList<Long>(findLength(file));
        String[] n = new String[]{"Б", "Кб", "Мб", "Гб"};
        Long i = 0L;
        Long counter = 0L;
        int count = 0;
        int base = 0;
        if (this.flagSi) {
            base = 1000;
        } else base = 1024;

        if (this.flagH) {
            for (Long length : fileSizes) {
                if (length < base) {
                    out.add(files(file) + " " + length + " b");
                } else if (length < base * base) {
                    out.add(files(file) + " " + (double) length / base + " Kb");
                } else if (length < base * base * base) {
                    out.add(files(file) + " " + (double) length / (base * base) + " Mb");
                } else if (length < base * base * base * base) {
                    out.add(files(file) + " " + (double) length / (base * base * base) + " Gb");
                }
                this.sum += length;
            }
        } else for (Long length : fileSizes) {
            out.add(files(file) + " " + length.toString() + " b");
            this.sum += length;
        }
        return out;
    }

    public String s() {
        String printSum = "";
        int base = 0;
        int sumOfSum = this.sum;
        if (this.flagSi) base = 1000;
        else base = 1024;
        if (!this.flagH) {
            printSum = "Sum = " + sumOfSum + " b";
        } else {
            if (this.sum < base * base)
                printSum = "Sum = " + sumOfSum / base + " Kb";
            else if (this.sum < base * base * base)
                printSum = "Sum = " + sumOfSum / (base * base) + " Mb";
            else if (this.sum < base * base * base * base)
                printSum = "Sum = " + sumOfSum / (base * base * base) + " Gb";
        }
        return printSum;
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

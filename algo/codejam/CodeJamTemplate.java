package teisei.algo.codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Teisei on 2016/4/9.
 */
public abstract class CodeJamTemplate {

    boolean LOCAL = System.getSecurityManager() == null;
    String NAME = "B";
    String TYPE = "test";
    String DIR = "./data/cj2015";

    public boolean isLOCAL() {
        return LOCAL;
    }

    public void setLOCAL(boolean LOCAL) {
        this.LOCAL = LOCAL;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getDIR() {
        return DIR;
    }

    public void setDIR(String DIR) {
        this.DIR = DIR;
    }

    public Scanner sc;


    public void run0() {
        init();
        if (LOCAL) {
            try {
                String inputPath = DIR + File.separator + NAME + "-" + TYPE + "." + "in";
                System.setIn(new FileInputStream(inputPath));

                sc = new Scanner(System.in);

                String outputPath = DIR + File.separator + NAME + "-" + TYPE + "." + "out";
                System.setOut(new PrintStream(new FileOutputStream(outputPath)));

            } catch (Exception e) {
                e.printStackTrace();
                LOCAL = false;
            }
        } else {
            sc = new Scanner(System.in);
        }
        run();
    }

    public abstract void run();

    public abstract void init();
}

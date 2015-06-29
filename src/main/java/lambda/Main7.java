/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bitter_fox
 */
public class Main7 {
    //<editor-fold defaultstate="collapsed" desc="bootstrap">
    public static void main(String... args) {
        new Main7();
    }

    private Main7() {
        try {
            File tmp = File.createTempFile("Main", "java");
            try (PrintStream ps = new PrintStream(tmp)) {
                ps.println("public class Main {");
                ps.println("    public static void main(String... args) {");
                ps.println("        System.out.println(\"Hello World\");");
                ps.println("    }");
                ps.println("}");
            }
            printBraceLines(tmp);
            readBraceLines(tmp).forEach(System.out::println);
        } catch (IOException ex) {
            Logger.getLogger(Main7.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    //</editor-fold>

    /**
     * {や}で終わる行を出力します
     * @param file
     * @throws IOException
     */
    private void printBraceLines(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (str.endsWith("{") || str.endsWith("}")) {
                    System.out.println(str);
                }
            }
        }
    }

    /**
     * {や}で終わる行だけのリストを返します
     * @param file
     * @return
     * @throws IOException
     */
    private List<String> readBraceLines(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (str.endsWith("{") || str.endsWith("}")) {
                    lines.add(str);
                }
            }
        }
        return lines;
    }
}

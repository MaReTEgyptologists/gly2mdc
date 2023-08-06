/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gly2mdc;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hwikgren
 */
public class Gly2mdc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        String doc = filename.replaceFirst(".gly", "");
        String longString = readBytes(filename);
        String[] lines = longString.split("\n");
        String line, toFile = "";
        for (int i=0; i<lines.length; i++) {
            line = lines[i];
            if (!line.startsWith("++")) {
                line = line.replaceFirst("\\-\\!", "");
                line = line.replaceAll("_?\\-", " ");
                line = line.replaceAll("\\+[ls]", "");
                if (line.startsWith("|")) {
                    String lineNr = getMatch(line);
                    line = line.replaceFirst("\\|[^ ]* ", "");
                    line = lineNr+" - "+line;
                }
                //System.out.println(line);
                toFile += line+"\n";
            }
        }
        //System.out.println(doc);
        //System.out.println(toFile);
        printToFile(toFile, doc);
    }
    
    private static void printToFile(String toFile, String doc) throws IOException {
        String[] docArray = doc.split("/");
        
        WriteToFile writer = new WriteToFile("Result/"+docArray[docArray.length-1]+".txt");
        writer.write(toFile);
        writer.end();
    }
    
    private static String readBytes(String filename) {
        byte[] bytes = new byte[0];
        try (FileInputStream fis = new FileInputStream(filename)) {
            bytes = fis.readAllBytes();
            for (byte b : bytes) {
                //System.out.print(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String s = new String(bytes, StandardCharsets.UTF_8);
        //System.out.println(s);
        return s;
    }
    
    private static String getMatch(String line) {
        Pattern pat = Pattern.compile("\\|([^ ]*) ");
        Matcher matcher = pat.matcher(line);
        
        String match = "";
        if (matcher.find()) {
            match = matcher.group(1);
        }
        return match;
    }
}

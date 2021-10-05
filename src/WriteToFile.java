/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gly2mdc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author hwikgren
 */
public class WriteToFile {
    File file;
    BufferedWriter writer = null;

    public WriteToFile(String filename) throws IOException {
        file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        else {
            
            Files.deleteIfExists(file.toPath());
        }
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
        }
        catch (Exception e) {
            System.out.println("Error while creating writer: "+e.getMessage());
        }
    }
    
    public void write(String sentence) throws IOException {
        try {
            writer.write(sentence+"\n");
        }
        catch (Exception e) {
            System.out.println("Error while trying to write: "+e.getMessage());
        }
    }
    
    public void end() throws IOException {
        try {
            if (writer != null) {
                writer.close();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

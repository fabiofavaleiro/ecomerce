package com.fabiovaleiro.logs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Logs {
    public static void genereteLog(String message) throws IOException {

        Path path = Paths.get("C:/Users/Cliente/IdeaProjects/ecomerce/Logs");

        if(!Files.exists(path)){
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File log = new File("C:/Users/Cliente/IdeaProjects/ecomerce/Logs/logs.txt");

        if(!log.exists()){
            log.createNewFile();
        }

        FileWriter fw = new FileWriter(log, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(message);
        bw.newLine();
        bw.close();
        fw.close();

    }


}

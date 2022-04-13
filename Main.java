package com.iostream.installation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static void dirCreation(String way, StringBuilder sb) {
        File dir = new File(way);
        Date date = new Date();
        if (dir.mkdir()) {
            sb.append("Каталог \"")
                    .append(dir.getName())
                    .append("\" создан (")
                    .append(date)
                    .append(")");
        } else {
            sb.append("Каталог \"")
                    .append(dir.getName())
                    .append("\" не был создан ");
        }
        sb.append("\n");
    }

    public static void fileCreation(String way, StringBuilder sb) {
        File file = new File(way);
        Date date = new Date();
        try {
              if(file.createNewFile()) {
                  sb.append("Файл \"")
                          .append(file.getName())
                          .append("\" создан ")
                          .append(date)
                          .append(")");
              } else {
                  sb.append("Файл \"")
                          .append(file.getName())
                          .append("\" не был создан ");
              }
        } catch (IOException exception) {
            sb.append(exception.getMessage());
        }
        sb.append("\n");
    }

    public static void main(String[] args) {
        String[] dir = {
                "C://Games//src",
                "C://Games//res",
                "C://Games//savegames",
                "C://Games//temp",
                "C://Games//src//main",
                "C://Games//src//test",
                "C://Games//res//drawables",
                "C://Games//res//vectors",
                "C://Games//res//icons"
        };
        String[] files = {
                "C://Games//src//main//Main.java",
                "C://Games//src//main//Utils.java",
                "C://Games//temp//temp.txt"
        };
        StringBuilder sb = new StringBuilder();

        for (String way : dir) {
            dirCreation(way, sb);
        }
        for (String file : files) {
            fileCreation(file, sb);
        }

        String log = sb.toString();
        try {
            FileWriter writer = new FileWriter(files[2], false);
            writer.write(log);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

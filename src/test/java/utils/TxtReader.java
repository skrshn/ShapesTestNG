package utils;

import java.io.*;
import java.util.*;

public class TxtReader {
    public static BufferedReader reader;

    public static List<String> readData(String filePath) {
        List<String> list = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
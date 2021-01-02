package com.edu.zjut.util;

import java.io.*;

public class FileUtil {
    public static void fileupload(byte[] file, String filePath, String fileName) throws IOException {
        File target = new File(filePath+fileName);
        FileOutputStream out = null;
        try {
            if (!target.exists()) {

                target.getParentFile().mkdir();
                target.createNewFile();
            }

            out = new FileOutputStream(target);

            out.write(file);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

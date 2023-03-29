package edu.dzmtr.zrch.java.core.exceptions.case2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Analyze the code and refactor it (do not use try-with-resources).
 *
 * @author Dzmitry_Zorych
 */
public class Case2 {
    public static void readFile(File file) throws IOException {

        IOException exc = null;
        RandomAccessFile input = null;
        String line = null;
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (IOException e) {
            exc = e;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    if (exc == null) {
                        throw e;
                    } else {
                        exc.addSuppressed(e);
                        throw exc;
                    }
                }
            }
            if (exc != null) {
                throw exc;
            }
        }
    }
}
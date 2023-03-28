package edu.dzmtr.zrch.java.core.garbage.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Dzmitry_Zorych
 */
public class App {

    //OutOfMemoryError (with message “Java heap space”)
    public static void main(String[] args) {
        Map<Integer, String> dataMap = new HashMap<>();
        Random r = new Random();
        while (true) {
            dataMap.put(r.nextInt(), String.valueOf(r.nextInt()));
        }
    }
}
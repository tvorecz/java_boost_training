package edu.dzmtr.zrch.java.core.garbage.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Dzmitry_Zorych
 */
public class App3 {

    public static void main(String[] args) {
        Map<Integer, String> dataMap = new HashMap<>();
        Random r = new Random();
        int counter = 0;
        while (true) {
            if(counter % 100000 == 0) {
                dataMap.clear();
                System.out.println("clear");
//                System.gc();
            }
            dataMap.put(r.nextInt(), String.valueOf(r.nextInt()));
            System.out.println(counter);
            counter++;
        }
    }
}
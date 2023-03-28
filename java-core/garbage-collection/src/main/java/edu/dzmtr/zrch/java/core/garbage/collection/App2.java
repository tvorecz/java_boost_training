package edu.dzmtr.zrch.java.core.garbage.collection;

/**
 * @author Dzmitry_Zorych
 */
public class App2 {

    //java.lang.OutOfMemoryError: Requested array size exceeds VM limit
    public static void main(String[] args) throws InterruptedException {
        double[] array1 = new double[Integer.MAX_VALUE];
        //        long[] array2 = new long[Integer.MAX_VALUE];
        Thread.sleep(1000);
    }
}
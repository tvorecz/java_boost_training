package edu.dzmtr.zrch.java.core.exceptions.case1;

/**
 * @author Dzmitry_Zorych
 */
public class Case1 {
    public static void main(String[] args) {
        try {
            try {
                if (true) {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.err.print(" 1"); //executed
            } catch (Exception e) {
                System.err.print(" 2");
            } finally {
                System.err.print(" 3"); //executed
            }
        } catch (RuntimeException e) {
            System.err.print(" 4");
        } catch (Exception e) {
            System.err.print(" 5");
        } finally {
            System.err.print(" 6"); //executed
        }
    }
}
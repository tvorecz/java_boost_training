package edu.dzmtr.zrch.java.interfaces.core.generics.case11;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case11 {
    public static void main(String[] args) {
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        n.setData("Hello");     // Causes a ClassCastException to be thrown.
        Integer x = mn.data;
    }
}
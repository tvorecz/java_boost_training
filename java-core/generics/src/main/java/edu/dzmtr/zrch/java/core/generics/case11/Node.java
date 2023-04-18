package edu.dzmtr.zrch.java.core.generics.case11;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Node<T> {
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}
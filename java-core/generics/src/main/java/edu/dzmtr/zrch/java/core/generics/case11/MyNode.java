package edu.dzmtr.zrch.java.core.generics.case11;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
    }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
package edu.dzmtr.zrch.java.core.serialization.case1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Simple Serialization and Deserialization example
 *
 * @author Dzmitry_Zorych
 */
public class SimpleSerializationAndDeserializationExample {
    public static final String PATH = "C:\\Users\\Dzmitry_Zorych\\Downloads\\tmp";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeExample();
        deserializeExample();
    }

    public static void serializeExample() throws IOException {
        FileOutputStream f = new FileOutputStream(PATH);
        ObjectOutput s = new ObjectOutputStream(f);
        s.writeObject("Today");
        s.writeObject(new Date());
        s.writeChar('a');
        s.flush();
        s.close();
    }

    public static Object[] deserializeExample() throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(PATH);
        ObjectInputStream s = new ObjectInputStream(in);
        String today = (String) s.readObject();
        Date date = (Date) s.readObject();
        Character c = s.readChar();
        s.close();
        return new Object[] { today, date, c };
    }
}
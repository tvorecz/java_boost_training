package edu.dzmtr.zrch.java.core.exceptions.case3;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Dzmitry_Zorych
 */

public class CloseableHandler implements Closeable {

    public void handle() throws HandlerException {
        throw new HandlerException("HandlerException");
    }

    @Override
    public void close() throws IOException {
        throw new IOException("IOException");
    }
}
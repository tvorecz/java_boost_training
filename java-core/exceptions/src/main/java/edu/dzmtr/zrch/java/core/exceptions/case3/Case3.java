package edu.dzmtr.zrch.java.core.exceptions.case3;

import java.io.IOException;

/**
 * Create suppressed exception example.
 *
 * @author Dzmitry_Zorych
 */
public class Case3 {

    public static void handle() throws Exception {
        HandlerException mainException = null;
        CloseableHandler handler = new CloseableHandler();

        try {
            handler.handle();
        } catch (HandlerException e) {
            System.out.println(e);
            mainException = e;
        } finally {
            try {
                handler.close();
            } catch (IOException e) {
                System.out.println(e);
                if (mainException != null) {
                    mainException.addSuppressed(e);
                    throw mainException;
                }

                throw e;
            }
        }
    }

    public static void handleWithResources() throws HandlerException, IOException {
        try (CloseableHandler handler = new CloseableHandler()) {
            handler.handle();
        } catch (HandlerException e) {
            System.out.println(e);
            throw e;
        }
    }
}
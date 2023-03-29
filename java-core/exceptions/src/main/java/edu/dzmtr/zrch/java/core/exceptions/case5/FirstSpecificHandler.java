package edu.dzmtr.zrch.java.core.exceptions.case5;

/**
 * @author Dzmitry_Zorych
 */
public class FirstSpecificHandler extends CommonHandler {

    @Override
    public void handle()
        throws SpecificException { //we can use more specific exception in overridden method definition of child class
        try {
            super.handle();
        } catch (CommonHandlerException e) {
            throw new SpecificException(e);
        }
    }
}
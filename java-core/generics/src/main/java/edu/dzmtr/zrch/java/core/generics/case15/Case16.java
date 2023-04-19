package edu.dzmtr.zrch.java.core.generics.case15;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

/**
 * TODO description
 *
 * @author Dzmitry_Zorych
 */
public class Case16 {

    public static void main(String[] args) {
        Cage<Cat> cage = new Cage<>();
        CatCage catCage = new CatCage();
        AllCatCage allCatCage = new AllCatCage();

        System.out.println(cage.getClass().getTypeParameters()[0]); //T
        System.out.println(catCage.getClass().getTypeParameters().length); //0
        System.out.println(allCatCage.getClass().getTypeParameters()[0]); //T
        System.out.println(((Class) cage.getClass()
            .getGenericSuperclass()).toString());//class java.lang.Object
        System.out.println(((ParameterizedType) catCage.getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0]); //class edu.dzmtr.zrch.java.core.generics.case15.Cat
        System.out.println(
            ((ParameterizedType) allCatCage.getClass().getGenericSuperclass()).getActualTypeArguments()[0]); //T

        IHandler<String> stringIHandler = new HandlerImpl();
        HandlerImpl stringHandler = new HandlerImpl();
        AnotherHandlerImpl<String> stringAnotherHandler = new AnotherHandlerImpl<>();
        BoundedHandler<String> stringBoundedHandler = new BoundedHandler<>();

        System.out.println(stringHandler.getClass().getTypeParameters().length);//0
        System.out.println(
            ((ParameterizedType) stringHandler.getClass()
                .getGenericInterfaces()[0]).getActualTypeArguments()[0]); //class java.lang.String

        System.out.println(stringIHandler.getClass().getTypeParameters().length);//0
        System.out.println(
            ((ParameterizedType) stringIHandler.getClass()
                .getGenericInterfaces()[0]).getActualTypeArguments()[0]); //class java.lang.String

        System.out.println(stringAnotherHandler.getClass().getTypeParameters()[0]);//T
        System.out.println(
            ((ParameterizedType) stringAnotherHandler.getClass()
                .getGenericInterfaces()[0]).getActualTypeArguments()[0]); //T

        System.out.println(stringBoundedHandler.getClass().getTypeParameters()[0]);//T
        System.out.println(
            ((ParameterizedType) stringBoundedHandler.getClass()
                .getGenericInterfaces()[0]).getActualTypeArguments()[0]); //T

        System.out.println(((TypeVariable) ((ParameterizedType) stringBoundedHandler.getClass()
            .getGenericInterfaces()[0]).getActualTypeArguments()[0]).getBounds()[0].getTypeName());//java.lang.String
    }

    //output
    //T
    //0
    //T
    //class java.lang.Object
    //class edu.dzmtr.zrch.java.core.generics.case15.Cat
    //T
    //0
    //class java.lang.String
    //0
    //class java.lang.String
    //T
    //T
    //T
    //T
}
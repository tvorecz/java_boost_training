package edu.dzmtr.zrch.java.core.generics.case1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dzmitry_Zorych
 */
public class SimpleGenericCasting {

    public static void handle() {
        List<String> stringList = new ArrayList<>();

        //1 case. Non-compilable casting. List<String> is not extends List<CharSequence>
//        List<CharSequence> charSequenceList = (List<CharSequence>) stringList;

        //2 case. Non-compilable casting. List<CharSequence> is not a super-type of List<String>
//        List<CharSequence> charSequenceList = new ArrayList<>();
//        stringList = (List<String>) charSequenceList;


        //3 case. Compilable narrowing casting since List<String> is subtype of List<? extends CharSequence>
        List<? extends CharSequence> superCharSequenceList = new ArrayList<>();

        stringList = (List<String>) superCharSequenceList;

        //4 case. Compilable widening casting since List<? extends CharSequence> is a super-type of List<String>
        List<? extends CharSequence> superCharSequenceList2 = new ArrayList<>();

        superCharSequenceList2 = stringList;

        //5 case. Compilable narrowing casting since ArrayList<String> is subtype of List<? extends CharSequence>
        List<? extends CharSequence> superCharSequenceArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList = (ArrayList<String>) superCharSequenceList;

        //6 case. Compilable widening casting since List<? extends CharSequence> is a super-type of ArrayList<String>
        List<? extends CharSequence> superCharSequenceArrayList2 = new ArrayList<>();

        superCharSequenceArrayList2 = stringArrayList;
    }
}
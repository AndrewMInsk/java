package com.javarush.task.task20.task2028;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 4; i++) {
            list.add(String.valueOf(i));
        }
        ((CustomTree)list).show();

        System.out.println("The list size is " + list.size());
        list.add("qwe");
        ((CustomTree)list).show();

        System.out.println("The list size is " + list.size());

        list.remove("qwe");
        ((CustomTree)list).show();

        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));

        list.remove("3");
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("8"));

        list.add("16");
        System.out.println("The expected parent is 9. The actual parent is " + ((CustomTree) list).getParent("16"));


        list.remove("4");
        list.remove("5");
        list.remove("6");
        System.out.println("Expected: true. Actual: " + list.add("20"));
        System.out.println("The expected parent is 1. The actual parent is " + ((CustomTree) list).getParent("20"));


            List m = Arrays.asList(1,3,18, 45,'c', "roma", null);
            System.out.println(m.size());//7
            List test = m;
        test.add("end");
            System.out.println(test.size());//8

            for (int i=0;i<test.size();i++)
            {
                System.out.println(test.get(i));
            }

    }
}

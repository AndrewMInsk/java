package com.javarush.task.task2028;

public class Solution {
    public static void main(String[] args) {
        //List<String> list = new CustomTree(new CustomTree.Entry("0"));
        CustomTree list = new CustomTree(new CustomTree.Entry("0"));

        for (int i = 1; i < 20; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println(list.getParent("2"));
        list.show();
        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 3. The actual parent is" +
                " " + ((CustomTree) list).getParent("8"));
        System.out.println("The expected parent is null. The actual parent is" +
                " " + ((CustomTree) list).getParent("20"));
    }
}

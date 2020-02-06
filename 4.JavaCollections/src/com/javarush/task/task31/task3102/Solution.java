package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        ArrayDeque<String> queue = new ArrayDeque<String>();
        ArrayDeque<String> queue2 = new ArrayDeque<String>();
        queue.add(root);
        while (!queue.isEmpty()){
            String test = queue.removeFirst();
            File test3 = new File(test);
            if(test3.isFile()){
                queue2.add(test);
            }
            if(test3.isDirectory()){
                for (File file: test3.listFiles()) {
                    queue.add(file.getAbsolutePath());
                }
            }
        }

        //System.out.println(queue);
        List<String> res = new ArrayList<String>(queue2);
        System.out.println(res);
        return res;

    }

    public static void main(String[] args) throws IOException {
        getFileTree("D:\\test");
        
    }
}

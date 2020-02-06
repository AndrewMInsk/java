package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Externalizable, Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) {

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        for(int i=0;i<edges.size();i++){
            out.writeObject(edges.get(i));
        }
        out.writeInt(node);
        out.writeInt(edges.size());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int sizer = in.readInt();

        for(int i=0;i<sizer;i++){
            edges.add((Solution) in.readObject());
        }
        node = in.readInt();
    }
}

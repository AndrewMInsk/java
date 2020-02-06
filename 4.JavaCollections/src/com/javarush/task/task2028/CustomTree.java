package com.javarush.task.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
     Entry<String> root;
    public List<Entry<String>> listFinal = new LinkedList<Entry<String>>();
    int sizer = this.listFinal.size();

    public void show(){
        for (Entry<String> item : this.listFinal)
        {
            System.out.println(item);
        }
    }
    public CustomTree(Entry<String> root) {
        this.root = root;
        listFinal.add(this.root);
    }
    public CustomTree() {
        this.root = new Entry<String>("0");
        listFinal.add(this.root);
    }

    public Entry<String> finderPlace(int number){
        //System.out.println(rooter);

        if(listFinal.get(number).isAvailableToAddChildren()){
            return listFinal.get(number);
        }
        else{
            return finderPlace(number+1);
            //return null;
        }
    }

    @Override
    public boolean add(String s) {
        //System.out.println("!");
        Entry<String> temp = new Entry<String>(s);
        temp.parent = finderPlace(0);
        //System.out.println(temp.parent);

        if(temp.parent.availableToAddLeftChildren) {
            temp.parent.availableToAddLeftChildren = false;
            temp.parent.leftChild = temp;
        }
        else {
            temp.parent.availableToAddRightChildren = false;
            temp.parent.rightChild = temp;
        }

        this.listFinal.add(temp);
        sizer++;
        //System.out.println(listFinal);
        return true;
    }

    public String getParent(String s) {
        Entry temp = new Entry(s);
        for (Entry<String> item : listFinal)
        {
            if(item!=null&&item.elementName.equals(s)){
                return item.parent.elementName;

            }
        }
        return null;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.sizer;
    }

     static class Entry<T> implements Serializable{
         @Override
         public String toString() {
             return "Entry{" +
                     "elementName='" + elementName + '\'' +
                     ", parent=" + parent +
                     '}';
         }

         String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }
        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren||availableToAddRightChildren;
        }
    }
}

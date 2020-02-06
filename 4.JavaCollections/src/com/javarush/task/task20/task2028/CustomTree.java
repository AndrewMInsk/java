package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
     Entry<String> root;
    public List<Entry> listFinal = new LinkedList<Entry>();
    public List<Entry> removeArray = new LinkedList<Entry>();
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
    public void removeRec(Entry toRemove){
      //  System.out.println(toRemove);
        Iterator<Entry> iterator = listFinal.iterator();
        while (iterator.hasNext()) {
            Entry entr = iterator.next();

            if(entr.parent!=null&&entr.parent.elementName.equals(toRemove.elementName)){
              //  System.out.println("!");
                removeArray.add(entr);
                removeRec(entr);
            }
            List s1=new ArrayList();
            s1.add(null);
            listFinal.removeAll(s1);

        }
    }


    @Override
    public boolean remove(Object o) {

        if(!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        else{
            String temp = (String) o;

            Iterator<Entry> iterator = listFinal.iterator();
            while (iterator.hasNext()){
                try{
                Entry next = iterator.next();

                if(next!=null&&next.elementName.equals(temp)){
                    removeArray.add(next);
                    removeRec(next);
                    if(next.parent.leftChild!=null&&next.parent.leftChild.elementName.equals(temp)){
                        next.parent.leftChild=null;
                        next.parent.availableToAddLeftChildren=true;
                        listFinal.set(listFinal.indexOf(next),null);
                    }
                    else if(next.parent.rightChild!=null){
                        next.parent.rightChild=null;
                        next.parent.availableToAddRightChildren=true;
                        listFinal.set(listFinal.indexOf(next),null);
                    }
                }
                }
                catch(ConcurrentModificationException e){
                    System.out.println("...");
                }

            }



        }
       // System.out.println("ТУТ");
        for(Entry item: removeArray)
        {
            //System.out.println(item);
            if(listFinal.indexOf(item)!=-1) {
                listFinal.set(listFinal.indexOf(item), null);
            }
        }
      //  System.out.println("ТУТ");


        List s1=new ArrayList();
        s1.add(null);
        listFinal.removeAll(s1);
        return true;
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
        return  this.listFinal.size()-1;
    }

     static class Entry<T> implements Serializable{
         @Override
         public String toString() {
             return "Entry{" +
                     "elementName='" + elementName + '\'' +
                     ", availableToAddLeftChildren=" + availableToAddLeftChildren +
                     ", availableToAddRightChildren=" + availableToAddRightChildren +
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

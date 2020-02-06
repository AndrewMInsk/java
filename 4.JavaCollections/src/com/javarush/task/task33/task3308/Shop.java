package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "Shop")
@XmlRootElement
public class Shop {

    public String[] secretData;

    public Goods goods;
    public int count;
    public double profit;
    static class Goods{
        public List<String> names;

    }

}

package demo;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Demo> list = new ArrayList<Demo>();
        Collections.sort(list, new Comparator<Demo>() {
            public int compare(Demo d1, Demo d2){
                return d1.toString().compareTo(d2.toString());
            }

        });

    }
}


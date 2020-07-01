package com.concurrentmodificationexception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        for (int i=0; i< 10; i++) {
            myList.add("" + i);
        }

        for (String str: myList) {
            System.out.println(str);
            myList.remove("" + 3);
        }
        System.out.println("/-----/");
        Iterator<String> it = myList.iterator();
        while(it.hasNext()) {
            String item = it.next();
            System.out.println(item);
            //it.remove();
            myList.remove("" + 3); // allowed in thread safe CopyOnWriteArrayList
        }

        it = myList.iterator();
        while(it.hasNext()) {
            String item = it.next();
            System.out.println(item);
            //it.remove(); // not allowed in CopyOnWriteArrayList
            //myList.remove("" + 3);
        }
    }
}

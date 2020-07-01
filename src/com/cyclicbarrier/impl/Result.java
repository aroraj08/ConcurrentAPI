package com.cyclicbarrier.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

   private List<String> resultList = new ArrayList<>();

   public void addPair(int row, int column) {
       resultList.add(row + "," + column);
   }

   public List<String>  getResult() {
       return resultList;
   }
}

package com.mmall.MainShiTi.sorter;

import java.util.List;

public class TestSorter {
    public static void main(String[] args) {
        Integer[] intArray = {1,10,5,6,2,67,8,12};
        new BubbleSorter().sort(intArray);
        for(Integer integer:intArray){
            System.out.print(integer + "  ");
        }

    }
}

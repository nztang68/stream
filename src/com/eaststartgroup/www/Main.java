package com.eaststartgroup.www;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main mainInstance = new Main();
        mainInstance.oldSort();
        mainInstance.lambdaSort();
        mainInstance.oldFilter();
        mainInstance.lambdaFilter();
    }

    private void lambdaFilter() {
        System.out.println("Lambda way!");
        List<Integer> unFilteredList = generatedRandomList();
        System.out.println(unFilteredList);
        List<Integer> filteredList = unFilteredList.stream()
                .filter(x -> x > 50)
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }

    private void oldFilter() {
        List<Integer> unFilteredList = generatedRandomList();
        System.out.println("Old way!");
        System.out.println(unFilteredList);
        List<Integer> filteredList = new ArrayList<>();
        for (Integer number : unFilteredList
             ) {
            if (number > 50) {
                filteredList.add(number);
            }
        }
        System.out.println(filteredList);
    }

    private void lambdaSort() {
        List<Integer> theList = generatedRandomList();
        System.out.println("Lambda way!");
        System.out.println(theList);
        theList.sort((x,y) -> x.compareTo(y));
        System.out.println(theList);
    }

    private void oldSort() {
        List<Integer> unsortedList = generatedRandomList();
        System.out.println("Old way!");
        System.out.println(unsortedList);
        Collections.sort(unsortedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(unsortedList);
        
    }

    private List<Integer> generatedRandomList() {
        List<Integer> numberList = new ArrayList<>();
        Random rGenerator = new Random();
        for (int i = 0; i < 20; i++) {
            numberList.add(rGenerator.nextInt(255));
        }
        return numberList;

    }
}

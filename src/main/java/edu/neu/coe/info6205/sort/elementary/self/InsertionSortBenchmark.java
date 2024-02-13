package edu.neu.coe.info6205.sort.elementary.self;


import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Config;

public class InsertionSortBenchmark {

    public static void main(String[] args) throws Exception {

        executeCases();
    }

    private static void executeCases() {
        Integer[] arr1 = new Integer[]{4,7,1,10,15};
        System.out.println("Test 1: Inital Array");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + ", ");
        }
//        Config.load(InsertionSortBenchmark.class);
//        BaseHelper<Integer> helper = new BaseHelper<>("InsertionSort", arr1.length, Config.load(InsertionSort.class));
        InsertionSort insertionSort = new InsertionSort<Integer>();
          insertionSort.sort(arr1,0, arr1.length);
        System.out.println("Test 1: Sorted Array");

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + ", ");
        }
    }
}

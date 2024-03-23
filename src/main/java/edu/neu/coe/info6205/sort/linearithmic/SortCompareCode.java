package edu.neu.coe.info6205.sort.linearithmic;

import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.HelperFactory;
import edu.neu.coe.info6205.sort.InstrumentedHelper;
import edu.neu.coe.info6205.sort.elementary.HeapSort;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.SorterBenchmark;
import edu.neu.coe.info6205.util.TimeLogger;

public class SortCompareCode {

    public static void main(String[] args) {

        final Config config = Config.setupConfig("true", "0", "1", "", "");
//        InstrumentedHelper helper = new InstrumentedHelper("Merge Sort",config);

        int startSize = 10000;
        int endSize = 320000;
        mergeSortBenchmark(startSize,endSize,config);
        System.out.println("-------END OF MERGE SORT----------");
        quickSortBenchmark(startSize,endSize,config);
        System.out.println("-------END OF QUICK SORT----------");
        heapSortBenchMark(startSize,endSize,config);
        System.out.println("-------END OF HEAP SORT----------");
        System.out.println("-------FINSHED----------");

    }

    private static void heapSortBenchMark(int startSize, int endSize, Config config) {
        String sortingName = "Heap Sort";
        System.out.println(sortingName+" execution");
        for(int i = startSize; i <= endSize; i= i*2) {
            Helper<Integer> helper =  HelperFactory.create("Heap Sort",i,config);
            HeapSort<Integer> heapSort = new HeapSort<>(helper);
            int finalI = i;
            Integer[] randArray= helper.random(Integer.class, r -> r.nextInt(finalI));
            int[] blankArray = new int[5];
            SorterBenchmark benchmark = new SorterBenchmark<>(Integer.class,(Integer[] arr) -> {return arr; },heapSort,randArray,1,timeLoggersLinearithmic);
            double time = benchmark.run(i);

            //print results
            System.out.println("Array Size: "+ i);
            System.out.println("Time "+ time);
            System.out.println(sortingName.toLowerCase()+"-"+"HITS ");
            System.out.println(sortingName+"-"+"hits(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("hits").mean());
            System.out.println(sortingName+"-"+"hits(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("hits").normalizedMean());
            System.out.println(sortingName+"-"+"hits(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("hits").stdDev());
            System.out.println("------------");
            System.out.println(sortingName.toLowerCase()+"-"+"SWAPS ");
            System.out.println(sortingName+"-"+"swaps(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("swaps").mean());
            System.out.println(sortingName+"-"+"swaps(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("swaps").normalizedMean());
            System.out.println(sortingName+"-"+"swaps(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("swaps").stdDev());
            System.out.println("------------");
            System.out.println(sortingName.toLowerCase()+"-"+"COMPARES ");
            System.out.println(sortingName+"-"+"compares(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("compares").mean());
            System.out.println(sortingName+"-"+"compares(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("compares").normalizedMean());
            System.out.println(sortingName+"-"+"compares(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("compares").stdDev());
            System.out.println("------------");
            System.out.println(sortingName.toLowerCase()+"-"+"FIXES ");
            System.out.println(sortingName+"-"+"fixes(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("fixes").mean());
            System.out.println(sortingName+"-"+"fixes(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("fixes").normalizedMean());
            System.out.println(sortingName+"-"+"fixes(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("fixes").stdDev());


        }

    }

    private static void quickSortBenchmark(int startSize, int endSize, Config config) {
        String sortingName = "Quick Sort Dual Pivot";
        System.out.println(sortingName+" execution");
        for(int i = startSize; i < endSize; i= i*2) {
            Helper<Integer> helper =  HelperFactory.create("Merge Sort",i,config);
            QuickSort_DualPivot<Integer> quickSort = new QuickSort_DualPivot<>(helper);
            int finalI = i;
            Integer[] randArray= helper.random(Integer.class, r -> r.nextInt(finalI));
            int[] blankArray = new int[5];
            SorterBenchmark benchmark = new SorterBenchmark<>(Integer.class,(Integer[] arr) -> {return arr; },quickSort,randArray,1,timeLoggersLinearithmic);
            double time = benchmark.run(i);

            //print results
            System.out.println("Array Size: "+ i);
            System.out.println("Time "+ time);
            System.out.println(sortingName.toLowerCase()+"-"+"HITS ");
            System.out.println(sortingName+"-"+"hits(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("hits").mean());
            System.out.println(sortingName+"-"+"hits(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("hits").normalizedMean());
            System.out.println(sortingName+"-"+"hits(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("hits").stdDev());
            System.out.println("------------");
            System.out.println(sortingName.toLowerCase()+"-"+"SWAPS ");
            System.out.println(sortingName+"-"+"swaps(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("swaps").mean());
            System.out.println(sortingName+"-"+"swaps(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("swaps").normalizedMean());
            System.out.println(sortingName+"-"+"swaps(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("swaps").stdDev());
            System.out.println("------------");
            System.out.println(sortingName.toLowerCase()+"-"+"COMPARES ");
            System.out.println(sortingName+"-"+"compares(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("compares").mean());
            System.out.println(sortingName+"-"+"compares(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("compares").normalizedMean());
            System.out.println(sortingName+"-"+"compares(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("compares").stdDev());
            System.out.println("------------");
            System.out.println(sortingName.toLowerCase()+"-"+"FIXES ");
            System.out.println(sortingName+"-"+"fixes(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("fixes").mean());
            System.out.println(sortingName+"-"+"fixes(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("fixes").normalizedMean());
            System.out.println(sortingName+"-"+"fixes(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("fixes").stdDev());


        }

    }

    private static void mergeSortBenchmark(int startSize, int endSize, Config config) {
        String sortingName = "Merge Sort";
        System.out.println(sortingName+" execution");
        for(int i = startSize; i < endSize; i= i*2) {
            Helper<Integer> helper =  HelperFactory.create("Merge Sort",i,config);
            MergeSort<Integer> mergeSort = new MergeSort<>(helper);
            int finalI = i;
            Integer[] randArray= helper.random(Integer.class, r -> r.nextInt(finalI));
            int[] blankArray = new int[5];
            SorterBenchmark benchmark = new SorterBenchmark<>(Integer.class,(Integer[] arr) -> {return arr; },mergeSort,randArray,1,timeLoggersLinearithmic);
            double time = benchmark.run(i);

            //print results
            System.out.println("Array Size: "+ i);
            System.out.println("Time "+ time);
            System.out.println(sortingName.toLowerCase()+"-"+"HITS ");
            System.out.println(sortingName+"-"+"hits(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("hits").mean());
            System.out.println(sortingName+"-"+"hits(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("hits").normalizedMean());
            System.out.println(sortingName+"-"+"hits(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("hits").stdDev());
            System.out.println("------------");
            System.out.println(sortingName.toLowerCase()+"-"+"SWAPS ");
            System.out.println(sortingName+"-"+"swaps(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("swaps").mean());
            System.out.println(sortingName+"-"+"swaps(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("swaps").normalizedMean());
            System.out.println(sortingName+"-"+"swaps(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("swaps").stdDev());
            System.out.println("------------");
            System.out.println(sortingName.toLowerCase()+"-"+"COMPARES ");
            System.out.println(sortingName+"-"+"compares(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("compares").mean());
            System.out.println(sortingName+"-"+"compares(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("compares").normalizedMean());
            System.out.println(sortingName+"-"+"compares(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("compares").stdDev());
            System.out.println("------------");
            System.out.println(sortingName.toLowerCase()+"-"+"FIXES ");
            System.out.println(sortingName+"-"+"fixes(mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("fixes").mean());
            System.out.println(sortingName+"-"+"fixes(Norm Mean): "+((InstrumentedHelper)helper).getStatPack().getStatistics("fixes").normalizedMean());
            System.out.println(sortingName+"-"+"fixes(std): "+((InstrumentedHelper)helper).getStatPack().getStatistics("fixes").stdDev());


        }

    }
    public final static TimeLogger[] timeLoggersLinearithmic = {
            new TimeLogger("Raw time per run (mSec): ", (time, n) -> time),
    };
}

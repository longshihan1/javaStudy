package Thread.ThreadDemo.bingxingtusuanfa.sousuo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by dell on 2017/2/28.
 */
public class TestSearch {
    static int[] arr;

    public static void main(String args[]) {

    }

    public static int pSearch(int searchValue) throws ExecutionException, InterruptedException {
        int subArrsize = arr.length / Search.Thread_num + 1;
        List<Future<Integer>> re = new ArrayList<Future<Integer>>();
        for (int i = 0; i < arr.length; i += subArrsize) {
            int end = i + subArrsize;
            if (end >= arr.length) end = arr.length;
            re.add(Search.pool.submit(new SearchTask(searchValue, i, end)));
        }
        for (Future<Integer> fu : re) {
            if (fu.get() >= 0) return fu.get();
        }
        return -1;

    }
}

package rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class create001 {
    public static void main(String[] args) {
//        final int[] x = {1};
//        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
//            for (int i = 1; i < 5; i++) {
//                emitter.onNext(i);
//            }
//
//        }).map(integer -> {
//            x[0] *= integer;
//            return x[0];
//        }).subscribe(s -> System.out.println("" + s));

        HeapSort hs = new HeapSort();
        int[] array = {87,45,78,32,17,65,53,9,122};
        System.out.print("构建大根堆  ：");
        hs.toString(hs.buildMaxHeap(array));
        System.out.print("\n"+"删除堆顶元素：");
        hs.toString(hs.deleteMax(array));
        System.out.print("\n"+"插入元素63  :");
        hs.toString(hs.insertData(array, 63));
        System.out.print("\n"+"大根堆排序  ：");
        hs.toString(hs.heapSort(array));

    }

}

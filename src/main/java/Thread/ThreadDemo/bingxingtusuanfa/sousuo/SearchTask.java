package Thread.ThreadDemo.bingxingtusuanfa.sousuo;

import java.util.concurrent.Callable;

/**
 * 分片搜索
 * Created by dell on 2017/2/28.
 */
public class SearchTask implements Callable<Integer> {
    int begin, end, searchValue;

    public SearchTask(int begin, int end, int searchValue) {
        this.begin = begin;
        this.end = end;
        this.searchValue = searchValue;
    }

    @Override
    public Integer call() throws Exception {
        int re = Search.search(searchValue, begin, end);
        return re;
    }


}

package mian170821.DataSource;

/**
 * Created by dell on 2017/8/21.
 * 普通的数组
 */
public class GeneralArray {
    private int[] a;
    private int size;
    private int nElem;

    public GeneralArray(int max) {
        this.a = new int[max];
        this.size = max;
        this.nElem = 0;
    }

    public boolean find(int searchNum) {


        int j;
        for (j = 0; j < nElem; j++) {
            if (a[j] == searchNum) {
                break;
            }
        }
        if (j == nElem) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insert(int value) {
        if (nElem == size) {
            System.out.println("数组已满 ");
            return false;
        }
        a[nElem] = value;
        nElem++;
        return true;
    }

    public boolean delete(int value) {
        int j;
        for (j = 0; j < nElem; j++) {
            if (a[j] == value) {
                break;
            }
        }
        if (j == nElem) {
            return false;
        }
        if (nElem == size) {
            for (int k = j; k < nElem - 1; k++) {
                a[k] = a[k + 1];
            }
        } else {
            for (int k = j; k < nElem; k++) {
                a[k] = a[k + 1];
            }
        }
        nElem--;
        return true;
    }

    /**
     * 二分查找
     * @param searchNum
     * @return
     */
    public int find(long searchNum){
        int lower = 0;
        int upper = nElem - 1;
        int curr;



        while (true) {
            curr = (lower + upper) / 2;
            if(a[curr] == searchNum){
                return curr;
            }else if(lower > upper){
                return -1;
            }else {
                if(a[curr] < searchNum){
                    lower = curr + 1;
                }else {
                    upper = curr - 1;
                }
            }
        }
    }

    public void display() {   //打印整个数组
        for (int i = 0; i < nElem; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println("");
    }
}

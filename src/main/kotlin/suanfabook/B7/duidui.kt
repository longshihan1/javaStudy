package suanfabook.B7

/*
     * (最大)堆的向下调整算法
     *
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     *     end   -- 截至范围(一般为数组中最后一个元素的索引)
     */
fun maxHeapDown(a: IntArray, start: Int, end: Int) {
    var c = start            // 当前(current)节点的位置
    var l = 2 * c + 1        // 左(left)孩子的位置
    val tmp = a[c]            // 当前(current)节点的大小

    while (l <= end) {
        // "l"是左孩子，"l+1"是右孩子
        if (l < end && a[l] < a[l + 1])
            l++        // 左右两孩子中选择较大者，即m_heap[l+1]
        if (tmp >= a[l])
            break        // 调整结束
        else {            // 交换值
            swap(a,c,l)
        }
        c = l
        l = 2 * l + 1
    }
}

fun minHeapDown(a: IntArray, start: Int, end: Int) {
    var c = start            // 当前(current)节点的位置
    var l = 2 * c + 1        // 左(left)孩子的位置
    val tmp = a[c]            // 当前(current)节点的大小

    while (l <= end) {
        // "l"是左孩子，"l+1"是右孩子
        if (l < end && a[l] > a[l + 1])
            l++        // 左右两孩子中选择较小者
        if (tmp <= a[l])
            break        // 调整结束
        else {            // 交换值
            swap(a,c,l)
        }
        c = l
        l = 2 * l + 1
    }
}
fun swap(arr: IntArray, a: Int, b: Int) {
    val temp = arr[a]
    arr[a] = arr[b]
    arr[b] = temp
}

fun sort(arr: IntArray, left: Int, right: Int, temp: IntArray) {
    if (left<right){
        var mid:Int=(left+right)/2
        sort(arr,left, mid, temp)
        sort(arr,mid+1, right, temp)
        mergeNum(arr,left,mid,right,temp)



    }
}

fun mergeNum(arr: IntArray,left: Int, mid: Int, right: Int,temp:IntArray) {
    var i = left//左序列指针
    var j = mid + 1//右序列指针
    var t = 0//临时数组指针
    var left1 = left
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[t++] = arr[i++]
        } else {
            temp[t++] = arr[j++]
        }
    }
    while (i <= mid) {//将左边剩余元素填充进temp中
        temp[t++] = arr[i++]
    }
    while (j <= right) {//将右序列剩余元素填充进temp中
        temp[t++] = arr[j++]
    }
    t = 0
    //将temp中的元素全部拷贝到原数组中
    while (left1 <= right) {
        arr[left1++] = temp[t++]
    }
}
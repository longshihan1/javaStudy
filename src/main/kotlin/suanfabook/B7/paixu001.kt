package suanfabook.B7

//插入排序
fun main(args: Array<String>) {
    var nums = intArrayOf(5, 2, 58, 78, 6, 3, 45, 10, 34, 4)
//    charu(nums)
//    xier(nums)
    nums = intArrayOf(20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80)
//    dui(nums)
//    guibing(nums)
    kuaipai(nums)
    println(nums.joinToString())
}


/**
 * 插入排序
 */
fun charu(nums: IntArray) {
    for (index in 0..nums.size) {
        for (index1 in (index + 1) until nums.size) {
            if (nums[index] > nums[index1]) {
                var x = nums[index1]
                nums[index1] = nums[index]
                nums[index] = x
            }
        }

    }

    println("插入排序：" + arrayOf(nums))
}


fun xier(nums: IntArray) {
    var gap = 3
    while (gap > 0) {
        for (i in gap until nums.size) {
            var temp = nums[i]
            var j = i - gap
            while (j >= 0 && temp < nums[j]) {
                nums[j + gap] = nums[j]
                j -= gap
            }
            nums[j + gap] = temp
        }
        gap /= 3
    }

    println("希尔排序：$nums")
}

fun dui(nums: IntArray) {
    var i: Int
    var n = nums.size
    for (k in n / 2 - 1 downTo 0) {
        minHeapDown(nums, k, n - 1)
    }

    for (w in n - 1 downTo 0) {
        swap(nums, 0, w)
        // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
        // 即，保证a[i-1]是a[0...i-1]中的最大值。
        minHeapDown(nums, 0, w - 1)
    }
}


fun guibing(nums: IntArray) {
    var temp = IntArray(nums.size)
    sort(nums,0,nums.size-1,temp)

}


fun kuaipai(nums: IntArray){
    quickSort(nums,0,nums.size-1)


}

fun quickSort(nums: IntArray,low:Int,high:Int){
    var l=low
    var h=high
    var temp=nums[low]
    while (l<h){
        while(l<h&&nums[h]>temp)
            h--
        if (l<h){
            nums[l]=nums[h]
            l++
        }
        while (l<h&&nums[l]<=temp){
            l++
        }
        if (l<h){
            nums[h]=nums[l]
            h--
        }
    }
    nums[l]=temp
    if (l-1>low) quickSort(nums,low,l-1)
    if (h+1<high) quickSort(nums,h+1,high)

}






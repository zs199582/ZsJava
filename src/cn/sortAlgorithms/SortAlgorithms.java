package cn.sortAlgorithms;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SortAlgorithms<T extends Comparable<T>>extends Sort<T> {
    public static void main(String[] args)
    {
        SortAlgorithms sortAlgorithms = new SortAlgorithms<Integer>();
        int[] nums = {6,5,1,6,10,56,7};
//        sortAlgorithms.reOrderArray(nums);
        sortAlgorithms.quickSortExercise2(nums);
        System.out.println(Arrays.toString(nums));
    }
    //region选择排序
    public void selectSort(T[] arrs)
    {
        int min;
        for(int i = 0;i<arrs.length;i++)
        {
            min = i;
            //从后面所有的元素里选一个最小的
            for(int j = i+1;j<arrs.length;j++)
            {
                if(less(arrs[j],arrs[min])) {
                    min = j;
                }
            }
            //把最小值和当前值互换
            swap(arrs,i,min);
        }
    }
    //endregion
    //region冒泡排序
    public void bubble(T[] arrs)
    {
        for(int i = 0;i<arrs.length;i++)
        {
            for(int j = i+1;j<arrs.length;j++)
            {
                if(less(arrs[j],arrs[i]))
                    swap(arrs,i,j);
            }
        }
    }
    //endregion
    //region插入排序
    public void inserSort(T[] arrs)
    {
        for(int i = 1;i<arrs.length;i++)
        {
            if(!less(arrs[i],arrs[i-1]))
            {
                for(int j = i;j>0&&less(arrs[j],arrs[j-1]);j--)
                {
                        swap(arrs,j,j-1);
                }
            }
        }
    }
    //endregion
    //region希尔排序
    public void hillSort(T[] arrs)
    {
        int h = 1;
        int length = arrs.length;
        if(h<length/3)
            h = h*3+1;
        while(h>=1)
        {
            for(int i = h;i<length;i++)
            {
                for(int j = i;j>=h;j-=h)  //这里相当于做直接插入排序
                {
                    if(less(arrs[j],arrs[j-h]))
                        swap(arrs,j,j-h);
                }
            }
            h = h/3;
        }
    }
    //endregion
    //region 快速排序
    public void quickSort(T[] arrs)
    {
        if(arrs.length == 0) return;
        qucikSortBody(arrs,0,arrs.length-1);
    }
    public void qucikSortBody(T[] arrs,int i,int j)
    {
        if(j<=i) return;
        int pivot = partition(arrs,i,j);  //获取分隔哨兵
        qucikSortBody(arrs,i,pivot-1);  //分隔哨兵左侧快排
        qucikSortBody(arrs,pivot+1,j);  //分隔哨兵右侧快排
    }
    //快排寻找分隔哨兵
    private int partition(T[]arrs,int i,int j) {
        T base = arrs[i];
        while(i!=j)
        {
            while(j>i&&!less(arrs[j],base))  //当找到哨兵右侧小于或者等于哨兵的值后跳出循环
            {
                j--;
            }
            arrs[i] = arrs[j];
            while(j>i&&less(arrs[i],base))   //找到哨兵左侧大于或者等于哨兵的值后跳出循环
            {
                i++;
            }
            arrs[j] = arrs[i];
        }
        arrs[i] = base;                      //i=j时指向的元素是没用的，多余的数字，把他用哨兵替代掉。
        return i;                            //返回哨兵位置

    }
    //endregion
    //region 快排优化
    //1.在数组长度大于某一范围时使用快排，小于某一阈值时，使用直接插入排序
    //2.选择哨兵pivot的时候，不使用数组第一个数字，选取数组左中右三个位置的中间大小的数字
    //3.进行三路partition优化，将数组
//    public void quickSortOptim(int[] nums){
//        quickSortOptimBody(nums,0,nums.length-1);
//    }

//    private void quickSortOptimBody(int[] nums, int i, int length) {
//        if(i>=length) return;
//        if((length-i)<10)    //数组长度小于10，直接使用插入排序
//            inserSort(nums,i,length);
//        else
//        {
//          int pivot = findPivotOptim(nums,i,length);
//          quickSortOptimBody(nums,i,pivot-1);
//          quickSortOptimBody(nums,pivot+1,length);
//        }
//    }
//    private int findPivotOptim(int[]nums,int start,int end){
//        int pivot = getMidNum(nums[start],nums[end],nums[(start+end)/2]);
//        int lt=start,gt = end;
//        //四个指针
//    }
    private int getMidNum(int a,int b,int c){
        int min,max;
        if(a<=b){
            min = a;
            max = b;
        }
        else {
            min = b;
            max = a;
        }
        if(c<=min) return min;
        else if(c>=max) return max;
        else if(c>min&&c<max) return c;
        return -1;
    }
    //endregion
    //region 堆排序
    public void heapSort(int[]arrs)
    {
        //构建堆
        for(int i = arrs.length/2-1;i>=0;i--)
        {
            adjustHeap(arrs,i,arrs.length);
        }
        //互换+重新调整
        for(int j = arrs.length-1;j>0;j--)
        {
            swap(arrs,j,0);//堆顶和堆底互换
            adjustHeap(arrs,0,j);
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void adjustHeap(int[]arrs, int i, int length)
    {
        int temp = arrs[i];
        //对第i个结点，和叶子结点比较
        for(int k=i*2+1;k<length;k=k*2+1)
        {
            if(k+1<length&&less(arrs[k],arrs[k+1]))
                k++;
            if(less(arrs[i],arrs[k])) {
                arrs[i] = arrs[k];
                 i = k;
            }
        }
        arrs[i] = temp;
    }
    //endregion
    //region 归并排序
    public void mergeSort(T[]arrs)
    {
        //T[] temp;
        int[] temp = new int[arrs.length];
        //mergeSortBody(arrs,0,arrs.length,temp);
    }
    public void mergeSortBody(T[] arrs,int left,int right,T[] temp)
    {
        if(left<right)
        {
            int mid = (left+right)/2;
            mergeSortBody(arrs,left,mid,temp); //左边子序列排序
            mergeSortBody(arrs,mid+1,right,temp); //右边子序列排序
            merge(arrs,left,mid,right,temp);//融合
        }
    }
    public void merge(T[]arrs,int left,int mid, int right,T[]temp)
    {
        int i = left; //左半部分指针
        int j = mid+1;//右半部分指针
        int tempCounter = 0;//临时数组指针
        //把左右两个已经排好序的子数组按数字大小填进临时数组里
        while(i<mid&&j<right)
        {
            if(less(arrs[j],arrs[i]))
                temp[tempCounter++] = arrs[j++];
            else
                temp[tempCounter++] = arrs[i++];
        }
        while(j<=right)
            temp[tempCounter++] = arrs[j++];
        while(i<=mid)
            temp[tempCounter++] = arrs[i++];
        //把临时数组temp的值copy到arrs里
        tempCounter = 0;
        while(left<=right)
            arrs[left++] = temp[tempCounter++];
    }
    //endregion
    //region 快排练习
    public void quickSortExercise(int[] nums)
    {
        int length = nums.length;
        quickSortBody(nums,0,length-1);
    }
    public void quickSortBody(int[] nums,int start,int end)
    {
        //判断终止
        if(start>=end) return;
        //
        int pivot = findPivot(nums,start,end);
        quickSortBody(nums,start,pivot-1);
        quickSortBody(nums,pivot+1,end);
    }
    public int findPivot(int[] nums,int start,int end)
    {
        //最左侧元素
        int temp = nums[start];
        while(start<end)
        {
            while(start<end&&!less(nums[end],temp))
                end--;
            nums[start] = nums[end];
            while(start<end&&less(nums[start],temp))
                start++;
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }
    public boolean less(int valueA,int valueB)
    {
        return valueA<valueB;
    }
    //endregion
    //region
    public void reOrderArray(int [] array) {
        int length = array.length;
        int[] tempArray = new int[length];
        int tempArrayIndex = 0;
        for(int index = 0;index<length;index++)
        {
            if(array[index]%2==1)
                tempArray[tempArrayIndex++] = array[index];
        }
        for(int index = 0;index<length;index++)
        {
            if(array[index]%2==0)
                tempArray[tempArrayIndex++] = array[index];
        }
        array = tempArray;
    }

    //region 希尔排序练习
    public void shellSortExercise(int[] array){
        int length = array.length;
        int increment = length; //increment最小也是1
        do{
            increment=increment/3+1;
            for(int i = increment;i<length;i+=increment) {
                while (array[i] < array[i - increment]) {
                    swap(array, i, i - increment);
                }
            }
        }
        while(increment>1);
    }
    //endregion
    //region 快排的三向切分优化
    //5，7，6，1，8，21，3，8
    //lt,gt
    public void qSort(int[] nums,int lo,int hi){
        if(hi>=lo) return;
        int lt = lo;
        int gt = hi;
        int i = lo+1;
        int pivot = nums[lo];
        while(i<=gt){
            if(nums[i]<pivot)
                swap(nums,i++,lt++);
            else if(nums[i]>pivot)
                swap(nums,i++,gt--);
            else i++;
        }
        qSort(nums,lo,lt-1);
        qSort(nums,gt+1,hi);
    }
    //endregion
    //region 堆排序练习
    public void heapSortExercise(int[] nums){
        //参数检查
        if(nums == null) return;
        int length = nums.length;
        //先构建堆
        for(int i = length/2;i>=0;i--){
            maxHeap(nums,i,length);
        }
        //互换，调整堆
        for(int j = length-1;j>0;j--){
            swap(nums,j,0);
            maxHeap(nums,0,j);
        }
    }
    public void maxHeap(int[] nums,int start,int end){
//        if(start<=end) return;
        int temp = nums[start];
//        int k = start;
//        while(index<=end){
            for(int k = start*2+1;k<end;k=k*2+1) {
                if (k+1<end&&nums[k] < nums[k + 1])
                    k++;
                if (nums[k]>nums[start]){
                    nums[start] = nums[k];
                    start = k;
                }
            }
            nums[start] = temp;
//        }
    }
    //endregion
    //region 快排练习7.27
    public void quickSortExercise2(int[] array){
        if(array==null) return;
        quickSortExercise2Body(array,0,array.length-1);
    }
    public int findPivot2(int[] array,int start,int end){
        int temp = array[start];
        int left = start;
        int right = end;
        while(left<right){
            while(left<right&&!less(array[right],temp)){
                right--;
            }
            array[left] = array[right];
            while(left<right&&!less(temp,array[left]))
            {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }
    public void quickSortExercise2Body(int[] nums,int start,int end){
        if(start>=end) return;
        int pivot = findPivot2(nums,start,end);
        System.out.println(pivot);
        quickSortExercise2Body(nums,start,pivot-1);
        quickSortExercise2Body(nums,pivot+1,end);
    }
    //endregion
}

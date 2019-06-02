package cn.sortAlgorithms;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SortAlgorithms<T extends Comparable<T>>extends Sort<T>{
    public static void main(String[] args)
    {
        SortAlgorithms sortAlgorithms = new SortAlgorithms<Integer>();
        int[] nums = {1,2,3,4,5,6,7};
        sortAlgorithms.reOrderArray(nums);
        System.out.println(Arrays.toString(nums));
    }
    //region选择排序
    public void selectSort(T[] arrs)
    {
        int min;
        for(int i = 0;i<arrs.length;i++)
        {
            min = i;
            for(int j = i+1;j<arrs.length;j++)
            {
                if(less(arrs[j],arrs[min])) {
                    min = j;
                }
            }
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
            while(j>i&&!less(arrs[j],base))  //当找到哨兵右侧小于哨兵的值后跳出循环
            {
                j--;
            }
            arrs[i] = arrs[j];
            while(j>i&&less(arrs[i],base))   //找到哨兵左侧大于哨兵的值后跳出循环
            {
                i++;
            }
            arrs[j] = arrs[i];
        }
        arrs[i] = base;                      //i=j时指向的元素是没用的，多余的数字，把他用哨兵替代掉。
        return i;                            //返回哨兵位置

    }
    //endregion
    //region 堆排序
    public void heapSort(T[]arrs)
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
    public void adjustHeap(T[]arrs, int i, int length)
    {
        T temp = arrs[i];
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
}

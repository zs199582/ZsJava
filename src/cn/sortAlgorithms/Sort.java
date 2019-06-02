package cn.sortAlgorithms;

public abstract class Sort<T extends Comparable<T>> {
    //判断大小
    public boolean less(T v,T w)
    {
        return v.compareTo(w)<0;
    }
    //交换
    public void swap(T[] nums,int i,int j)
    {
        T temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

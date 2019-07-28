package cn.sortAlgorithms;

public class SearchAlgorithms {
    //查找算法
    //二分查找 前提是数组是递增的 使用非递归
    static boolean binarySearch(int[] nums,int target){
        //参数检查
        if(nums == null) return false;
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start!=end){
            mid = (start+end)/2;
            if(nums[mid] == target) return true;
            if(target<nums[mid]) end = mid-1;
            if(target>nums[mid]) start = mid+1;
        }
        return nums[start]==target;
    }
    //二分查找 使用递归方法
    static boolean binarySearchReverse(int[] nums,int target){
        //参数检查
        if(nums == null) return false;
        return binarySearchBody(nums,0,nums.length,target);
    }
    static boolean binarySearchBody(int[] nums,int start,int end,int target){
        if(start ==end) return nums[start] == target;
        int mid = (start+end)/2;
        if(target == mid) return true;
        else if(target<nums[mid]) return binarySearchBody(nums,start,mid-1,target);
        else if(target>nums[mid]) return binarySearchBody(nums,mid+1,end,target);
        else return false;
    }
    public static void main(String[] args) {
        System.out.println(SearchAlgorithms.binarySearch(new int[]{1,2,3,4,5,6,7,8,9},0));
    }
}

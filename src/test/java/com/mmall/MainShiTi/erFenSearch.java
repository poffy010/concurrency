package com.mmall.MainShiTi;

public class erFenSearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,-100,-98,-94,-76,-54,30,34,56,78};
        System.out.println(new erFenSearch().erFen(array,56));
        int[] array2 = {1,2,3,4,5,-100,-98,-94,-76,-54,30,34,56,78};
        System.out.println(new erFenSearch().findMin(array2));
    }

    public static int findMin(int[] array){
        if(array == null || array.length == 0){
            return -0;
        }

        int start = 0;
        int end = array.length -1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start)/2;
            if(array[mid] >= array[start]){
                if(array[end] <= array[mid]){
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                end = mid;
            }
        }

        return Math.min(array[start],array[end]);
    }

    /*旋转的有序数组*/
    public static int erFen(int[] array,int target){
        if(array == null || array.length == 0){
            return -1;
        }

        int start = 0;
        int end = array.length -1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start)/2;
            if(array[mid] == target){
                return mid;
            }

            if(array[mid] > array[start]){
                if(target <= array[mid] && target >= array[start]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(target >= array[mid] && target <= array[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        if(array[start] == target){
            return start;
        }

        if(array[end] == target){
            return end;
        }

        return -1;
    }
}

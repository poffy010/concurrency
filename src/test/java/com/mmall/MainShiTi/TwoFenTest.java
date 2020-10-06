package com.mmall.MainShiTi;

public class TwoFenTest {
    /*折半 二分查找*/
    public static int biSearch(int[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;//中间位置
            if (array[mid] == a) {
                return mid + 1;
            } else if (array[mid] < a) { //向右查找
                lo = mid + 1;
            } else { //向左查找
                hi = mid - 1;
            }
        }
        return -1;
    }

    /*冒泡算法*/
    public static void bubbleSort1(int[] a, int n) {
        int i, j;
        for (i = 0; i < n; i++) {//表示 n 次排序过程。
            for (j = 1; j < n - i; j++) {
                if (a[j - 1] > a[j]) {//前面的数字大于后面的数字就交换
                    //交换 a[j-1]和 a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 【插入排序】
     **/
    public static void sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            //插入的数
            int insertVal = arr[i];
            //被插入的位置(准备和前一个数比较)
            int index = i - 1;
            //如果插入的数比被插入的数小
            while (index >= 0 && insertVal < arr[index]) {
                //将把 arr[index] 向后移动
                arr[index + 1] = arr[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arr[index + 1] = insertVal;
        }
    }

    /*快速排序*/
    public static void sortSudo(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];
        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key) {
                //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            }

            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key) {
                //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            }

            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的
            //值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) sortSudo(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) sortSudo(a, end + 1, high);//右边序列。从关键值索引+1 到最后一个
    }

    /*希尔排序*/
    private static void shellSort(int[] a) {
        int dk = a.length / 2;
        while (dk >= 1) {
            ShellInsertSort(a, dk);
            dk = dk / 2;
        }
    }

    private static void ShellInsertSort(int[] a, int dk) {
        //类似插入排序，只是插入排序增量是 1，这里增量是 dk,把 1 换成 dk 就可以了
        for (int i = dk; i < a.length; i++) {
            if (a[i] < a[i - dk]) {
                int j;
                int x = a[i];//x 为待插入元素
                a[i] = a[i - dk];
                for (j = i - dk; j >= 0 && x < a[j]; j = j - dk) {
                    //通过循环，逐个后移一位找到要插入的位置。
                    a[j + dk] = a[j];
                }
                a[j + dk] = x;//插入
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 6, 8, 9, 11, 14, 16, 18, 19, 26, 28, 35, 41};
        int[] array2 = {31, 24, 96, 108, 209, 11, 124, 136, 158, 819, 926, 8, 135, 4144};
        int[] array3 = {31, 24, 96, 108, 209, 11, 124, 136, 158, 819, 926, 8, 135, 4144};
        int[] array4 = {31, 24, 96, 108, 209, 11, 4144, 124, 136, 158, 819, 926, 8, 135};
        int[] array5 = {31, 24, 96, 108, 209, 11, 4144, 124, 136, 158, 819, 926, 8, 135};
        int index = biSearch(array, 14);
        bubbleSort1(array2, array2.length);
        sort(array3);
        sortSudo(array4, 0, 13);
        shellSort(array5);

        System.out.println(index);
        System.out.print("array2:");
        for (int a : array2) {
            System.out.print(a + ",");
        }
        System.out.println("");
        System.out.print("array3:");
        for (int a : array3) {
            System.out.print(a + ",");
        }
        System.out.println("");
        System.out.print("array4:");
        for (int a : array4) {
            System.out.print(a + ",");
        }
        System.out.println("");
        System.out.print("array5:");
        for (int a : array5) {
            System.out.print(a + ",");
        }
    }
}

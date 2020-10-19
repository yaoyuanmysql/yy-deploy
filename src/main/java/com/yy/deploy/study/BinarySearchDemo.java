package com.yy.deploy.study;

/**
 * 二分查找demo
 *
 * @author yuanyao@wistronits.com
 * create on 2020-10-13 21:10
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] arry = {1, 2, 3, 4, 5, 6, 7, 8, 9,12,13,14,15,15,17,18};
        binarySearchDemo(arry, 6);

    }

    public static void binarySearchDemo(int[] arry, int item) {

        // 定义初始头尾
        int low = 0;
        int hight = arry.length - 1;

        while (low <= hight) {
            int middle = (low + hight) / 2;
            int guess = arry[middle];
            System.out.println(guess);

            if (item == guess) {
                System.out.println("找到了数组中的这个值： " + guess);
                return;
            } else if (item > guess) {
                System.out.println("输入的值大于中间值， 修改low值");
                low = middle+1;
            } else if (item < guess) {
                System.out.println("输入的值小于中间值 ， 修改high值");
                hight = middle - 1;
            }
        }
    }
    /*
     复杂度普通查找的复杂度是 O(n)  二分查找是 O(log n)
            旅行商问题 的复杂度是 o（n！）
            还有 O（n * log n）
     */
}

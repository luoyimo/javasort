package quicksort;

import java.util.Arrays;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 15:44 2018/5/24 0024
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {6, 1, 7, 3, 4, 5, 8, 2, 9, 10};
        bubbleSort(a);

    }

    /**
     * 将相邻两个值比较，顺序相反则两两交换
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                System.out.println(Arrays.toString(a));
                System.out.println("a[" + i + "]=" + a[i] + " : " + "  a[" + j + "]=" + a[j]);
                if (a[i] > a[j]) {
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }

            }


        }
    }


}

package quicksort;

import java.util.Arrays;

/**
 * @Author huqi
 * @Description:
 * @Date Create In 16:34 2018/5/24 0024
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {7, 4, 6, 8, 5, 9};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 插入排序
     * <p>
     * 默认第一个数是有序的，拿后面的数和前面的有序数比较，得出位置交换
     * <p>
     * 第一轮默认第一个7是有序的，选择a1(a[1]=4)作为第一轮比较数，拿a1和a0比较，将a0放入a1的位置
     * 将a1放入a0的位置
     * {4,7,6, 8, 5, 9}
     * <p>
     * 第二轮
     * 选中a2(a[2]=6)作为比较数，拿a2和a1比较，将a1放入a2的位置
     * {4,7,7, 8, 5, 9}
     * 将a2放入a1的位置
     * {4,6,7, 8, 5, 9}
     *
     * @param a
     */
    public static void insertSort(int[] a) {

        for (int i = 1; i < a.length - 1; i++) {
            int temp = a[i];
            int j;

            for (j = i; j > 0 && a[j - 1] > temp; j--) {

                a[j] = a[j - 1];
                System.out.println("     a[" + i + "]  temp:" + temp + "---" + Arrays.toString(a));
            }

            a[j] = temp;
            System.out.println("a[" + i + "]  " + Arrays.toString(a));


        }


    }
}

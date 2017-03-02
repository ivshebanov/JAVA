package test;

import java.util.Arrays;

/**
 * Created by iliashebanov on 27.01.17.
 */
public class Sli
{
    public static void main(String[] args) {
        int[] mas = new int[]{2,5,3,1,6,8,6,9};
        mas = mergeSort(mas);
        for (int i: mas){
            System.out.print(i + " ");
        }

    }
    public static int[] mergeSort(int[] input) {
        int n = input.length;
        if (n <= 1) {
            return input;
        }

        int middle = n / 2;
        int leftUnsorted[] = Arrays.copyOfRange(input, 0, middle);
        int rightUnsorted[] = Arrays.copyOfRange(input, middle, n);

        int left[] = mergeSort(leftUnsorted);
        int right[] = mergeSort(rightUnsorted);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int leftLen = left.length, rightLen = right.length;
        int res[] = new int[leftLen + rightLen];

        int leftIndex = 0, rightIndex = 0, resIndex = 0;

        while (leftIndex < leftLen && rightIndex < rightLen) {
            if (left[leftIndex] <= right[rightIndex]) {
                res[resIndex] = left[leftIndex];
                leftIndex++;
                resIndex++;
            } else {
                res[resIndex] = right[rightIndex];
                rightIndex++;
                resIndex++;
            }
        }

        while (leftIndex < leftLen) {
            res[resIndex] = left[leftIndex];
            leftIndex++;
            resIndex++;
        }

        while (rightIndex < rightLen) {
            res[resIndex] = right[rightIndex];
            rightIndex++;
            resIndex++;
        }

        return res;
    }
}

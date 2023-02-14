package jan.dp_at_coder.day1.div662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,5,6};
        int[] arr2 = {2,5,8,5,1,5};
        Arrays.sort(arr);
        Arrays.sort(arr2);
        for (int i = 0; i < arr.length; i++) {
            if (Arrays.binarySearch(arr2, arr[i]) < 0) {
                System.out.println(arr[i]);
                return;
            }
        }
        System.out.println(-1);


    }

}



import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int A[] = new int[2];
        generatePermutations(4,2, A, 0);
    }
    private static void generatePermutations(int n, int k, int[] result, int index) {
        // 배열이 완성된 경우 출력
        if (index == k) {
            printArray(result);
            return;
        }

        // 1부터 n까지의 숫자 중 중복을 허용하여 선택
        for (int i = 1; i <= n; i++) {
            result[index] = i;
            generatePermutations(n, k, result, index + 1);
        }
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
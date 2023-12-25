import java.util.Arrays;

public class Main {
    public static void rollDice(int[] dice_array, int index, int result){ // 결과를 저장할 dice_array, 남은 횟수를 뜻하는 index, 남은 목표 result
        if (isValid(index, result)) { // index와 result를 받아 가지치기
            if (index == 0) { // 만약 그 중 index가 0이라면 출력
                System.out.println(Arrays.toString(dice_array));
                return;
            } else { // 그 외에는 남은 index만큼 재귀 호출
                for (int j = 1; j <= 6; j++) {
                    dice_array[index - 1] = j;
                    rollDice(dice_array, index - 1, result - j);
                }
                return;
            }
        }
        else{ //
            return;
        }
    }

    static boolean isValid(int index, int result){ // 남은 주사위 횟수, 남은 목표값
        if(result < index || index * 6 < result){ // 남은 목표값이 index보다 작거나 index * 6이 result보다 작다면
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        rollDice(a, 3,12);
    }
}
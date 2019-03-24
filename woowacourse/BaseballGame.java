import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 * BaseballGame
 */
public class BaseballGame {
    static int countStrike(int[] arr, int[] answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i] == answer[i])
                count++;
        }
        return count;
    };

    static int countBall(int[] arr, int[] answer) {
        Arrays.sort(answer);
        int count = 0;
        for (int i : arr) {
            if (Arrays.binarySearch(answer, i) >= 0)
                count++;
        }
        return count;
    };

    static int[] makeArray() {
        Random rand = new Random(System.currentTimeMillis());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = rand.nextInt(8) + 1;
        }
        return arr;
    }

    static int[] inputArray(int val) {
        int[] arr = new int[3];
        for (int i = 2; i >= 0; i--) {
            arr[i] = val % 10;
            val /= 10;
        }
        return arr;
    }

    static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + " 볼");
        } else if (ball == 0) {
            System.out.println(strike + " 스트라이크");
        } else {
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        }
    }

    static boolean isWin(int[] arr, int[] answer) {
        int strike = countStrike(arr, answer);
        int ball = countBall(arr, answer);
        ball -= strike;
        if (strike == 3) {
            System.out.println("3 스트라이크");
            return true;
        } else {
            printResult(strike, ball);
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        while (true) {
            int[] arr = makeArray();
            boolean win = false;
            while (!win) {
                System.out.print("숫자를 입력해주세요 : ");
                int val = stdIn.nextInt();
                int[] answer = inputArray(val);
                win = isWin(arr, answer);
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            int re = stdIn.nextInt();
            if (re == 2)
                break;
        }
    }
}
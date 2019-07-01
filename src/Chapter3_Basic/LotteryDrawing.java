package Chapter3_Basic;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in); //scanner 必须要输入流

        System.out.println("How many numbers do you need to draw");
        int k = scanner.nextInt();
        System.out.println("What is the highest number you can draw");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for(int i=0; i< numbers.length; i++){
            numbers[i] = i+1;
        }

        int[] result = new int[k];
        for(int i=0; i<result.length; i++){
            int r = (int)(Math.random()*n);
            result[i] = numbers[r];
            numbers[r] = numbers[n-1];
            n--;
        }

        Arrays.sort(result);
        System.out.println("Bet the following combination. It'll make you rich!");
        for(int r : result){
            System.out.println(r);
        }
    }
}

package Chapter3_Basic;

public class LotteryArray {
    public static void main(String[] args) {
        final int NMAX = 10;

        //初始化三角数组的长度
        int[][] odds = new int[NMAX+1][];
        for(int n =0; n<=NMAX; n++){
            odds[n] = new int[n+1];
        }

        for(int n=0; n<odds.length; n++){
            for(int k=0; k<odds[n].length; k++){
                int lotteryOdds = 1;
                for(int i=1; i<=k; i++){
                    //n代表行，k代表列 二项式定理 n*(n-1)...(n-k+1)/k1
                    lotteryOdds = lotteryOdds*(n-i+1)/i; //杨辉三角计算公式
                }
                odds[n][k] = lotteryOdds;
            }
        }

        for(int[] row : odds){
            for(int odd : row){
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }
}

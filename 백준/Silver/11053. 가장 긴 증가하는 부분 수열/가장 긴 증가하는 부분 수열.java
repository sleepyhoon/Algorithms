import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
                for(int j = 0;j <= i; j++){
                    if(arr[i] > arr[j]){
                        dp[i] = Math.max(dp[j]+1,dp[i]);
                    }
                    max = Math.max(max,dp[i]);
                }
        }

        System.out.println(max);

    }
}

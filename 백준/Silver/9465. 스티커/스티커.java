import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];
            for(int i=0;i<2;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            int max = Math.max(dp[0][0], dp[1][0]);
            for(int i=1;i<n;i++){
                if(i==1){
                    dp[0][1] = dp[1][0] + arr[0][1];
                    dp[1][1] = dp[0][0] + arr[1][1];
                    max = Math.max(dp[0][1], dp[1][1]);
                } else {
                    dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + arr[0][i];
                    dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + arr[1][i];
                    max = Math.max(dp[0][i], dp[1][i]);
                }
            }
            System.out.println(max);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parents, height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        height = new int[n+1];
        Arrays.fill(parents,-1);
        Arrays.fill(height,0);

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from,to);
        }
        if (parents[1] < 0) {
            System.out.println(-1*parents[1] -1);
        }
        else {
            System.out.println(-1*parents[findParent(1)] - 1);
        }
    }

    private static int findParent(int x) {
        if(parents[x] < 0) return x;
        return parents[x] = findParent(parents[x]);
    }

    private static boolean union(int a,int b) {
        int pa = findParent(a);
        int pb = findParent(b);

        if (pa == pb)
            return false;

        if(height[pa]<height[pb]) {
            int tmp = pa;
            pa = pb;
            pb = tmp;
        }

        if(height[pa] == height[pb])
            height[pa]++;
        height[pb] = 0;
        parents[pa] += parents[pb];
        parents[pb] = pa;
        return true;
    }
}

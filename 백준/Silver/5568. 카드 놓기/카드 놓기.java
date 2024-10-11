import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,k;
    static String[] arr;
    static Map<Integer,String> map = new HashMap<>();
    static int index;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n];
        arr = new String[n];

        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }
        String input = "";
        combination(input,visited,0,k);
        Collection<String> values = map.values();
        System.out.println(map.size());
    }

    private static void combination(String input, boolean[] visited,int depth,int r) {
        if(depth == r) {
            if(!map.containsValue(input)) {
                map.put(index++,input);
            }
        } else {
            for(int i=0;i<n;i++) {
                if(visited[i]) continue;
                visited[i] = true;
                String newInput = input + arr[i];
                combination(newInput,visited,++depth,k);
                visited[i] = false;
                depth--;
            }
        }
    }
}
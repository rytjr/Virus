import java.util.*;
import java.io.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int N1, N2;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N1 = Integer.parseInt(st.nextToken());
        list = new int[N1 + 1];

        st = new StringTokenizer(bf.readLine());
        N2 = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < N2; i++) {
            st = new StringTokenizer(bf.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arr.get(n1).add(n2);
            arr.get(n2).add(n1);
        }

        for (int i = 1; i <= N1; i++) {
            Collections.sort(arr.get(i));
        }

        bfs(1);
        int count = 0;

        for (int i = 0; i <= N1; i++) {
            if (list[i] != 0) {
                count++;
            }
        }

        System.out.print(count - 1);

    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        list[start] = 1;

        while (!que.isEmpty()) {
            int num = que.poll();

            for (int i = 0; i < arr.get(num).size(); i++) {
                if (list[arr.get(num).get(i)] == 0) {
                    que.offer(arr.get(num).get(i));
                    list[arr.get(num).get(i)] = 1;
                }

            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/***
 * https://www.acmicpc.net/problem/10282
 */
public class Main_10282 {

    private static int[] dis = new int[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int computerNum = Integer.parseInt(st.nextToken());
            int dependencyNum = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Node>> graph = new ArrayList<>();
            for (int i=0; i<=computerNum; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i=0; i<dependencyNum; i++) {
                // 그래프 초기화
                st = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Node(a, s));
            }
            Arrays.fill(dis,Integer.MAX_VALUE);
            dijkstra(target,graph);

            int cnt = 0;
            int result = 0;
            for (int i=1; i<=computerNum; i++) {
                if (dis[i] != Integer.MAX_VALUE) {
                    cnt++;
                    result = Math.max(result, dis[i]);
                }
            }

            sb.append(cnt + " " + result + "\n");

        }

        System.out.print(sb);

    }

    private static void dijkstra(int start , ArrayList<ArrayList<Node>> graph) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(); // 우선순위큐 -> 이진힙
        priorityQueue.add(new Node(start, 0));
        dis[start] = 0;

        while(!priorityQueue.isEmpty()){
            Node node = priorityQueue.poll();
            int curr = node.index;
            int distance = node.distance;

            if(dis[curr] < distance){
                continue;
            }



            ArrayList<Node> mid = graph.get(curr);
            for( int i = 0 ; i < mid.size(); i++ ) {
                int cost = dis[curr] + mid.get(i).distance;
                if( dis[mid.get(i).index]  > cost ){
                   dis[mid.get(i).index] = cost;
                    priorityQueue.add(new Node(mid.get(i).index , mid.get(i).distance));
               }
            }
        }
    }

    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        Node (int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        private int getIndex() {
            return this.index;
        }

        private int getDistance() {
            return this.distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.distance, this.distance);
        }

    }
}
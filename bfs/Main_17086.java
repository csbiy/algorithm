package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/***
 * bfs 문제
 */
public class Main_17086 {

    private static final int[] xDir = {1,0,-1,0,1,-1,1,-1};
    private static final int[] yDir = {0,-1,0,1,1,-1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] graph = new int[n][m];
        int maxDistance = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                graph[i][j] =Integer.parseInt(line[j]);
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(graph[i][j] ==1 ){
                    continue;
                }
                boolean[][] visited = new boolean[n][m];
                int safeDistance = getSafeDistance(i, j ,  graph, visited);
                if( maxDistance < safeDistance){
                    maxDistance = safeDistance;
                 }
            }
        }
        System.out.println(maxDistance);
    }

    private static int getSafeDistance(int posX, int posY, int[][] graph , boolean[][] visited ) {


        Deque<Pair> queue =  new ArrayDeque<>(); // java에서는 queue 를 LinkedList로 사용한다고 함
        queue.addLast(new Pair(posX,posY,0));
        visited[posX][posY] = true;
        while(!queue.isEmpty()){
            Pair pair = queue.pollFirst();
            if(graph[pair.posX][pair.posY] == 1){
                return pair.dis;
            }
            for(int i = 0; i < 8 ;i++){
                int x = pair.posX + xDir[i];
                int y = pair.posY + yDir[i];
                if( x >= 0 && y >= 0 && x < graph.length && y < graph[0].length && !visited[x][y] ){
                    queue.addLast(new Pair(x,y,pair.dis+1));
                    visited[x][y] = true;
                }
            }
        }
        throw new AssertionError();
    }

    private static class Pair{
        int posX;
        int posY;
        int dis;

        public Pair(int posX, int posY , int dis ) {
            this.posX = posX;
            this.posY = posY;
            this.dis  = dis;

        }
    }
}

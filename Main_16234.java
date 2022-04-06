import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_16234 {

    /***
     * 2 20 50
     * 50 30
     * 20 40
     */

    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);
        int[][] graph = new int[n][n];
        boolean[][] isOpened = new boolean[n*n][n*n];
        for( int i = 0 ; i < n ; i++ ){
            String[] src = br.readLine().split(" ");
            for(int j = 0; j < n ; j++){
                graph[i][j]  = Integer.parseInt(src[j]);
            }
        }

        Queue<Node> queue = new LinkedList<>();


        int allianceNum = 0;
        for(int  i = 0 ; i < n ; i++){
            for(int  j = 0 ; j < 4 ; j++){
                int posX = i + dx[j];
                int posY = i + dy[j];
                if(posX >= 0 && posX < n && posY >=0 && posY < n  ){
                    int diff = Math.abs(graph[posX][posY] - graph[i][i]);
                    if( diff >= l && diff <= r ){
                        isOpened[i*n+i][posX*n+posY] = true;
                        isOpened[posX*n+posY][i*n+i] = true;
                        allianceNum++;
                    }
                }
            }
        }

    }

    private static class Node{
        int x;
        int population;

        Node(int x , int population ){
            this.x=  x;
            this.population = population;
        }
    }
}

package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_12886 {

    /***
     * https://www.acmicpc.net/problem/12886
     */
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        // a,b,c <= 500

        // TODO : 이미 방문한 숫자 재방문시 0 출력
        bfs(new Node(a,b,c),new HashSet<Node>());
    }

    private static void bfs(Node node, Set set) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        set.add(node);
        // TODO
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            int a = curr.a ; int b = curr.b ; int c = curr.c;
            if(a > 500 || a < 1 || b >500 || b <1 || c > 500 || c < 1){
                continue;
            }else if(a == b && b == c){
                System.out.print(1);
                return;
            }
            if(a!=b){
                if(a<b){
                    queue.add(new Node(a*2,b-a,c));
                }else{
                    queue.add(new Node(a-b,b*2,c));
                }
            }
            if(a!=c){
                if(a<c){
                    queue.add(new Node(a*2,b,c-a));
                }else{
                    queue.add(new Node(a-c,b,c*2));
                }
            }
            if(b!=c){
                if(b<c){
                    queue.add(new Node(a,b*2,c-b));
                }else{
                    queue.add(new Node(a,b-c,c*2));
                }
            }
        }
        System.out.print(0);
    }

    private static class Node{
        int a;
        int b;
        int c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}

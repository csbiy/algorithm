package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14888 {

    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Deque<Integer> deque = new ArrayDeque<>();
        int[] operators = new int[4];
        for(int i  = 0 ; i < n ; i++){
            deque.add(Integer.parseInt(input[i]));
        }
        String[] operatorNum = br.readLine().split(" ");
        for(int i = 0 ; i < 4 ; i++){
           operators[0] = Integer.parseInt(operatorNum[0]); // plus
           operators[1] = Integer.parseInt(operatorNum[1]); // minus
           operators[2] = Integer.parseInt(operatorNum[2]); // multiply
           operators[3] = Integer.parseInt(operatorNum[3]); // divide
        }

        dfs(deque,operators);
        System.out.println(max + "\n" + min);

    }

    private static void dfs( Deque<Integer> deque , int[] operator ){
        if(deque.size() == 1){
            max = Math.max(max,deque.peek());
            min = Math.min(min,deque.peek());
            return;
        }
        for(int i = 0 ; i < 4 ; i++){
            if(operator[i] >= 1){
                operator[i]-=1;
                int x = deque.pollFirst();
                int y = deque.pollFirst();
                deque.addFirst(Operator.findOperator(i).apply(x,y));
                dfs(deque,operator);
                deque.pollFirst();
                deque.addFirst(y);
                deque.addFirst(x);
                operator[i]+=1;
            }
        }
    }

    private enum Operator{
        PLUS{public int apply(int x, int y) {return x+y;}},
        MINUS{public int apply(int x, int y) {return x-y;}},
        MULTIPLY{public int apply(int x, int y) {return x*y;}},
        DIVIDE{public int apply(int x, int y) {return x/y;}};

        public abstract int apply(int x, int y);

        public static Operator findOperator(int i ){
            switch (i){
                case 0 : return Operator.PLUS;
                case 1 : return Operator.MINUS;
                case 2 : return Operator.MULTIPLY;
                case 3 : return Operator.DIVIDE;
            }
            throw new AssertionError();
        }
    }
}

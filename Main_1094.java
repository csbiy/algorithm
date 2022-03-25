import java.io.IOException;
import java.util.Scanner;

public class Main_1094 {
     public static void main(String[] args) throws IOException {
          Scanner sc = new Scanner(System.in);
          int x = sc.nextInt();
          if(x==64) {
               System.out.print(1);
               return;
          }
          int stick = 64;
          int min  = 64;
          int count = 1;
          while ( true){
               if(stick-min/2 >= x){
                    stick-=min/2;
                    if(stick == x){
                         System.out.print(count);
                         return;
                    }
               }
               else{
                    count++;
               }
               min/=2;
          }
     }
}
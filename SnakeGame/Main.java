import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows = ");
        int rows = sc.nextInt();
        System.out.print("Number of columns = ");
        int cols = sc.nextInt();
        Snake snake = new Snake(rows, cols);
        
        System.out.println("******GAME STARTS******");

        snake.initiateGame(0, 0);
    }
}

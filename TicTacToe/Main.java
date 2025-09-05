import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        game.printBoard();

        while(!game.isBoardFull() && game.checkWinner() == 0){
            System.out.println("Enter position: ");
            System.out.print("row = ");
            int row = sc.nextInt();
            System.out.print("Column = ");
            int col = sc.nextInt();

            if(!game.isPositionValid(row, col)){
                System.out.println("Invalid position... Please enter another position");
                continue;
            }

            game.setGridChar(row, col);
            game.printBoard();
            int winner = game.checkWinner();
            if(winner != 0){
                System.out.println("Game Ended... Winner is " + winner);
                break;
            }

        }
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Snake {
    private Scanner sc = new Scanner(System.in);

    private char[][] board;
    private Queue<Node> queue = new LinkedList<>();
    private Queue<Node> food = new LinkedList<>();
    private Node currPos;

    public Snake(int row, int col){
        this.board = new char[row][col];
        for(int i = 0; i< row; i++){
            for(int j = 0; j < col; j++)
                board[i][j] = '-';
        }
        currPos = new Node(0,0);
        food.add(new Node(5,4));
        food.add(new Node(1, 2));
        food.add(new Node(3, 5));
        food.add(new Node(6, 1));
        food.add(new Node(2, 6));
        food.add(new Node(4, 3));

    }


    public void initiateGame(int row, int col){
        if(queue.isEmpty()) {
            queue.add(new Node(row, col));
            currPos = new Node(row, col);
            board[0][0] = 'o';
        }

        if(!food.isEmpty()){
            Node foodPos = food.poll();
            fillFood(foodPos);
        }
        
        while(true){
            
            printBoard();
            System.out.println("Enter direction (U/L/D/R) : ");
            char dir = sc.next().charAt(0);
            Node target = getTarget(currPos, dir);

            if(isTargetValid(target)){
                moveSnake(target);
            }
            else{
                printBoard();
                System.out.println("*******GAME OVER*******");
                return;
            }
            
        }
        
    }

    public void moveSnake(Node target){
        int r = target.getRow();
        int c = target.getCol();

        if(board[r][c] == 'X'){
            currPos = target;
            board[r][c] = 'o';           
            queue.add(target);
            if(!food.isEmpty()){
                Node foodPos = food.poll();
                fillFood(foodPos);
            }
            else{
                printBoard();
                System.out.println("*******GAME OVER*******");
                return;
                
            }
            
        }
        else{
            board[r][c] = 'o';           
            int cr = currPos.getRow();
            int cc = currPos.getCol();
            queue.remove();
            board[cr][cc] = '-';
            queue.add(target);
            currPos = target;

        }
        
        // else{
        //     int cr = currPos.getRow();
        //     int cc = currPos.getCol();
        //     queue.remove();
        //     queue.add(target);

        // }
    }

    

    public void fillFood(Node pos){
        int row = pos.getRow();
        int col = pos.getCol();
        board[row][col] = 'X';
    }

    public Node getTarget(Node curr, char dir){
        int r = curr.getRow();
        int c = curr.getCol();
        switch(dir){
            case 'U': 
                r--;
                break;
            case 'D':
                r++;
                break;
            case 'R':
                c++;
                break;
            case 'L':
                c--;
                break;
            default: 
                System.out.println("Invalid direction");
                return null;

        }

        return new Node(r, c);
    }

    public boolean isTargetValid(Node target){
        int r = target.getRow();
        int c = target.getCol();

        if(r<board.length && r>=0 && c>=0 && c < board[0].length && board[r][c] != 'o') return true;

        return false;

    }
    
    public void printBoard(){
        for(int i = 0; i<this.board.length; i++){
            for(int j = 0; j< this.board[0].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}

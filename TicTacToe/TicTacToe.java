public class TicTacToe {
    private int currplayer;
    private char[][] grid = new char[3][3];

    public TicTacToe() {
        this.currplayer = 1;

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                grid[i][j] = ' ';
            }
        }
    }


    public void printBoard(){
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(grid[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public boolean isBoardFull(){
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if(grid[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public int checkWinner(){

        for(int i = 0; i<3; i++){
            if(grid[i][0] != ' '){
                if(grid[i][1] == grid[i][0] && grid[i][2] == grid[i][0]) return grid[i][0] == 'X' ? 1 : 2;
            }
        }
        for(int i = 0; i<3; i++){
            if(grid[0][i] != ' '){
                if(grid[1][i] == grid[0][i]  && grid[2][i] == grid[1][i]) return grid[0][i] == 'X' ? 1 : 2;
            }
        }
        for(int i = 0; i<3; i++){
            if(grid[1][1] != ' '){
                if((grid[0][0] == grid[1][1] && grid[2][2]== grid[1][1]) || (grid[0][2] == grid[1][1] && grid[2][0] == grid[1][1]))
                    return grid[1][1] == 'X' ? 1 : 2;
            }
        }

        return 0;
    }

    public boolean isPositionValid(int r, int c){
        if(r < 0 || r > 2 || c < 0 || c > 2) return false;
        return grid[r][c] == ' ';
    }

    public void setGridChar(int row, int col){
        grid[row][col] = (currplayer == 1) ? 'X' : 'O';
        currplayer = (currplayer == 1) ? 2 : 1;
    }

}

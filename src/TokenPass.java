import java.util.Arrays;

public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount)
    {
        this.board = new int[playerCount];
        for(int i = 0; i < playerCount; i++)
        {
            this.board[i] = (int)(Math.random()*10)+1;
        }
        this.currentPlayer = (int)(Math.random()*playerCount);
    }

    public void distributeCurrentPlayerTokens()
    {
        int passedTokens = this.board.length - 1;
        if(this.board[currentPlayer] >= this.board.length){
            this.board[currentPlayer] = this.board[currentPlayer] - (this.board.length-1);
        }else{
            this.board[currentPlayer] = 0;
        }
        int position = currentPlayer;
        while(passedTokens != 0){
            position++;
            if(position >= this.board.length){
                position = 0;
            }
            this.board[position] = this.board[position] + 1;
            passedTokens--;
        }
    }

    public void nextPlayer()
    {
        this.currentPlayer = this.currentPlayer + 1;
        if(this.currentPlayer > this.board.length - 1 && this.currentPlayer > 0)
        {
            this.currentPlayer = 0;
        }
        System.out.println("Current Player: "+ this.currentPlayer);
    }

    public int gameOver()
    {
        int val = -1;
        for(int i = 0; i < board.length; i++) {
            if (this.board[i] == 0) {
                val = i;
            }
        }
        return val;

    }

    public void printBoard()
    {
        String[] table = new String[this.board.length];
        for(int i = 0; i < this.board.length; i++)
        {
            table[i] = "Player " + i +": " + this.board[i];
        }
        System.out.println(Arrays.toString(table));
    }
}
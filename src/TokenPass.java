public class TokenPass {

    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount)
    {
        board=new int[playerCount];
        for(int i= 0; i<playerCount; i++)
        {
            board[i]= (int)(Math.random()*10)+1;
        }
        currentPlayer=(int)(Math.random()*playerCount);
    }

    public void distributeCurrentPlayerTokens()
    {
        int nextPlayer=currentPlayer;
        int numToDistribute= board[currentPlayer];
        board[currentPlayer]=0;

        while(numToDistribute>0)
        {
            nextPlayer= (nextPlayer+1)% board.length;
            board[nextPlayer]++;
            numToDistribute--;
        }
    }

    public int gameOver()
    {
        int result=-1;
      for(int i=0; i<board.length-1; i++) {
          if (board[i] == 0) {
              result = i;
          }
      }
        return result;
    }

    public void printBoard()
    {
        for(int i=0; i<board.length; i++) {
            System.out.println("Player " +i+ " has "+board[i]+" tokens");
        }
    }

    public void nextPlayer()
    {
        currentPlayer= (currentPlayer+1)%board.length;
    }

}

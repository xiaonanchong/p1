package tdd;

public class TennisScore {

    int playerOne = 0, playerTwo = 0;

    public String getScore() {
        if(ifPlayerOneIsWinner())
        {
            return "game player one";
        }
        if(ifPlayerTwoIsWinner())
        {
            return "game player two";
        }
        if(playerOne != playerTwo){
            if(playerOne>=3 && playerTwo >=3){
                if(playerOne>playerTwo){
                    return "advantage player one";
                }
                else{
                    return "advantage player two";
                }
            }
            return  format(playerOne) + " " + format(playerTwo);
        }else{
            if (playerOne>=3 ){
             return "deuce";
            }
            else {
                return format(playerOne) + " all";
            }
           }
    }

    private boolean ifPlayerOneIsWinner() {
        return playerOne >=4 && playerOne>=playerTwo+2;
    }

    private String format (int i){
        switch(i){
            case 0:
                return "love";
            case 1:
                return "fifteen";
            case 2:
                return "thirty";
            case 3:
                return "forty";
        }
        return "";
    }

    public void playerOneScored() {
        isTheGameEnd();
        playerOne++;
    }

    private void isTheGameEnd() {
        if (ifPlayerOneIsWinner()) {
            throw new IllegalStateException();
        }
        if (ifPlayerTwoIsWinner()) {
            throw new IllegalStateException();
        }
    }

    public void playerTwoScored() {
        isTheGameEnd();
        playerTwo++;
    }

    private boolean ifPlayerTwoIsWinner() {
        return playerTwo >=4 && playerTwo>=playerOne+2;
    }

}

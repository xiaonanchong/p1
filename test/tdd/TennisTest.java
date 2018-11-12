package tdd;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

public class TennisTest {

    TennisScore tennisScore = new TennisScore();

    @Test
    public void startWithLoveLove(){
        assertThat(tennisScore.getScore(), is("love all"));

    }

    @Test
    public void scoreIsUpdatedWhenAPlayerWonThePoint(){
        tennisScore.playerOneScored();
        assertThat(tennisScore.getScore(), is("fifteen love"));
        tennisScore.playerOneScored();
        assertThat(tennisScore.getScore(), is("thirty love"));
        tennisScore.playerOneScored();
        assertThat(tennisScore.getScore(), is("forty love"));
        tennisScore.playerTwoScored();
        assertThat(tennisScore.getScore(), is("forty fifteen"));
    }

    @Test
    public void deuceState(){
        playToDeuce();
        assertThat(tennisScore.getScore(), is("deuce"));

    }

    @Test
    public void advantageState(){
        playToDeuce();
        tennisScore.playerTwoScored();
        assertThat(tennisScore.getScore(), is("advantage player two"));
        tennisScore.playerOneScored();
        assertThat(tennisScore.getScore(), is("deuce"));
    }

    private void playToDeuce() {
        tennisScore.playerOneScored();
        tennisScore.playerOneScored();
        tennisScore.playerOneScored();
        tennisScore.playerTwoScored();
        tennisScore.playerTwoScored();
        tennisScore.playerTwoScored();
    }


    @Test
    public void playerOneWonTheGame(){
        tennisScore.playerOneScored();
        tennisScore.playerOneScored();
        tennisScore.playerOneScored();
        tennisScore.playerOneScored();
        assertThat(tennisScore.getScore(), is("game player one"));
    }
    @Test
    public void deuceAdvantageGamePlayerOne(){
        playToDeuce();
        assertThat(tennisScore.getScore(), is("deuce"));
        tennisScore.playerOneScored();
        assertThat(tennisScore.getScore(), is("advantage player one"));
        tennisScore.playerOneScored();
        assertThat(tennisScore.getScore(), is("game player one"));
    }

    @Test
    public void endOfTheGameException() {
        tennisScore.playerOneScored();
        tennisScore.playerOneScored();
        tennisScore.playerOneScored();
        tennisScore.playerOneScored();
        try {
            tennisScore.playerOneScored();
            fail("Expected exception to be thrown");
        }catch (IllegalStateException ex){

        }
    }

}

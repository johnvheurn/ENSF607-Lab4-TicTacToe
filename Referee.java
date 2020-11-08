/*
 *  Referee.java
 *  ENSF 607 - Fall 2020 Lab 4
 *  Completed by: John Van Heurn #30001886
 *  Date: October 22nd 2020
 */

package exercise3;

public class Referee {
    private Player xPlayer; // player with mark X
    private Player oPlayer; // player with mark O
    private Board board;    // board object

    /*
        CONSTRUCTOR
    */
    public Referee() {
        this.xPlayer = null;
        this.oPlayer = null;
        this.board = null;
        return;
    }

    /**
     * Initiate the game of Tic-Tac-Toe 
     */ 
    public void runTheGame() {
        // set the opponent for the x and o players
        this.xPlayer.setOpponent(this.oPlayer);
        this.oPlayer.setOpponent(this.xPlayer);

        // set the board for each player        
        oPlayer.setBoard(this.board);	
		xPlayer.setBoard(this.board);	

        // display the board and call the play method for Player X
        this.board.display();
        this.xPlayer.play();
        
        return;
    }

    /*
        GETTERS AND SETTERS 
    */
    public void setBoard(Board board) {
        this.board = board;
        return;
    }

    public void setoPlayer(Player player) {
        this.oPlayer = player;
        return;
    }

    public void setxPlayer(Player player) {
        this.xPlayer = player;
        return;
    }

}

/*
 *  RandomPlayer.java
 *  ENSF 607 - Fall 2020 Lab 4
 *  Completed by: John Van Heurn #30001886
 *  Date: October 22nd 2020
 */

package exercise3;

public class RandomPlayer extends Player{
    
    /*
        CONSTRUCTOR
    */
    public RandomPlayer(String name, char letter){
        super(name, letter);
        return;
    }

    /**
     * Takes user input for row and column, 
     * adds mark to game board,
     * displays game board,
     * calls opponent.play(), as it is the opponents turn next
     */
    public void makeMove() {
        int row, column;

        // find a spot to mark the board
        do {  
            row = RandomGenerator.discrete(0,2);
            column = RandomGenerator.discrete(0,2);
        } while(this.board.checkClear(row, column) == false);

        // make a mark on the board
        this.board.addMark(row, column, this.mark);
        this.board.display();
        this.opponent.play();
        return;
    }
}

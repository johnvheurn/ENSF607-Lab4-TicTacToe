/*
 *  HumanPlayer.java
 *  ENSF 607 - Fall 2020 Lab 4
 *  Completed by: John Van Heurn #30001886
 *  Date: October 22nd 2020
 */

package exercise3;

import java.io.*;

public class HumanPlayer extends Player {

    /*
        CONSTRUCTOR
    */
    public HumanPlayer(String name, char letter){
        super(name, letter);
        return;
    }

    /**
     * Takes user input for row and column, 
     * adds mark to game board,
     * displays game board,
     * calls opponent.play(), as it is the opponents turn next
     * @throws IOException
     */
    public void makeMove() throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int row, column;

        // retrieve row 
        do {
            System.out.print("\n" + this.name + ", please enter a row to place an " + this.mark + ": ");
            row = Integer.parseInt(stdin.readLine());
            
            while (row < 0 || row > 2) {
                System.out.print("Please try again: ");
                row = Integer.parseInt(stdin.readLine());
            }
            
            // retrieve column
            System.out.print(this.name + ", please enter a column to place an " + this.mark + ": ");
            column = Integer.parseInt(stdin.readLine());

            while (column < 0 || column > 2) {
                System.out.print("Please try again: ");
                column = Integer.parseInt(stdin.readLine());
            }
            if (this.board.checkClear(row, column) == false)
                System.out.println("The chosen space is not clear.");

        } while(this.board.checkClear(row, column) == false);

        // make a mark on the board
        this.board.addMark(row, column, this.mark);
        this.board.display();
        this.opponent.play();
        return;
    }
}

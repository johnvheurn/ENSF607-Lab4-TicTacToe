/*
 *  Player.java
 *  ENSF 607 - Fall 2020 Lab 4
 *  Completed by: John Van Heurn #30001886
 *  Date: October 22nd 2020
 */

package exercise3;

import java.io.*;

abstract public class Player {
    protected String name;        // name of person
    protected Board board;        // game board object
    protected Player opponent;    // opponent object
    protected char mark;          // X, O
    /*
        CONSTRUCTOR
    */
    public Player(String name, char letter){
        this.name = name;
        this.mark = letter;
        return;
    }

    /**
     * Check if game is complete, call the makeMove() function for this player to make a move
     */
    public void play() {
        
        // X Player has Won
        if (this.board.xWins() == true) {
            if (this.mark == 'X')
                System.out.println(this.name + " has won the game. (" + this.mark + ")");
            else 
                System.out.println(this.opponent.name + " has won the game. (" + this.opponent.mark + ")");
        }
        // O Player has Won
        else if (this.board.oWins() == true) {
            if (this.mark == 'O')
                System.out.println(this.name + " has won the game. (" + this.mark + ")");
            else 
                System.out.println(this.opponent.name + " has won the game. (" + this.opponent.mark + ")");
        }
        // Board is Full
        else if (this.board.isFull() == true) {
            System.out.println("The game has ended in a tie.");
        }
        // Play Move
        else {
            try {
                this.makeMove();
            }
            catch (IOException e) {
                System.out.println("IOException in makeMove()."); 
            }
        }
        return;
    }

    /**
     * Takes user input for row and column, 
     * adds mark to game board,
     * displays game board,
     * calls opponent.play(), as it is the opponents turn next
     * @throws IOException
     */
    abstract public void makeMove() throws IOException;
    
    /*
        GETTERS AND SETTERS 
    */
    public void setOpponent(Player player) {
        this.opponent = player;
        return;
    }

    public void setBoard(Board board) {
        this.board = board;
        return;
    }
 }

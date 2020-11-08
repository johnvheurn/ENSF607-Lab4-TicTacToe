/*
 *  BlockingPlayer.java
 *  ENSF 607 - Fall 2020 Lab 4
 *  Completed by: John Van Heurn #30001886
 *  Date: October 22nd 2020
 */

 /*
    BONUS (optional)
    - first looks at board, if it can find a move to win immediately, it makes the move
    - otherwise, it looks for a way to block its opponent's from winning on the next move
    - otherwise, it picks a vacant square at random
 */

package exercise3;

public class SmartPlayer extends Player {
   /*
      CONSTRUCTOR
   */
   public SmartPlayer(String name, char letter){
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

         // call testForWin() for each row and column to try to find a position to win
         for (int i = 0; i < 3; i++) {
            for (int j =0; j < 3; j++) {
               if (testForWin(i, j) == 1) {
                     row = i;
                     column = j;

                     // make a mark on the board
                     this.board.addMark(row, column, this.mark);
                     this.board.display();
                     this.opponent.play();
                     return;
               }
            }
         }

         // call testForBlocking() for each row and column to try to find a position to block
         for (int i = 0; i < 3; i++) {
            for (int j =0; j < 3; j++) {
               if (testForBlocking(i, j) == 1) {
                     row = i;
                     column = j;

                     // make a mark on the board
                     this.board.addMark(row, column, this.mark);
                     this.board.display();
                     this.opponent.play();
                     return;
               }
            }
         }

         // if no block found, find a random spot
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
   
   // returns 0 if space is not a block
   // returns 1 if space is a block
   public int testForBlocking(int row, int column) {
      // if board position is not clear, return 0
      if (this.board.checkClear(row, column) == false) 
         return 0; 

      // add mark to the board, check winner, then remove mark from board and return        
      this.board.addMark(row, column, opponent.mark);
      int test = this.board.checkWinner(opponent.mark);
      this.board.removeMark(row, column);
      return test;
   }

   public int testForWin(int row, int column) {
      // if board position is not clear, return 0
      if (this.board.checkClear(row, column) == false) 
         return 0; 

      // add mark to the board, check winner, then remove mark from board and return        
      this.board.addMark(row, column, this.mark);
      int test = this.board.checkWinner(this.mark);
      this.board.removeMark(row, column);
      return test;
   }
}

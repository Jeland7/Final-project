/*
 1.Generate random word from String[] words;
 2.Convert word (replace each letter to *);
 3.Show game status to user;
 4.User enter letter try to guess the word. Looping if letter has been used;
 5.Compare letter provided by user if letters is in the current word;
 6.If user guess letter then replace star * in word to show, otherwise decrement -1 lives;
 7.Check if all letters are guess and set completed to true;
 8.Loop working until lives >0 and word not completed;
 9.Show user result of the game ( lost, won ) and update games statistics;
 10.Ask user to continue a game or end game;
 11.If user press Y then continue loop;
 12.If not display game statistics and finish program.
 */

import java.util.Random;
import java.util.Scanner;

public class HangmanApp {

	public static void main(String[] args) {
		
		//declare local variables
		int lives; 	
		int gamesWon = 0;
		int gamesLost = 0;
		String agree = "yes";
		String starWord;
		String letters = "";
		char currentLetter;
		
		String word[] = {"Bahamas", "Bahrain", "Barbados", "Brunei", "Cape Verde", "Comoros", "Cuba",
				"Cyprus", "Dominica", "Fiji", "Haiti", "Iceland", "Jamaica", "Japan", "Madagascar", 
				"Maldives", " Malta", "Mauritius", "Philippines",
				"Seychelles", "Singapore", "Taiwan", "Tonga", "Vanuatu"};
		
		//declare an object
	    HangmanLetters myHang = new HangmanLetters();
		
		//output to start
		System.out.println("<<<<<< Welcome to the game! >>>>>>");
		System.out.println("The theme of the game is Island Countries!");
		System.out.println();
		
		
		
		do {
		
		//input Scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("Press ENTER to START: ");
		sc.nextLine();
		
		//generating random word from String[]
	    Random r = new Random();
	    int randomWord = r.nextInt(word.length);
	    
	    //convert letters to ***
	    starWord = myHang.convertStars(word[randomWord]);					
	    
	    
	    //declare amount of lives
		lives = 8;
		boolean gameFinished = false;
		
		while (lives > 0 && !gameFinished) {
			System.out.println("Word: " + starWord);
			System.out.println("Lives: " + lives);
			System.out.println("Used letters: ");
			
			if (myHang.getLength() == 0) {
				System.out.println(" no letters used yet");
				System.out.println();
				
			}else {
				myHang.showUsedLetters();
				
			}
		 
			currentLetter = ' '; 
			boolean usedLetter = false;
			
			do {
				
				if (usedLetter) {
					System.out.println("The letter " + "<<" + currentLetter + ">>"+ " was used!");
				}
				
				//ask the user to guess a letter
				System.out.println("Guess a letter: ");
				currentLetter = sc.next().charAt(0);
			
				//check if letter was used
				usedLetter = myHang.letterWasUsed(currentLetter);	
				
				
			} while (usedLetter);
			  boolean newLetter = false;

/** >>>> made correction from starWord.charAt(i) to word[randomWord].charAt(i) <<<<< */
			//convert the word to char Array and check if the letter is in the word
				char[] showLettersInTheWord = word[randomWord].toCharArray();
				for(char i=0; i<showLettersInTheWord.length; i++) {
					if(word[randomWord].charAt(i) == currentLetter) {
						showLettersInTheWord[i] = currentLetter;
						newLetter = true;
					}
				//return the word from char Array
				} starWord = String.copyValueOf(showLettersInTheWord);
				
				//minus life if the letter is not guessed
					if(!newLetter) {
						lives--;
					} myHang.usedLettersLine(currentLetter);
			
/** >>>> deleted boolean with changed value <<<<< */
			    //if there are still *** in the word the game is not finished
				for (char i=0; i<word[randomWord].length(); i++) {
					if (word[randomWord].charAt(i) == '*') {
						gameFinished = true;
						} 
					}
		}
					
			    //the game is lost if there are no more lives
					if (lives == 0) {
						gamesLost++;
						System.out.println("GAME OVER! The word was: " + word[randomWord]);
						System.out.println();

/** >>>> added parameters <<<<< */
						
					}else if (lives>0 || gameFinished){
						gamesWon++;
						System.out.println("Congratulations! The word was: " + word[randomWord]);
					}
					//show statistics
					System.out.println("Statistics: ");
					System.out.println("Games lost: " + gamesLost);
					System.out.println("Games won: " + gamesWon);
		  
	   //ask if the user would like to play again 
	     System.out.println("Would you like to play again (yes/no)?");
			agree = sc.next().toLowerCase();

		
		} while (agree.contentEquals("yes"));	
	   if (agree.equals("no")) {
			System.out.println("Thank you for the game!");
			System.out.println();}
	
		
	
		
	
	
		
	}//end main

}//end class

	



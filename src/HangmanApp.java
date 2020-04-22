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

	//declare main method
	public static void main(String[] args) {
		
	//declare local variables
	int lives; 	
	int gamesWon = 0;
	int gamesLost = 0;
	String agree = "yes";
	String starWord;
	char currentLetter;
		
	String word[] = {"Bahamas", "Bahrain", "Barbados", "Brunei", "Comoros", "Cuba",
				"Cyprus", "Dominica", "Fiji", "Haiti", "Iceland", "Jamaica", "Japan", "Madagascar", 
				"Maldives", " Malta", "Mauritius", "Philippines",
				"Seychelles", "Singapore", "Taiwan", "Tonga", "Vanuatu"};
		
		
		
	//output to start
	System.out.println("<<<<<< Welcome to the game! >>>>>>");
	System.out.println("The theme of the game is - Island Countries!");
	System.out.println();
		
		
		
	do {
			
		//declare an object
		HangmanLetters myHang = new HangmanLetters();
		
		//input Scanner to start the game
		Scanner sc = new Scanner(System.in);
		System.out.println("Press ENTER to START: ");
		sc.nextLine();
		
		//generating random word from String Array
	    Random r = new Random();
	    int randomWord = r.nextInt(word.length);
	    
	    //convert letters of the random word to *** using method from instantiable class
	    starWord = myHang.convertStars(word[randomWord]);					
	    
	    //add value for variable "lives" and add a variable of type boolean for finished game
		lives = 8;
		boolean gameFinished = false;
		
		//the loop which shows the word and lives until the game is not finished
		while (lives > 0 && !gameFinished) {
			System.out.println("Word: " + starWord);
			System.out.println("Lives: " + lives);
			
			//show whether the letter was used before using method from instantiable class 
			if (myHang.getLength() == 0) {
				System.out.println(" no letters used yet");
				System.out.println();
				
			}else {
				myHang.showUsedLetters();
				
			}
		 
			//add value to the variable "currentLetter" and add a variable of type boolean for used letter
			currentLetter = ' '; 
			boolean usedLetter = false;
			
		do {
			
			//show message if the letter was used
			if (usedLetter) {
			System.out.println("The letter " + "<<" + currentLetter + ">>"+ " was used!");
			}
				
			//ask the user to guess a letter
			System.out.println("Guess a letter: ");
			//user input
			currentLetter = sc.next().charAt(0);
			System.out.println();
			
			//check if the letter was used by using method from instantiable class
			usedLetter = myHang.letterWasUsed(currentLetter);	
				
				
			} while (usedLetter);
			  boolean newLetter = false;

			//convert the word to char Array to check if the letter is in the word
			char[] showLettersInTheWord = starWord.toCharArray(); //convert to char Array
				for(char i=0; i<showLettersInTheWord.length; i++) { //check if the letter is in the word
					if(Character.toLowerCase(word[randomWord].charAt(i)) == currentLetter) {
						showLettersInTheWord[i] = currentLetter;
						newLetter = true;
					}
				//return the word from char Array back to String
				} starWord = String.copyValueOf(showLettersInTheWord);
				
			//minus life if the letter is not in the word
			if(!newLetter) {
				lives--;
			}   myHang.usedLettersLine(currentLetter);
			
			//if there are still *** in the word the game is not finished
			if (!starWord.contains("*")) {
				gameFinished = true;
						 
			}
		}
					
		   //the game is lost if there are no more lives
		   if (lives == 0 && !gameFinished) {
			  gamesLost++;
			  System.out.println("GAME OVER! The word was: " + word[randomWord]);
			  System.out.println();
		   }else {
			  gamesWon++;
			  System.out.println("Congratulations! The word was: " + word[randomWord]);
			  System.out.println();
		   }
					
		   //show statistics to the user
		   System.out.println("Statistics: ");
		   System.out.println("Games lost: " + gamesLost);
		   System.out.println("Games won: " + gamesWon);
		  
	    //ask if the user would like to play again 
	    System.out.println("Would you like to play again (yes/no)?");
		//input from the user   
	    agree = sc.next().toLowerCase();

		//if the answer is "yes" the game starts again
		} while (agree.equalsIgnoreCase("yes"));	
		
		//if the answer is "no" the program is finished
	      if (agree.equalsIgnoreCase("no")) {
			System.out.println("Thank you for the game!");
			System.out.println();
		  }
	
		
	
		
	
	
		
	}//end main

}//end class

	



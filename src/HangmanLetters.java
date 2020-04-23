/* The task:
 
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


public class HangmanLetters {
	//declare a local variable
	private String letters = "";
	
	
	//constructor without parameters
	public HangmanLetters() {
	}
	
	//StringBuffer 
	StringBuffer sb = new StringBuffer();
	
	//method to convert letters to *** by using StringBuffer
	public String convertStars(String word) {
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == ' ') {
			sb.append(' ');
		  } else {
			sb.append('*');
		  }
		}return sb.toString();
	}
	
	
	//getter method
	public int getLength() {
		return letters.length();
	}
	
	//method to check if letter has been used
	public boolean letterWasUsed(char letter) {
		for(char i = 0; i < letters.length(); i++) {
			if (letters.charAt(i) == letter) {
				return true;
			}
		} return false;
	}
	
	//method to show letters which were already used
		public void showUsedLetters() {
			for (char i = 0; i < letters.length(); i++) {
				System.out.println("Used letters: " + letters.charAt(i)); 
			}
		}
	
	//method to add a letter to the line of used letters
	public void usedLettersLine(char nextLetter) {
		letters = letters + nextLetter;
		
	}

	
	
	
	
}//end class

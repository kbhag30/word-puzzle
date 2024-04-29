/*
* WordPuzzle.java
* Author: Kishan Bhagwandas
*
* Purpose: The purpose of the program is to solve a scrambled word
* given to the user. The program randomly chooses a word from a list
* of words in a text file. The program then scrambles the word and counts
* the indexes of the word. The scrambled word and the indexes will display 
* to the user to solve. A menu with options will also be given to the user to use
* when solving the puzzle.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the Clayton State University's Academic Honesty Policy and the
* policies of this course.
*/
import java.util.Random;
import java.util.Scanner;
import java.io.File;
public class WordPuzzle{
    public static void main(String[] args) throws Exception{
        //Step 1: Input file with list of words into the program
        //Scanner is used to pull the words from document
        File words = new File("words.txt");
        Scanner wordScan = new Scanner(words);
        Random rand = new Random();
        int wordCounter = 0;
        String[] words1 = new String[wordCounter];
        System.out.println("");

        //Step 2: read data from the file by counting the words
        while(wordScan.hasNext()){
            wordCounter++;
            String word = wordScan.nextLine();

            //Step 3: the number of indexs per word are counted
            for (int i = 0; i < wordCounter; i++){
                words1[i] = wordScan.nextLine();
            }
        }
        wordScan.close();

        //The indexes of the word are displayed
        int randWord = rand.nextInt(words1.length);
        for (int w = 0; w < words1[randWord].length(); w++) {
            System.out.print(w);
        }

        //Step 4: A random word is chosen and then the word is scrambled
        System.out.println("");
        String wordRand = words1[randWord];
        char wordChars[];
        wordChars = wordRand.toCharArray();

        for(int i=0; i<wordChars.length; i++){
            int randIndex = rand.nextInt(wordChars.length);
            char tempChar = wordChars[i];
            wordChars[i] = wordChars[randIndex];
            wordChars[randIndex] = tempChar;
        }
        
        for(char charV:wordChars){
            System.out.print(charV);
        }

        /*
        * Step 5: The user is given options to either swap letters in the word,
        * solve the word directly or quit the game.
        */
        int value = 0;
        int number = 1;
        int steps = 0;
        do{
            System.out.println("\n");
            System.out.println("Enter 1 to swap letters.");
            System.out.println("Enter 2 to solve the puzzle.");
            System.out.println("Enter 3 to quit the game.");
            System.out.println("");

            Scanner keyboard = new Scanner(System.in);
            int options = keyboard.nextInt();
            steps++;

            //If, else statements are used in order to initialize the any of the three options
            if(options > 0 && options < 2){
                //The first if statement provides the code for swapping letters 
                System.out.println("Enter the indexes separated by a space.");
                int index1 = keyboard.nextInt();
                int index2 = keyboard.nextInt();
                char temp = wordChars[index1];
                wordChars[index1] = wordChars[index2];
                wordChars[index2] = temp;                
                String charWord = new String(wordChars);
                System.out.println("");

                if(charWord.equals(wordRand)){
                    System.out.println("Congratulations! You solved the secret in " + steps + " steps.");
                    number = 0;
                }
                else{
                    for (int w = 0; w < words1[randWord].length(); w++) {
                        System.out.print(w);
                    }
    
                    System.out.println("");
                    wordChars = charWord.toCharArray();
                    System.out.print(charWord);
                    number = 1;
                }
            }
            else{
                if(options > 1 && options < 3){
                    //The second if statement gives the ability for the user to input their answer
                    //If the user puts the correct answer a message will display
                    //If the answer is incorrect the user will be given a try again message
                    System.out.println("Please enter the solved word:");
                    keyboard = new Scanner(System.in);                    
                    String userAnswer = keyboard.nextLine();
                    
                    if(userAnswer.equals(wordRand)){
                        System.out.println("Congratulations! You solved the secret in " + steps + " steps.");
                        number = 0;
                    }
                    else{
                        System.out.println("Wrong answer! Please try to solve again!");
                        System.out.println("");
                        
                        for (int w = 0; w < words1[randWord].length(); w++) {
                            System.out.print(w);
                        }
        
                        System.out.println("");
                        System.out.print(wordChars); 
                        number = 1;
                    }
                }
                else{
                    if(options > 2 && options < 4){
                        //The third if statement will allow the user to end the game manually
                        System.out.println("Game Over.");
                        number = 0;
                    }
                    else{
                        if(options > 3){
                            //If the user inputs an option not on the menu an error message will display
                            System.out.println("Error! Option not available. Please try again.");
                            System.out.println("");

                            for (int w = 0; w < words1[randWord].length(); w++) {
                                System.out.print(w);
                            }
            
                            System.out.println("");
                            System.out.print(wordChars); 
                            number = 1;
                        }
                    }
                }
            }
        }while(number > value);
    }    
}
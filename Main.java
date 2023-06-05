package dev.m3s.programming2.homework4;


//import java.io.File;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        /*File file = new File("words.txt");    //check if file exists. This is one way to check if file exist
                                                //but I prefer to just make a instance of Wordlist and check if wordlist of
                                                //wordlist does not have any words
        if (file.exists()) {
            System.out.println("File exists");
        } else {
            System.out.println("File does not exist");
        }*/

        WordList wordlist = new WordList("words.txt");      //if file doesn't exist wordlist object of
        Hangman hangman = null;                                      //wordlist is just empty. I assume that this
                                                                     //can be one way to handle missing file problem.

        /*int  x = 0;                     

        do {
            System.out.println("Give amount of guesses: ");
            String input = sc.nextLine();  //input for asking amount of guesses from user
            try 
            { 
                x = Integer.parseInt(input); 
            }  
            catch (NumberFormatException e)  
            { 
                x = 0;
            } 
        } while (x <= 0);*/

        if (wordlist.giveWords().isEmpty()) {
            System.out.println("File not found or it was empty");
        } else {
            hangman = new Hangman(wordlist, 10);
        }
        if (hangman != null) {
            while (!hangman.theEnd()) {
                System.out.println("The hidden word...\n");
                System.out.println(hangman.getSituation() + "\n");
                System.out.println("Guesses left: " + hangman.guessesLeft());
                System.out.println("Guessed letters: " + hangman.guesses() + "\n");
                Character c = ' ';
                try {
                    System.out.println("Guess a letter: ");
                    c = sc.next().charAt(0);
                } catch (Exception e) {
                }
                hangman.guess(c);
                System.out.println("");
            }
            if (hangman.guessesLeft() == 0) {
                System.out.println("Sorry, you lost!");
                System.out.println("The hidden word was: " + hangman.word());
            } else {
                System.out.println("Congratulations! You won!!!");
                System.out.println("The hidden word was: " + hangman.word());
            }
        }
    }
}

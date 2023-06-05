package dev.m3s.programming2.homework4;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {

    private String word;
    private String situation;
    private ArrayList<Character> guesses = new ArrayList<Character>();
    private int guessesLeft;

    public Hangman(WordList wordlist, int guessesLeft) {
        int i = new Random().nextInt(wordlist.giveWords().size());
        word = wordlist.giveWords().get(i);
        System.out.println(i);
        System.out.println(word);
        this.guessesLeft = guessesLeft;
        situation = "";
        for (i=0; i < word.length(); i++) {
            situation = situation + '*';
        }
        System.out.println(situation);
    }

    public boolean guess(Character c) {
        if (!guesses.contains(Character.toLowerCase(c)) && !guesses.contains(Character.toUpperCase(c))) {
            guesses.add(Character.toLowerCase(c));
            setSituation(c);
        }
        if (word.indexOf(Character.toLowerCase(c)) == -1 && word.indexOf(Character.toUpperCase(c)) == -1) {
            guessesLeft--;
            return false;
        }
        return true;
    }

    public List<Character> guesses() {
        return guesses;
    }

    public int guessesLeft() {
        return guessesLeft;
    }

    public String word() {
        return word;
    }

    public String getSituation() {
        String s = "";
        int i;
        for (i=0; i<situation.length()-1; i++) {
            s = s + situation.charAt(i) + ' ';
        }
        return s + situation.charAt(i);
    }

    public boolean theEnd() {
        if (guessesLeft > 0) {
            for (Character c : word.toCharArray()) {
                if (!guesses.contains(Character.toLowerCase(c)) && !guesses.contains(Character.toUpperCase(c))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void setSituation(Character c) {
        char[] cArr = situation.toCharArray();
        for (int i=0; i<word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) == c || Character.toUpperCase(word.charAt(i)) == c) {
                cArr[i] = word.charAt(i);
            }
        }
        situation = String.valueOf(cArr);
    }

}
package dev.m3s.programming2.homework4;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordList {

    private List<String> wordlist;

    public WordList(String textfile) {
        wordlist = new ArrayList<>();
		try (BufferedReader text = new BufferedReader(new FileReader(textfile))) {
			String line = text.readLine();
			while (line != null) {
				wordlist.add(line);
				line = text.readLine();
			}
			text.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
	    } catch (IllegalArgumentException e) {
        }
    }

    public WordList(List<String> wordlist) {
        this.wordlist = wordlist;
    }

    public List<String> giveWords() {
        return wordlist;
    }

    public WordList theWordsOfLength(int length) {
        List<String> newWordList = new ArrayList<String>();
        for (String s : wordlist) {
            if (s.length() == length) {
                newWordList.add(s);
            }
        }
        return new WordList(newWordList);
    }

    public WordList theWordsWithCharacters(String someString) {
        List<String> newWordList = new ArrayList<String>();
        for (String s : wordlist) {
            if (s.length() == someString.length()) {
                boolean match = true;
                for (int i=0; i<s.length(); i++) {
                    if (someString.charAt(i) != '_' && s.charAt(i) != someString.charAt(i)) {
                        match = false;
                    } 
                }
                if (match) {
                    newWordList.add(s);
                }
            }
        }
        return new WordList(newWordList);
    }

}
/*--------------------------------------------------------------------------
GWU CSCI1112 Spring 2020
author: Maxwell Cunningham

This class provides a variety of methods to match a set of letters with one
or more words in a dictionary.  This class supports scramble type games 
where players are asked to find a word given a set of letters that have no
particular order.
--------------------------------------------------------------------------*/

public class WordGame {
    // ---------------------------------------------------------------------
    // Base
    // ---------------------------------------------------------------------

    /// contains determines whether word can be spelled using the characters
    /// in letters
    /// @param letters the set of letters with which to try to spell word
    /// @param word the word that will try to be spelled
    /// @return true if word can be spelled using letters; otherwise, false
    static boolean contains(String letters, String word) 
    {
    //TODO: FILL IN YOUR CODE HERE
	//check if there are enough characters in the letters string to spell the word
	if (word == null || letters == null || word.length() > letters.length()) {
		return false;
	}
	//return true if the word is an empty string and letters is not
	if (word == "" && letters.length() > 0) {
		return true;
	} 
	//Create two new arrays with an index for every possible letter
	int[] let = new int[26];
	int[] wod = new int[26];
	//Add +1 to the cooresponding index of each letter in both strings
	for (int i = 0; i < letters.length(); i++) {
		int ch = (int) letters.charAt(i) - 'a';
			let[ch]++;
	}
	for (int j = 0; j < word.length(); j++) {
		int ch1 = (int) word.charAt(j) - 'a';
			wod[ch1]++;
	}
	//check to see if there are enough values of each letter to create the word
	for (int k = 0; k < wod.length;k++) {
	    if (wod[k]>let[k]) {
            return false;
        }
    }
    return true;
 }
    /// search locates the longest word in the set of words that can be
    /// spelled using the characters in letters.
    /// @param letters the set of letters with which to try to spell word
    /// @param words the dictionary of words that is to be searched
    /// @return null if any of the parameters are invalid references, an 
    ///         empty string if no word in words is found, or a word 
    ///         selected from words if a word is found
    public static String search(String[] words, String letters) {
		///Check if letters or the array of words is null
		if (letters == null || words == null) {
			return null;
		}
		///Search each element in words[] to figure out if the letters can spell it
		String longer  = new String("");
		for (int i = 0; i < words.length; i++) {
			///letters must contain words[i] and be longer than the string
            String w = words[i];
			if (WordGame.contains(letters,w) &&  w.length() > longer.length()) { 
						longer = w;
			}
		}
        return longer;   // Note this line provided so it will compile.
    }

    // ---------------------------------------------------------------------
    // Extension
    // ---------------------------------------------------------------------

    /// collect composes a list of all words in the set of words that can be
    /// spelled using the characters in letters.
    /// @param letters the set of letters with which to try to spell word
    /// @param words the dictionary of words that is to be searched
    /// @return null if any of the parameters are invalid references, an 
    ///         empty array if no word in words is found, or the set of all
    ///         words selected from words that are found that can be spelled
    ///         using letters
    static String[] collect(String[] words, String letters) {
        //TODO: FILL IN YOUR CODE HERE 
        //check to see if the array of words or letters is null
        if (words == null || letters == null) {
            return null;
        }
        //figure out how many words can be spelled with the given letters
        int count = 0;
        for (int i=0;i<words.length;i++) {
             String w = words[i];
             if (WordGame.contains(letters,w)) {
                count++;
            }
        }
        //creates an array with a length equivalent to the amount of words that can be spelled
        String[] collection = new String[count];
        //create integer c to track what index to store the words in
        int c = 0;
        for (int j=0;j<words.length;j++) {
            String wo = words[j];
            if (WordGame.contains(letters,wo)) {
                collection[c]=wo;
                c++;
            }
        }
        return collection;   // Note this line provided so it will compile.
    }

    // ---------------------------------------------------------------------
    // Utilities
    // ---------------------------------------------------------------------
    /// This method trims out all characters that are not alphas and then
    /// converts the string to lowercase.
    /// @param s the string to clean
    /// @return the cleaned string 
    private static String clean(String s)
    {
        return s.replaceAll("[^a-zA-Z]","").toLowerCase();
    }
}

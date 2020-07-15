/*--------------------------------------------------------------------------
GWU CSCI1112 Spring 2020
author: James Taylor ... Note: I am implicitly claiming a copyright by 
        adding my name to this file.  You should always do this 

This is a set of unit tests that validate the WordGame class which is 
intended to facilitate playing Countdown.
--------------------------------------------------------------------------*/
class WordGameUnitTests {
    // This is a case where a global reference to a dictionary makes sense.
    // The dictionary is a read only database of sorts and we wish to have 
    // this reference available for any unit tests that need to use the 
    // whole dictionary.  We also wish to load it only once.
    static String[] dictionary;
    // For most cases, this would be a bad decision, but it is acceptable
    // here given the above behavior and requirements

    /// The main function acts as the test harness.  Any unit tests must be
    /// registered in this function.
    public static void main(String[] args) {
        // Get the dictionary.
        dictionary = WordTool.getDictionary ();

        // fail tracks whether any test has failed.
        boolean fail = false;
        
        // * Run the battery of base tests *
        System.out.println("Base Test 1 - Begin");
    	if( baseUnitTest1() ) {
    	    System.out.println("Base Test 1 - Succeeded");
    	} else {
    	    System.out.println("Base Test 1 - Failed");
            fail = true;
    	}
    
        System.out.println("Base Test 2 - Begin");
    	if( baseUnitTest2() ) {
    	    System.out.println("Base Test 2 - Succeeded");
    	} else {
    	    System.out.println("Base Test 2 - Failed");
            fail = true;
    	}
    
        System.out.println("Base Test 3 - Begin");
    	if( baseUnitTest3() ) {
    	    System.out.println("Base Test 3 - Succeeded");
    	} else {
    	    System.out.println("Base Test 3 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 4 - Begin");
    	if( baseUnitTest4() ) {
    	    System.out.println("Base Test 4 - Succeeded");
    	} else {
    	    System.out.println("Base Test 4 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 5 - Begin");
    	if( baseUnitTest5() ) {
    	    System.out.println("Base Test 5 - Succeeded");
    	} else {
    	    System.out.println("Base Test 5 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 6 - Begin");
    	if( baseUnitTest6() ) {
    	    System.out.println("Base Test 6 - Succeeded");
    	} else {
    	    System.out.println("Base Test 6 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 7 - Begin");
    	if( baseUnitTest7() ) {
    	    System.out.println("Base Test 7 - Succeeded");
    	} else {
    	    System.out.println("Base Test 7 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 8 - Begin");
    	if( baseUnitTest8() ) {
    	    System.out.println("Base Test 8 - Succeeded");
    	} else {
    	    System.out.println("Base Test 8 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 9 - Begin");
    	if( baseUnitTest9() ) {
    	    System.out.println("Base Test 9 - Succeeded");
    	} else {
    	    System.out.println("Base Test 9 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 10 - Begin");
    	if( baseUnitTest10() ) {
    	    System.out.println("Base Test 10 - Succeeded");
    	} else {
    	    System.out.println("Base Test 10 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 11 - Begin");
    	if( baseUnitTest11() ) {
    	    System.out.println("Base Test 11 - Succeeded");
    	} else {
    	    System.out.println("Base Test 11 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 12 - Begin");
    	if( baseUnitTest12() ) {
    	    System.out.println("Base Test 12 - Succeeded");
    	} else {
    	    System.out.println("Base Test 12 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 13 - Begin");
    	if( baseUnitTest13() ) {
    	    System.out.println("Base Test 13 - Succeeded");
    	} else {
    	    System.out.println("Base Test 13 - Failed");
            fail = true;
    	}

        System.out.println("Base Test 14 - Begin");
    	if( baseUnitTest14() ) {
    	    System.out.println("Base Test 14 - Succeeded");
    	} else {
    	    System.out.println("Base Test 14 - Failed");
            fail = true;
    	}

        if( fail ) {
            System.out.println("Failed Base Unit Testing");
        } else {
            System.out.println("Passed Base Unit Testing");
        }

        if( fail ) {
            System.out.println("If the base tests are all passed, new tests will be added for the extension.");
            return;
        }

        // * Run the battery of extension tests *
        System.out.println("Extension Test 1 - Begin");
    	if( extUnitTest1() ) {
    	    System.out.println("Extension Test 1 - Succeeded");
    	} else {
    	    System.out.println("Extension Test 1 - Failed");
            fail = true;
    	}

        System.out.println("Extension Test 2 - Begin");
    	if( extUnitTest2() ) {
    	    System.out.println("Extension Test 2 - Succeeded");
    	} else {
    	    System.out.println("Extension Test 2 - Failed");
            fail = true;
    	}

        System.out.println("Extension Test 3 - Begin");
    	if( extUnitTest3() ) {
    	    System.out.println("Extension Test 3 - Succeeded");
    	} else {
    	    System.out.println("Extension Test 3 - Failed");
            fail = true;
    	}

        System.out.println("Extension Test 4 - Begin");
    	if( extUnitTest4() ) {
    	    System.out.println("Extension Test 4 - Succeeded");
    	} else {
    	    System.out.println("Extension Test 4 - Failed");
            fail = true;
    	}

        System.out.println("Extension Test 5 - Begin");
    	if( extUnitTest5() ) {
    	    System.out.println("Extension Test 5 - Succeeded");
    	} else {
    	    System.out.println("Extension Test 5 - Failed");
            fail = true;
    	}

        if( fail ) {
            System.out.println("Failed Extension Unit Testing");
        } else {
            System.out.println("Passed Extension Unit Testing");
        }
    }

    //--------------------------- Base Unit Tests -----------------------

    /// This test validates that contains returns false if word is null
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest1() {
        String letters = "ddax";
        String word = null;
        boolean result = WordGame.contains(letters, word);

	    if(result != false) {
	        return false;
	    }
	    return true;
    }

    /// This test validates that contains returns false if letters is null
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest2() {
        String letters = null;
        String word = "add";
        boolean result = WordGame.contains(letters, word);

	    if(result != false) {
	        return false;
	    }
	    return true;
    }

    /// This test validates that contains returns false if letters is an
    /// empty string
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest3() {
        String letters = "";
        String word = "add";
        boolean result = WordGame.contains(letters, word);

	    if(result != false) {
	        return false;
	    }
	    return true;
    }

    /// This test validates that contains returns true if word is an empty
    /// string
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest4() {
        String letters = "ddax";
        String word = "";
        boolean result = WordGame.contains(letters, word);

	    if(result == false) {
	        return false;
	    }
	    return true;
    }

    /// This test validates that contains returns true if the word can be
    /// spelled using the set of letters
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest5() {
        String letters = "ddax";
        String word = "add";
        boolean result = WordGame.contains(letters, word);

	    if(result == false) {
	        return false;
	    }
	    return true;
    }

    /// This test validates that contains returns true if the word cannot
    /// be spelled using the set of letters
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest6() {
        String letters = "zzz";
        String word = "add";
        boolean result = WordGame.contains(letters, word);

	    if(result != false) {
	        return false;
	    }
	    return true;
    }

    /// Test checks whether search properly handles a null dictionary.
    /// search should return an empty string if it cannot find a word in the
    /// dictionary.  The dictionary is invalid, so search should return an 
    /// empty string.
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest7() {
        String letters = "aaaaaa";
        String word = WordGame.search(null, letters);

	    if(word != null) {
	        return false;
	    }
	    return true;
    }

    /// This test checks whether search properly handles a null set of 
    /// letters.  search should return an empty string if it cannot find a
    /// word in the dictionary.  The set of letters in invalid, so search 
    /// should return an empty string. 
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest8() {
        String word = WordGame.search(dictionary, null);

	    if(word != null) {
	        return false;
	    }
	    return true;
    }

    /// Test checks whether search properly handles an empty dictionary.
    /// search should return an empty string if it cannot find a word in the
    /// dictionary.  The dictionary contains nothing, so search should 
    /// return an empty string.
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest9() {
        String letters = "aaaaaa";
        // Note: this seems weird.  Allocating an array of size 0, WTH?  
        // You can do it.  It also seems weird that this call doesn't store
        // that array in a variable at all, it just passes in the new array
        // as a parameter.  Guess what, you can do that too.
        String word = WordGame.search(new String[0], letters);

	    if(word == null) {
	        return false;
	    }
	    if(word.compareTo("") != 0) {
	        return false;
	    }
	    return true;
    }

    /// Test checks whether search properly handles an empty set of letters.
    /// search should return an empty string if it cannot match letters with
    /// a word in the dictionary.  letters contains nothing, so search 
    /// should return an empty string.
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean baseUnitTest10() {
        String letters = "";
        String word = WordGame.search(dictionary, letters);

	    if(word.compareTo("") != 0) {
	        return false;
	    }
	    return true;
    }

    /// Tests the case where a set of letters cannot be matched with any 
    /// word in the dictionary.  The test is successful if search returns
    /// an empty string "" and otherwise fails.
    /// @return true if search returns an empty string; otherwise, false 
    public static boolean baseUnitTest11() {
        // In this test, the word should not exist.  This test is 
        // intentionally designed to search for a word that does not exist
        // in the dictionary of words.

        String letters = "aaaaaa";
        String word = WordGame.search(dictionary, letters);

	    if(word.compareTo("") != 0) {
	        return false;
	    }
	    return true;
    }

    /// @return true if the test word is correctly identified in the set of
    ///         words; otherwise, returns false 
    public static boolean baseUnitTest12() {
        String letters = "ionsomsti";
        String word = WordGame.search(dictionary, letters);

	    if(word.compareTo("omission") != 0) {
	        return false;
	    }  
	    return true;
    }

    /// Tests whether the first word is correctly identified.  More than
    /// one word may share the set of letters; however, requirements expect
    /// search to return the first word in the dictionary that matches the
    /// most characters
    /// @return true if the earlist word among mulitple words is correctly 
    ///         identified in the set of words; otherwise, returns false 
    public static boolean baseUnitTest13() {
        String letters = "ddaz";
        String word = WordGame.search(dictionary, letters);

        // dad is a legal word from this set of letters, but it is not the
        // first candidate; therefore, if word is dad, the test fails
	    if(word.compareTo("dad") == 0) {
	        return false;
	    }
        // add is the first candidate word closest to the front of the 
        // dictionary that should match.  Test successful if word is add 
	    if(word.compareTo("add") != 0) {
	        return false;
	    }  
	    return true;
    }

    /// This test is not really any different than the previous test, but it
    /// does check for a long word
    /// @return true if the test word correctly identified in the set of 
    ///         words; otherwise, returns false 
    public static boolean baseUnitTest14() {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String word = WordGame.search(dictionary, letters);

	    if(word.compareTo("ambidextrous") != 0) {
	        return false;
	    }
	    return true;
    }

    //------------------------ Extension Unit Tests ---------------------

    /// This test validates that collect returns a null reference if the
    /// dictionary passed to it is null
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean extUnitTest1() {
        String letters = "aaaaaa";
        String[] words = WordGame.collect(null, letters);

	    if(words != null) {
	        return false;
	    }
	    return true;
    }

    /// This test validates that collect returns a null reference if the
    /// set of letters passed to it is null
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean extUnitTest2() {
        String[] words = WordGame.collect(dictionary, null);

	    if(words != null) {
	        return false;
	    }
	    return true;
    }

    /// This test validates that collect returns an empty set of words when
    /// a valid set of letters and a valid dictionary are passed to it
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean extUnitTest3() {
        String letters = "aaaaaa";
        String[] words = WordGame.collect(dictionary, letters);

	    if(words == null) {
	        return false;
	    }
	    if(words.length != 0) {
            //System.out.println(words);
	        return false;
	    }
	    return true;
    }

    /// This test validates that collect returns the correct set of words 
    /// when a valid set of letters and a valid dictionary are passed to it
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean extUnitTest4() {
        String letters = "ddaz";
        String[] words = WordGame.collect(dictionary, letters);

	    if(words.length == 0 || words.length > 3) {
	        return false;
	    }
        String[] expected = {"ad", "add", "dad"};
        for(int i = 0; i < words.length; i++) {
            //System.out.println(words[i]);
            boolean found = false;
            for(int j = 0; j < expected.length; j++) {
                if( words[i].compareTo(expected[j]) == 0 ) {
                    found = true;
                    break;
                }
            }
            if( !found ) {
                return false;
            }
        }
	    return true;
    }

    /// This test validates that collect returns the correct set of words 
    /// when a valid set of letters and a valid dictionary are passed to it
    /// It is not really any different than the previous test other than
    /// the set of found words is rather large
    /// @return true if the test is successful; otherwise, the test fails. 
    public static boolean extUnitTest5() {
        String letters = "ionsomsti";
        String[] words = WordGame.collect(dictionary, letters);

	    if(words.length == 0 || words.length > 45) {
	        return false;
	    }
        String[] expected = {"ii", "in", "insist", "into", "ion", "is", "it", "mi", "min", "mini", "minot", "mint", "miss", "mission", "mist", "mitosis", "moist", "moo", "moon", "moot", "moss", "most", "mot", "motion", "nit", "no", "not", "oint", "omission", "omit", "on", "onto", "sin", "sis", "sit", "so", "son", "soon", "soot", "ti", "tin", "to", "ton", "too", "toss"};

        for(int i = 0; i < words.length; i++) {
            //System.out.println(words[i]);
            boolean found = false;
            for(int j = 0; j < expected.length; j++) {
                if( words[i].compareTo(expected[j]) == 0 ) {
                    found = true;
                    break;
                }
            }
            if( !found ) {
                return false;
            }
        }
	    return true;
    }

}

public class pangramCheck {

    public static void main (String[] argv)
    {
        // Pangram: a sentence with at least one occurence of each letter 'a' to 'z'.

        String[] pangramWords = {"two", "driven", "jocks", "help", "fax", "my", "big", "quiz"};
        boolean isPangram = checkPangram (pangramWords);
        System.out.println ("isPangram=" + isPangram);

        String[] pangram2 = {"two", "driven", "jocks", "help", "fax", "my", "big"};
        isPangram = checkPangram (pangram2);
        System.out.println ("isPangram=" + isPangram);
    }


    static boolean checkPangram (String[] words)
    {
	//creates a new array that has an element for every letter in the alphabet
	int[] check = new int[26];

        //nested for loop that converts every letter into an integer
	//then adds +1 to the cooresponding element to each integer. for example, 1 would be added to index 0 if the character is an a
	for (int i = 0; i < words.length; i++) {
		for (int j = 0; j<words[i].length();j++) {
			int ch = (int) words[i].charAt(j) - 'a';
			check[ch]++;
		}	
	}

	//checks the array for any empty elements. if an element is empty, then the array is not a pangram
	for (int k = 0; k < check.length;k++) {
		if (check[k] == 0) {
			return false;
		}
        }	
    	return true;
     }
}

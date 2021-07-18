package course3.week5;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary
{
    private TreeSet<String> dict;

    // Implement the dictionary interface using a TreeSet.
    // You'll need a constructor here
    public DictionaryBST() {
        dict = new TreeSet<String>();
    }


    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary
     * (it wasn't already there). */
    public boolean addWord(String word) {
        // Implement this method
        String wordToAdd = word.toLowerCase();
        if(dict.contains(wordToAdd)) {
            return false;
        } else {
            dict.add(wordToAdd);
            return true;
        }

    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        String wordToFind = s.toLowerCase();
        // Implement this method
        if(dict.contains(wordToFind)) {
            return true;
        }
        return false;
    }

}
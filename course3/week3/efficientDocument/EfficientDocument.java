package week3.efficientDocument;
import java.util.*;
public class EfficientDocument extends Document {

    private int numWords;  // The number of words in the document
	private int numSentences;  // The number of sentences in the document
	private int numSyllables;  // The number of syllables in the document

    public EfficientDocument(String text)
	{
		super(text);
		processText();
	}
    private boolean isWord(String tok)
	{
	    // Note: This is a fast way of checking whether a string is a word
	    // You probably don't want to change it.
		return !(tok.indexOf("!") >=0 || tok.indexOf(".") >=0 || tok.indexOf("?")>=0);
	}

    private void processText()
	{
		// Call getTokens on the text to preserve separate strings that are 
		// either words or sentence-ending punctuation.  Ignore everything
		// That is not a word or a sentence-ending puctuation.
		// MAKE SURE YOU UNDERSTAND THIS LINE BEFORE YOU CODE THE REST
		// OF THIS METHOD.
		List<String> tokens = getTokens("[!?.]+|[a-zA-Z]+");
		
		// Finish this method.  Remember the countSyllables method from 
		// Document.  That will come in handy here.  isWord defined above will also help.
		numWords = 0;
		numSentences = 0;
		numSyllables = 0;
		for (int i=0;i<tokens.size();i++) {
			if (isWord(tokens.get(i))) {
				numWords += 1;
				numSyllables += countSyllables(tokens.get(i));
				if(i == tokens.size() -1) {
					numSentences += 1;
				}
			} else {
				numSentences += 1;
			}
		}
	}


    @Override
	public int getNumSentences() {
		// write this method.  Hint: It's simple
		return numSentences;
	}

    @Override
	public int getNumWords() {
		// write this method.  Hint: It's simple
	    return numWords;
	}

    @Override
	public int getNumSyllables() {
        // write this method.  Hint: It's simple
        return numSyllables;
	}

    public static void main(String[] args)
	{
	    testCase(new EfficientDocument("This is a test.  How many???  "
                + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
                16, 13, 5);
        testCase(new EfficientDocument(""), 0, 0, 0);
        testCase(new EfficientDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
        testCase(new EfficientDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2); 
        testCase(new EfficientDocument("Here is a series of test sentences. Your program should "
				+ "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
				+ "the correct amount of syllables (example, for example), "
				+ "but most of them will."), 49, 33, 3);
		testCase(new EfficientDocument("Segue"), 2, 1, 1);
		testCase(new EfficientDocument("Sentence"), 2, 1, 1);
		testCase(new EfficientDocument("Sentences?!"), 3, 1, 1);
		testCase(new EfficientDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
		         32, 15, 1);
		
	}
}

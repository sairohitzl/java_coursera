import java.util.ArrayList;
import edu.duke.*;

public class WordFrequencies
{
  private ArrayList<String> myWords;
  private ArrayList<Integer> myFreqs;

  public WordFrequencies()
  {
      myWords=new ArrayList<String>();
      myFreqs=new ArrayList<Integer>();
  }

  public void findUnique() 
  { 
    myWords.clear();
    myFreqs.clear();
    FileResource Resource = new FileResource("testfile.txt");
    for(String s: Resource.words())
        {
        s = s.toLowerCase();
        int index = myWords.indexOf(s);
        if(!myWords.contains(s))
            {
            myWords.add(s);
            myFreqs.add(1);
            }
        else 
            {
            int count = myFreqs.get(index);
            myFreqs.set(index,count+1); 
            }
        }
    }

    public void tester() 
    {
        findUnique();
        System.out.println("no of unique words: "+myWords.size());
        
        for (int i =0; i < myWords.size();i++)
        {
            System.out.println(myWords.get(i)+" "+ myFreqs.get(i));
        }
        int index = findIndexOfMax();
        System.out.println("max word/freq: " +myWords.get(index)+" "+myFreqs.get(index));
        
        
    }
     
    public int findIndexOfMax() 
    {
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int i=0; i< myFreqs.size(); i++) {
            if (myFreqs.get(i) >max) {
                max = myFreqs.get(i);
                maxIndex = i;
            }
            
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        WordFrequencies wf=new WordFrequencies();
        wf.tester();
    }

}
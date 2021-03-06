import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) 
    {
        FileResource fr=new FileResource(filename);
        for(String line:fr.lines())
        {
            WebLogParser.parseEntry(line);
            records.add(WebLogParser.parseEntry(line));
        }
    }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}


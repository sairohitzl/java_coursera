import java.util.*;
import edu.duke.*;



public class LogAnalyzer2
{
     private ArrayList<LogEntry> records;
     public LogAnalyzer2() {
         records = new ArrayList<LogEntry>();
     }
      
     
     public void readFile(String filename) 
     {
         FileResource resource = new FileResource(filename);
          for(String line: resource.lines()){
              WebLogParser.parseEntry(line);
              records.add(WebLogParser.parseEntry(line));}                        
     }
     
     public int countUniqueIPs() {
        
        ArrayList<String> uniqueIPs = new ArrayList<String>();
       
        for(LogEntry le: records) {
        
        String ipAddr = le.getIpAddress();
        
            if(!uniqueIPs.contains(ipAddr)) {
                
                uniqueIPs.add(ipAddr);
            }
        }
        
        
        return uniqueIPs.size();
     }
        
     public void printAllHigherThanNum(int Num) { 
         
        for(LogEntry le: records) {
        
        int statusCode = le.getStatusCode();
        
            if(statusCode > Num) {
                
                System.out.println("StatusCode greater than "+Num+": "+statusCode);
            }
        }
           
     }   
     
     public void uniqueIPVisitsOnDay(String someday)
    {
         ArrayList<String> myIPs = new ArrayList<String>();
         
         String myString = null;
         
         
         
         for(LogEntry le: records)
        {
             Date d = le.getAccessTime();
             String ipAddr = le.getIpAddress();
             
             myString = d.toString();
             
             
             if((myString.contains(someday)) && (!myIPs.contains(ipAddr)))
            {
                myIPs.add(ipAddr);
            }
        }
         
         for(int k =0; k < myIPs.size();k++)
         {
                     System.out.println(myIPs.get(k)+"\t"); 
         }
         System.out.println("Array size: "+myIPs.size());           
    }
         
     
     public int countUniqueIPsInRange(int low, int high){
        
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry New: records) 
        {
        
        int statusCode = New.getStatusCode();
        String ipAddr = New.getIpAddress();
       
            if((statusCode >= low) && (statusCode <= high)) {
                if(!uniqueIPs.contains(ipAddr)) {
                
                uniqueIPs.add(ipAddr);
                }
            }
        }
        return uniqueIPs.size();
     }
        
     public void printAll() 
     {
         for(LogEntry le : records) {
             System.out.println(le);
         }
     }  
}
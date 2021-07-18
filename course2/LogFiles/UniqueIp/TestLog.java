import java.util.*;

public class TestLog
{
    
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer2 LogAnalyzer = new LogAnalyzer2();
        LogAnalyzer.readFile("short-test_log");
        LogAnalyzer.printAll();
    }
    
    public void testUniqIP() {
        LogAnalyzer2 la = new LogAnalyzer2();
        la.readFile("short-test_log");
        int uniqueIPS = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPS + " IPs"); 
    }
    
    public void testprintAllHigherthanNum() {
        LogAnalyzer2 MyLogAnalyser = new LogAnalyzer2();
        MyLogAnalyser.readFile("weblog1_log");
        MyLogAnalyser.printAllHigherThanNum(400);
    }
    
    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer2 MyAnalyser = new LogAnalyzer2();
        MyAnalyser.readFile("weblog1_log");
        
        MyAnalyser.uniqueIPVisitsOnDay("Mar 17");
 
    }
    
    public void testcountUniqueIPsInRange() {
        LogAnalyzer2 Analyser = new LogAnalyzer2();
        Analyser.readFile("weblog1_log");
        int countinRange_first = Analyser.countUniqueIPsInRange(200, 299);
        
        System.out.println("There are firstly " + countinRange_first + " IPs");
       
    }

    public static void main(String[] args) {
        TestLog tl=new TestLog();
        tl.testuniqueIPVisitsOnDay();
    }
}
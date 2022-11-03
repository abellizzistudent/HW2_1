//reads two timestamps of two events from a user and displays the difference between the two timestamps. For the program, you can assume that each timestamp is composed of the hour (0 ~ 23), minute (0 ~ 59), and second (0 ~ 59) format. Your program should present the difference from the second event (= second timestamp) to the first event (= first timestamp). Note that the second event always happens after the first event and your program should display the time difference of the events.
  
import java.util.*;
import java.text.*;
  
public class Main {

    //Turn user entered String into a Date object so we can do math with it
    public static Date parseTime(String entry) throws Exception
    {
        // Create object to parse time
        SimpleDateFormat formatEntry
            = new SimpleDateFormat("dd:HH:mm:ss");

        Date timeParsed = formatEntry.parse(entry);
        return timeParsed;
    }

    //Find the difference of two Date objects, 2nd Date always being after the 1st
    //Day was previously appended to the input after user entry below so math will work
    public static void calculateDiff(Date date1, Date date2)
    {
        // Calculating the difference in milliseconds
        long diffInMs  = Math.abs(date2.getTime() - date1.getTime());
        
        // Calculating the difference in Hours
        long differenceInHours
            = (diffInMs / (60 * 60 * 1000))
              % 24;
        String hoursPadded = String.format("%02d", differenceInHours);
  
        // Calculating the difference in Minutes
        long differenceInMinutes
            = (diffInMs / (60 * 1000)) % 60;
        String minutesPadded = String.format("%02d", differenceInMinutes);
  
        // Calculating the difference in Seconds
        long differenceInSeconds
            = (diffInMs / 1000) % 60;
        String secondsPadded = String.format("%02d", differenceInSeconds);
        
        System.out.println(hoursPadded + ":" + minutesPadded + ":" + secondsPadded);

        return; 
    }
  
    public static void main(String[] args) throws Exception
    {
        //Get two dates as Strings from the user
        Scanner scanner = new Scanner(System.in);
        String inA = scanner.next();
        String inB = scanner.next();
        scanner.close();

        //Append a String value for the day field to match SimpleDateFormat of dd:HH:mm:ss defined in parseTime method above
        inA = "01:"+inA;
        inB = "02:"+inB;

        //Turn Strings into Date objects for the next method parameters
        Date date1 = parseTime(inA);
        Date date2 = parseTime(inB);
          
        calculateDiff(date1, date2);
    }
}
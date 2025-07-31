package Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Date {
	
	public static String date() {

        //Uploaded on Jul 08, 2025
        
        LocalDate today = LocalDate.now();
        String formattedToday = today.format(DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH));
        System.out.println(formattedToday);
		return formattedToday;
    }

}

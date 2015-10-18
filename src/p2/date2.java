package p2;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class date2 {
	
	public static final String DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";

	  public static String now() {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    return sdf.format(cal.getTime());

	  }

	  public static void  main(String arg[]) {
	    System.out.println("Now : " + date2.now());
	  }
	}

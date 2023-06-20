package helperMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String getDate(int i) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date1;
		// Date today = calendar.getTime();
		calendar.add(Calendar.DATE, i);
		Date tomorrow = calendar.getTime();
		date1 = sdf.format(tomorrow);
		return date1;
	}

	public static String getTime(int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, i);
		Date tomorrow = calendar.getTime();
		String hours = tomorrow.toString();
		return hours;
	}

	public static String getTimeInMin(int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, i);
		int tomorrow = calendar.get(Calendar.MINUTE);
		String hours = String.valueOf(tomorrow);
		return hours;
	}

	public static String getTimeInSec(int i) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) + 3);
		int tomorrow = cal.get(Calendar.SECOND);
		String hours = String.valueOf(tomorrow);
		return hours;
	}

	public static String getDateAndTime(int i) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYYHH:mm:ss");
		String date1;
		// Date today = calendar.getTime();
		calendar.add(Calendar.DATE, i);
		Date tomorrow = calendar.getTime();
		date1 = sdf.format(tomorrow);
		return date1;
	}

	public boolean timediff(String time1) throws Exception {
		Date date1 = new SimpleDateFormat("dd/MM/yyyyHH:mm:ss").parse(time1);
		System.out.println("\t" + date1);
		/*
		 * Date date2=new SimpleDateFormat("dd/MM/yyyyHH:mm:ss").parse(time2);
		 * System.out.println("\t"+date1);
		 */
		return true;
	}

	public static String getDate1() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String date1;
		Date today = calendar.getTime();
		// Date tomorrow = calendar.getTime();
		date1 = sdf.format(today);
		return date1;
	}
}
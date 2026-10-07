import java.util.Calendar;

public class MyCal {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		//now.set(Calendar.DAY_OF_MONTH, 30);
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		
		System.out.println(year + "." + month + "." + day + "." + hour + ":" + minute);
		
	}

}

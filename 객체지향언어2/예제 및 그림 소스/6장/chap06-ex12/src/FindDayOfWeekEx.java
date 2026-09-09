import java.util.*;

public class FindDayOfWeekEx {
	public static String findDayOfWeek(int year, int month, int dayOfMonth) {
		Calendar cal = Calendar.getInstance(); // Calendar 객체 생성
		
		if(month<1 || month > 12) // month의 범위 오류 확인(1~12) 
			return "입력 오류! 달의 범위는 1~12입니다.";
		
		cal.set(Calendar.YEAR, year); // 캘린더 객체에 년도 지정
		cal.set(Calendar.MONTH, month-1); // 캘린더 객체에 월 지정
		
		// dayOfMonth의 범위 오류 확인(year 년의 month 달의 최대 일 수)
		// cal 객체에 설정된 년도와 월의 최대 날짜 알아내기(예:2024년 2월 경우 29)
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(dayOfMonth > maxDay) 
			return "입력 오류! "+year+"년 "+month+"월은 "+maxDay+"일까지입니다.";

		cal.set(Calendar.DAY_OF_MONTH, dayOfMonth); // 캘린더 객체에 일 지정
		
		// cal 객체에 설정된 년, 월, 일의 요일 알아내기
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일 알아내기
		String res="";
		switch(dayOfWeek) {
			case Calendar.SUNDAY : res = "일요일"; break; 
			case Calendar.MONDAY : res = "월요일"; break;
			case Calendar.TUESDAY : res = "화요일"; break;
			case Calendar.WEDNESDAY : res = "수요일"; break;		
			case Calendar.THURSDAY : res = "목요일"; break;
			case Calendar.FRIDAY : res = "금요일"; break;
			case Calendar.SATURDAY : res = "토요일"; break;	
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("년 월 일 입력>>");
			String line = scanner.nextLine();
			if (line.equals("그만"))
				break;
			StringTokenizer st = new StringTokenizer(line, " ");
			int year = Integer.parseInt(st.nextToken().trim());
			int month = Integer.parseInt(st.nextToken().trim());
			int dayOfMonth = Integer.parseInt(st.nextToken().trim());
			String dayOfWeek = findDayOfWeek(year, month, dayOfMonth);
			System.out.println(dayOfWeek);
		}
		scanner.close();		
	}
}
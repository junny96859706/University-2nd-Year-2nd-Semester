import java.util.StringTokenizer;

public class St {

	public static void main(String[] args) {
		String query = "name=Kitae&add=seoul&age=21";
		StringTokenizer s = new StringTokenizer(query,"&");
		
		int n = s.countTokens();
		System.out.println(n);
		
		/*for(int i=0;i<n;i++) {
			String token = s.nextToken();
			System.out.println(token);
		}*/
		
		/*while(s.hasMoreTokens()) {
			String token = s.nextToken();
			System.out.println(token);

		}*/
		
		String []sub = query.split("&");
		for(int i=0; i<sub.length;i++) {
			System.out.println(sub[i]);
		}
	}

}

public class Song {
	String title;
	String singer;
	int year;
	String lang; //가수의 나라
	
	Song(String title,String singer,int year,String lang){
		this.title = title;
		this.singer = singer;
		this.year = year;
		this.lang = lang;
	}
	
	void show() {
		System.out.print(year + "년 " + lang + "의 " + singer + "가 부른 " + title);
	}
	
	
	public static void main(String[] args) {
		Song song = new Song("가로수 그늘 아래 서면","이문세",1988,"한국");
		song.show();
		
		
	}

}

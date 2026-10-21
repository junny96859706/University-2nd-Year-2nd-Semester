
public class Exam7 {
	private String name;
	private int java,web,os;
	public Exam7(String name,int java,int web,int os) {
		this.name = name; this.java = java;
		this.web = web; this.os = os;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAverage() {
		return (java+web+os)/3;
	}
}



class TV{
	String tvName;
	int size;
	int price;
	
	TV(String tvName,int size,int price){
		this.tvName = tvName;
		this.size = size;
		this.price = price;
	}
	
	void show() {
		System.out.println(tvName + "에서 만든" + price + "만원짜리의 " + size + "인치 TV");
	}
}

public class Num1 {
	public static void main(String args[]) {
		TV tv = new TV("Samsung",50,300);
		tv.show();
	}
}

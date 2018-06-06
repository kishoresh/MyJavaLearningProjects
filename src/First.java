import java.util.regex.*;

class FreshJuice{

	enum FreshJuiceSize {SMALL, MEDIUM, HUGE};
	FreshJuiceSize size;
	int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// Constructor
	public FreshJuice(){
		size = FreshJuiceSize.SMALL;
	}

	public FreshJuice(FreshJuiceSize sz){
		size = sz;
	}
}

public class First {
	static int x = 5;
	
	public static void main(String[] args) {
		// First example - Hello World
		System.out.println("Hello World");
		
		x++;
		System.out.println(x--);    //checking post value.
		System.out.println(x--);    //checking post value.
		
		// 2nd Example - Enums using constructor's to initialize
		//FreshJuice juice = new FreshJuice(FreshJuice.FreshJuiceSize.MEDIUM);
		FreshJuice juice = new FreshJuice();
		System.out.println("Juice Size is : " + juice.size);

		juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
		System.out.println("Juice Size is : " + juice.size);

		juice.size = FreshJuice.FreshJuiceSize.HUGE;
		System.out.println("Juice Size is : " + juice.size);

		juice.setPrice(200);
		System.out.println("Price of a Juice : " + juice.getPrice());

		//3rd Example - For loop
		int [] numbers = {10,20,30,40,50};
		for (int x : numbers){
			System.out.println(x);
			System.out.println(',');
		}

		//4th Java Regular Expression - Pattern & Matcher. There are 3 ways
		//1st way
		Pattern p = Pattern.compile(".s");
		Matcher m = p.matcher("as");
		Boolean b1 = m.matches();

		//2nd way
		Boolean b2 = Pattern.compile(".s").matcher("as").matches();

		//3rd way
		Boolean b3 = Pattern.matches(".s", "as");

		System.out.println(b1 + " "+ b2 + " "+ b3);

	}

}

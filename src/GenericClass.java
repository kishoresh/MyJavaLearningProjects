/*
 * A Generic class with generic type T.
 * T can be of any data type. The class name is followed by a type parameter section.
 * In this example we tested with Integer & String.
 */
public class GenericClass <T> {

	private T t;

	public void add(T t){
		this.t = t;
	}

	public T getT(){
		return t;
	}

	public static void main(String[] args) {

		GenericClass<Integer> intGeneric = new GenericClass<Integer>();
		GenericClass<String> strGeneric = new GenericClass<String>();

		intGeneric.add(10);
		strGeneric.add("Hello World");

		System.out.printf("Integer Value is %d\n",intGeneric.getT());
		System.out.printf("String value is %s\n",strGeneric.getT());

	}

}

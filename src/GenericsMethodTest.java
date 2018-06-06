/*
 * Generic method printArray()
 */
public class GenericsMethodTest {
	//generic method
	public static <E> void printArray(E[] inputArray){
		for(E element : inputArray){
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] intArr = {1,2,3,4,5};
		Double[] dblArr = {1.1,2.1,3.1,4.1};
		Character[] charArr = {'A','B','C','D'};

		printArray(intArr);
		printArray(dblArr);
		printArray(charArr);
	}

}

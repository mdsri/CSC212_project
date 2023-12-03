
public class test {

	public static void main(String[] args) {
		test(6);
	}
	
	public static void test(int x) {
		while(true) {
			x--;
			System.out.println(x);
			if(x == 0) {
				System.out.println("Done");
				return;
			}
		}
		
	}

}

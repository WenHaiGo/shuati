package recursion;

public class fbnq {

	static int fun(int n) {
		if (n <= 1) {
			return 1;
		}

		else {
			return fun(n - 1) + fun(n - 2);
		}
	}

	public static void main(String[] args) {
		for(int i= 0;i<10;i++)
		System.out.println(fun(i));
	}
}

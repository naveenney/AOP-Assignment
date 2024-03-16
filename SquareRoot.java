import java.util.*;

public class SquareRoot {

	public static int abs(int a) {
		int ab = a < 0 ? a * -1 : a;
		return ab;
	}

	public int squareRoot(int val) {
		int mul = 0, i = 1, temp = 0;
		while (val >= mul) {
			mul = i * i;

			if (val > mul)
				temp = mul;
			else if (val == mul)
				return i;
			i++;
		}

		int res = abs(val - temp);

		val = abs(val - mul);

		i = 0;

		if (val < res)
			while (true) {
				if (mul == (i * i))
					return i;
				i++;
			}
		else
			while (true) {
				if (temp == (i * i))
					return i;
				i++;
			}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.print("1.find square root:\n");

			System.out.print("2.exit\n");

			int n = sc.nextInt();

			switch (n) {
			case 1:

				System.out.print("enter the value:");
				int val = sc.nextInt();

				System.out.println(new SquareRoot().squareRoot(val));
				break;

			case 2:

				flag = false;
				System.out.println("Thank you");
				break;

			}

		}

	}
}

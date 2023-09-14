package cacl;

import java.util.Scanner;

public class Cacl {
	public static void main(String[] args) throws Exception {
		//System.out.println("Vvod znacheniy ");
		Scanner sc = new Scanner(System.in);		
		String input = sc.nextLine();
		System.out.println(Main.calc(input));

	}

	class Main {
		public static String calc(String input) throws Exception {

			String itog = "", inp1 = "", inp2 = "";
			char zn = ' ';
			int temp = 0, x = 0, y = 0;
			short r = 0;
			int result = 0;

			// String input = "1+9";
			// System.out.println(input);

			for (int i = 0; i < input.length(); i++) {

				if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'
						|| input.charAt(i) == '/') {
					zn = input.charAt(i);
					temp++;
					continue;
				}

				if (temp == 0) {
					inp1 = inp1 + input.charAt(i);
				} else if (temp == 1) {
					inp2 = inp2 + input.charAt(i);
				}

			}

			// System.out.println(inp1 + " " + zn + " " + inp2);
			if (temp > 1)
				throw new Exception("Neverniy format");
			if (zn == ' ')
				throw new Exception("Ne matematicheskaya operaciya");

			String[] lat = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
			String[] rim = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };

			for (int i = 0; i < 10; i++) {
				if (rim[i].equals(inp1)) {
					x = i + 1;
					r++;

				}
				if (inp1.equals(lat[i])) {
					x = i + 1;
					r--;
				}
				if (rim[i].equals(inp2)) {
					y = i + 1;
					r++;
				}
				if (inp2.equals(lat[i])) {
					y = i + 1;
					r--;
				}

			}

			// System.out.println(x + " " + zn + " " + y + " " + r);
			if (r == -2 || r == 2) {
			} else {
				throw new Exception("Nevernie znacheniya");
			}
			
//			if (r != Math.abs(2)) throw new Exception("Nevernie znacheniya");


			if (r > 0 && ((x - y) < 0) && zn == '-')
				throw new Exception("Net otricat rimskih chisel");

			switch (zn) {
			case '+': {
				result = x + y;
				break;
			}
			case '-': {
				result = x - y;
				break;
			}
			case '*': {
				result = x * y;
				break;
			}
			case '/': {
				result = x / y;
				break;
			}
			}
			//System.out.println(result);
			String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
	                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
	                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
	                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
	                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
	                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
	                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
	        };
			
			if (r==2) return roman[result];
			return "" + result;
		}
	}
}

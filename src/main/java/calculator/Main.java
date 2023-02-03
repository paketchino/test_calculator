package calculator;

import calculator.enumValue.Operation;
import calculator.enumValue.RomanEnum;
import calculator.exception.MyException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static String calculator(String input) throws Exception {
		int op1 = 0, op2 = 0, result = 0;
		String[] arr = reg(input);

		if (arr[3] != null) {
			if(romToAr(arr[3]) - romToAr(arr[5]) < 1 && arr[4].equals("-")) {
				throw new MyException(new IllegalAccessException("В римском алфавите отсутствуют отрицательные числа"));
			}
		}
		if (arr[0] != null) {
			op1 = Integer.parseInt(arr[0]);
		}
		if (arr[2] != null) {
			op2 = Integer.parseInt(arr[2]);
		}
		if (arr[3] != null) {
			op1 = romToAr(arr[3]);
		}
		if (arr[5] != null) {
			op2 = romToAr(arr[5]);
		}
		if (arr[1] != null && arr[1].equals("+") || arr[4] != null && arr[4].equals("+")) {
			result = Operation.SUM.action(op1, op2);
		}
		else if (arr[1] != null && arr[1].equals("-") || arr[4] != null && arr[4].equals("-")) {
			result = Operation.SUBTRACT.action(op1, op2);
		}
		else if (arr[1] != null && arr[1].equals("*") || arr[4] != null && arr[4].equals("*")) {
			result = Operation.MULTIPLY.action(op1, op2);
		}
		else if (arr[1] != null && arr[1].equals("/") || arr[4] != null && arr[4].equals("/")) {
			result = Operation.DIVIDE.action(op1, op2);
		}
		if(arr[3] != null) return arabicToRoman(result);
		return String.valueOf(result);
	}

	static String[] reg(String str) throws Exception {
		str = str.replace(" ", "");
		Pattern pattern = null;
		Matcher matcher = null;
		pattern = Pattern.compile("^([^\\+\\-\\*\\/])*$");
		matcher = pattern.matcher(str);
		if(matcher.find()) {
			throw new MyException(
					new IllegalAccessException(
							"Единое число не является арифметической операцией или вводите неверный арифметический знак"));
		}
		pattern = Pattern.compile("^([1-9]|10)([\\+\\-\\*\\/]){1}(I|II|III|IV|V|VI|VII|VIII|IX|X)$"
				+ "|^(I|II|III|IV|V|VI|VII|VIII|IX|X)([\\+\\-\\*\\/]){1}([1-9]|10)$");
		matcher = pattern.matcher(str);
		if(matcher.find()) throw new MyException(
				new IllegalAccessException(
						"Вы пытаетесь сложить арабски числа с римским")
		);

		pattern = Pattern.compile("^([1-9]|10)([\\+\\-\\*\\/]){1}([1-9]|10)$"
		+ "|^(I|II|III|IV|V|VI|VII|VIII|IX|X)([\\+\\-\\*\\/]){1}(I|II|III|IV|V|VI|VII|VIII|IX|X)$");
	    matcher = pattern.matcher(str);
	    String[] arr = new String[6];
	    if(matcher.find() == true) {
			for (int x = 0; x < 6; x++) {
				arr[x] = matcher.group(x + 1);
			}
		} else
	    	throw new MyException(
					new IllegalAccessException(
							"Вы пытаетесь ввести число которое больше или меньше. Можете ввести число от 1 до 10"));
	    matcher.start();
	    return arr;
	}

	public static int romToAr(String roman) {
		switch (roman) {
			case ("I") :
				return 1;
			case ("II") :
				return 2;
			case ("III") :
				return 3;
			case ("IV") :
				return 4;
			case ("V") :
				return 5;
			case ("VI") :
				return 6;
			case("VII") :
				return 7;
			case("VIII") :
				return 8;
			case("IX") :
				return 9;
			case("X") :
				return 10;
	}
		return -1;
	}

	public static String arabicToRoman(int number) {
	    List<RomanEnum> romanNumerals = RomanEnum.findAllReverseSortedValues();

	    int i = 0;
	    StringBuilder sb = new StringBuilder();

	    while ((number > 0) && (i < romanNumerals.size())) {
			RomanEnum currentSymbol = romanNumerals.get(i);
	        if (currentSymbol.getValue() <= number) {
	            sb.append(currentSymbol.name());
	            number -= currentSymbol.getValue();
	        } else {
	            i++;
	        }
	    }
	    return sb.toString();
	}
}
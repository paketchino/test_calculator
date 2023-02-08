package calculator;

import calculator.enumValue.Operation;
import calculator.enumValue.Roman;
import calculator.exception.MyException;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws MyException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите два числа арабские или римские: ");
		String number = scanner.nextLine();
		System.out.println(calc(number));
	}

	public static String calc(String input) throws MyException {
		String result = null;
		int val1 = 0; int val2 = 0;
		int rom1 = 0; int rom2 = 0; int exs = 0;
		String[] array = input.split(" ");
		if (array.length <= 1) {
			throw new MyException(new IllegalStateException("строка не является математической операцией"));
		} else if (array.length > 3) {
			throw new MyException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
		}
		if (array[0].contains("I") || array[0].contains("V") || array[0].contains("X")
				&& array[2].contains("I") || array[2].contains("V") || array[2].contains("X")) {
			rom1 = romanToArabic(array[0]); rom2 = romanToArabic(array[2]);
			if (rom2 < 0 || rom1 < 0) throw new MyException("используются одновременно разные системы счисления");
			if (array[1].contains("-")) {
				exs = Operation.SUBTRACT.action(rom1, rom2);
				if (exs < 0) {
					throw new MyException(("в римской системе нет отрицательных чисел"));
				}
				return arabicToRoman(exs);
			} else if (array[1].contains("*")) {
				exs = Operation.MULTI.action(rom1, rom2);
				return arabicToRoman(exs);
			} else if (array[1].contains("/")) {
				exs = Operation.DIVIDE.action(rom1, rom2);
				return arabicToRoman(exs);
			} else if (array[1].contains("+")) {
				exs = Operation.ADDING.action(rom1, rom2);
				return arabicToRoman(exs);
			}
		}
		if (array[2].contains("I")
				|| array[2].contains("X")
				|| array[2].contains("V")) { throw new MyException("используются одновременно разные системы счисления");
		}
		val1 = Integer.parseInt(array[0]);
		val2 = Integer.parseInt(array[2]);
		if (val1 >= 11  || val2 >= 11) {
			throw new MyException("Вы можете ввести только значение от 1 до 10");
		}
		if (array[1].contains("+")) result = String.valueOf(Operation.ADDING.action(val1, val2));
		else if (array[1].contains("*")) result = String.valueOf(Operation.MULTI.action(val1, val2));
		else if (array[1].contains("/")) result = String.valueOf(Operation.DIVIDE.action(val1, val2));
		else if (array[1].contains("-")) result = String.valueOf(Operation.SUBTRACT.action(val1, val2));
		else throw new MyException(("Вы ввели неправильный символ"));
		return result;
	}

	public static String arabicToRoman(int number) {
		List<Roman> romanNumerals = Roman.sorted();
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while ((number > 0) && (i < romanNumerals.size())) {
			Roman currentSymbol = romanNumerals.get(i);
			if (currentSymbol.getVal() <= number) {
				sb.append(currentSymbol.name());
				number -= currentSymbol.getVal();
			} else {
				i++;
			}
		}
		return sb.toString();
	}

	public static int romanToArabic(String roman) {
		switch (roman) {
			case "I" :
				return 1;
			case "II" :
				return 2;
			case "III" :
				return 3;
			case "IV" :
				return 4;
			case "V" :
				return 5;
			case "VI" :
				return 6;
			case "VII" :
				return 7;
			case "VIII" :
				return 8;
			case "IX" :
				return 9;
			case "X" :
				return 10;
		}
		return -1;
	}

}
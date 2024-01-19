package com.msb.ibs.common.utils;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class AmountEN {
	final static String[] majorNames = new String[] { "", " thousand", " million", " billion" };
	final static String[] tensNames = new String[] { "", " ten", " twenty", " thirty", " fourty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };
	final static String[] numNames = new String[] { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	public static String convertLessThanOneThousand(int number) {
		String soFar;
		if (number % 100 < 20) {
			soFar = numNames[number % 100];
			number /= 100;
		} else {
			soFar = numNames[number % 10];
			number /= 10;
			soFar = tensNames[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0)
			return soFar;
		return numNames[number] + " hundred" + soFar;
	}

	public static String convert(long number) {
		/* special case */
		if (number == 0)
			return "zero";
		String prefix = "";
		if (number < 0) {
			number = -number;
			prefix = "negative";
		}
		String soFar1 = "";
		String soFar2 = "";
		int number1 = (int) (number / 1000000000);
		int number2 = (int) (number % 1000000000);

		// lan 1
		if (number1 > 0) {
			int place = 0;
			do {
				int n = (int) (number1 % 1000);
				if (n != 0) {
					String s = convertLessThanOneThousand(n);
					soFar1 = s + majorNames[place] + soFar1;
				}
				place++;
				number1 /= 1000;
			} while (number1 > 0);
			soFar1 = soFar1 + " billion";

		}
		// lan 2
		int place = 0;
		do {
			int n = (int) (number2 % 1000);
			if (n != 0) {
				String s = convertLessThanOneThousand(n);
				soFar2 = s + majorNames[place] + soFar2;
			}
			place++;
			number2 /= 1000;
		} while (number2 > 0);
		return (prefix + soFar1 + soFar2).trim();
	}

}

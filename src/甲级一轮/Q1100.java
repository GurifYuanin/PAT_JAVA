package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(buf.readLine());
		String[] arr = new String[number];
		Pattern pattern = Pattern.compile("\\d");
		for (int i = 0; i < number; i++) {
			arr[i] = buf.readLine();
			Matcher matcher = pattern.matcher(arr[i]);
			if (matcher.find()) {
				// earth to mars
				System.out.println(toMars(Integer.parseInt(arr[i])));
			} else {
				// mars to earth
				System.out.println(toEarth(arr[i]));
			}
		}
		buf.close();
	}
	static String toMars(int number) {
		String result = "";
		int j = number % 13;
		switch (j) {
		case 0: result = "tret" + result; break;
		case 1: result = "jan" + result; break;
		case 2: result = "feb" + result; break;
		case 3: result = "mar" + result; break;
		case 4: result = "apr" + result; break;
		case 5: result = "may" + result; break;
		case 6: result = "jun" + result; break;
		case 7: result = "jul" + result; break;
		case 8: result = "aug" + result; break;
		case 9: result = "sep" + result; break;
		case 10: result = "oct" + result; break;
		case 11: result = "nov" + result; break;
		case 12: result = "dec" + result; break;
		}
		number = number / 13;
		result = " " +result;
		j = number % 13;
		switch (j) {
		case 0: result = "tret" + result; break;
		case 1: result = "tam" + result; break;
		case 2: result = "hel" + result; break;
		case 3: result = "maa" + result; break;
		case 4: result = "huh" + result; break;
		case 5: result = "tou" + result; break;
		case 6: result = "kes" + result; break;
		case 7: result = "hei" + result; break;
		case 8: result = "elo" + result; break;
		case 9: result = "syy" + result; break;
		case 10: result = "lok" + result; break;
		case 11: result = "mer" + result; break;
		case 12: result = "jou" + result; break;
		}
		String[] arr = result.split(" ");
		if (arr[0].equals("tret")) {
			result = result.substring(5, result.length());
		} else {
			if (arr[1].equals("tret")) {
				result = result.substring(0, result.length() - 5);
			}
		}
		return result;
	}
	static int toEarth(String number) {
		int result = 0;
		String[] arr;
		if (number.indexOf(" ") != -1) {
			arr = number.split(" ");
		} else {
			arr = new String[1];
			arr[0] = number;
		}
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			switch (arr[i]) {
			case "tret": result += 0; break;
			case "jan": result += 1; break;
			case "feb": result += 2; break;
			case "mar": result += 3; break;
			case "apr": result += 4; break;
			case "may": result += 5; break;
			case "jun": result += 6; break;
			case "jul": result += 7; break;
			case "aug": result += 8; break;
			case "sep": result += 9; break;
			case "oct": result += 10; break;
			case "nov": result += 11; break;
			case "dec": result += 12; break;
			case "tam": result += 1 * 13; break;
			case "hel": result += 2 * 13; break;
			case "maa": result +=3 * 13; break;
			case "huh": result += 4 * 13; break;
			case "tou": result += 5 * 13; break;
			case "kes": result +=  6 * 13; break;
			case "hei": result += 7 * 13; break;
			case "elo": result += 8 * 13; break;
			case "syy": result += 9 * 13; break;
			case "lok": result +=  130; break;
			case "mer": result += 11 * 13; break;
			case "jou": result += 12 * 13; break;
			}
		}
		return result;
	}
}

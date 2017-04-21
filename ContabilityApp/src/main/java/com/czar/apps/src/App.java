package com.czar.apps.src;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		PrecisionAccount pa = new PrecisionAccount();

		Locale mx = new Locale("es", "MX");

		String subtotal = "6464656165.54656464458788";
		DecimalFormat df = new DecimalFormat();
		df.setParseBigDecimal(true);
		try {
			BigDecimal numer = (BigDecimal) df.parse(subtotal);
			System.out.println(numer);
			
			BigDecimal total = pa.getTotal(numer, new BigDecimal("16", MathContext.DECIMAL32));
			System.out.println(total);
			
			String totalString = df.format(total);
			totalString.substring(0, (totalString.length() -5));
			System.out.println(totalString);
			System.out.println(stringToBigDecimal(totalString, mx));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(stringToBigDecimal(subtotal, mx));

		// pa.getTotal(subTotal, iva, total)
	}

	private static BigDecimal stringToBigDecimal(String formattedString, Locale locale) {
		DecimalFormatSymbols symbols;
		char groupSeparatorChar;
		String groupSeparator;
		char decimalSeparatorChar;
		String decimalSeparator;
		String fixedString;
		BigDecimal number = null;

		symbols = new DecimalFormatSymbols(locale);
		groupSeparatorChar = symbols.getGroupingSeparator();
		decimalSeparatorChar = symbols.getDecimalSeparator();

		if (groupSeparatorChar == '.') {
			groupSeparator = "\\" + groupSeparatorChar;
		} else {
			groupSeparator = Character.toString(groupSeparatorChar);
		}

		if (decimalSeparatorChar == '.') {
			decimalSeparator = "\\" + decimalSeparatorChar;
		}else{
			decimalSeparator = Character.toString(decimalSeparatorChar);
		}
		
		fixedString = formattedString.replaceAll(groupSeparator, "");
		fixedString = fixedString.replaceAll(decimalSeparator, ".");
		number = new BigDecimal(fixedString);

		return number;
	}
}

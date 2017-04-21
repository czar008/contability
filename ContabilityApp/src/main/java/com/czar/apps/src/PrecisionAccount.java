package com.czar.apps.src;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class PrecisionAccount {

	final int precisionDecimal = 7;
	BigDecimal subtotal;
	BigDecimal iva;
	BigDecimal total;
	boolean conTotal;
	int precision;
	
	
	
	public PrecisionAccount() {
		super();
	}


	/**
	 * Constructor para cuentas de precisión que indica si
	 * se envía el total para restar los impuestos, y la precision o
	 * cantidad de decimales requeridos
	 * @param conTotal
	 * @param precision
	 */
	public PrecisionAccount(boolean conTotal, int precision){
		this.conTotal = conTotal;
		this.precision = precision;
	}
	
	
	public BigDecimal getTotal(BigDecimal subTotal,BigDecimal iva){
		BigDecimal result = BigDecimal.ZERO;
		iva = iva.divide(BigDecimal.valueOf(100),MathContext.DECIMAL128);
		result = subTotal.multiply(iva, MathContext.DECIMAL128).setScale(7,RoundingMode.CEILING);	
		result.setScale(5,RoundingMode.CEILING);
		return result;
	}
	
	public BigDecimal getTotal(BigDecimal subtotal, List<Impuesto> impuestosAplicables){
		
		return null;
	}
	
}

package generator;

import java.math.BigInteger;

public class Calculator {
public static BigInteger sumar(BigInteger a, BigInteger b) {
		
		BigInteger result = a.add(b);
		return result;
	}
	
	public static BigInteger restar(BigInteger a, BigInteger b) {
		
		BigInteger result = a.subtract(b);
		return result;
	}
	
	public static BigInteger multiplicar(BigInteger a, BigInteger b) {
		
		BigInteger result = a.multiply(b);
		return result;
	}
	
	public static BigInteger dividir(BigInteger a, BigInteger b) {
		
		BigInteger result = a.divide(b);
		return result;
	}
	
	public static BigInteger resto(BigInteger a, BigInteger b) {
		
		BigInteger result = a.mod(b);
		return result;
	}
	

	public static boolean esPrimo(BigInteger a) {
	    //Verificar si es probablemente primo, si retorna falso sabemos que no lo es.
	    if (!a.isProbablePrime(5))
		return false;

	    //Chequeamos si es par, si lo es, no es primo
	    BigInteger two = new BigInteger("2");
	    if (!two.equals(a) && BigInteger.ZERO.equals(a.mod(two)))
		return false;

	    //Se testean los numeros impares, buscando divisores HASTA la raiz cuadrada del numero.
	    //Si no se encuentra uno sera primo 
	    for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(a) < 1; i = i.add(two)) { //For loop desde i=3, mientras el cuadrado de i sea menor o igual al numero, aumentando de a 2
		if (BigInteger.ZERO.equals(a.mod(i))) //Si i es divisor del numero, no es primo
		    return false;
	    }
	    return true;
	}
}

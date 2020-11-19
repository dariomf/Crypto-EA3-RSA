package generator;

import java.math.BigInteger;
import java.util.Random;

public class Generator {
	
	// Generador de primos a partir de cantidad de bits
	public BigInteger getRandom(int len) {
		BigInteger number;
		do {
			number = BigInteger.probablePrime(len, new Random());
		} while (!this.isPrime(number));
		
		return number;
	}
	
	public BigInteger genE(BigInteger phi) {
		
		BigInteger number, minVal;
		minVal = Calculator.dividir(phi, BigInteger.TWO);
		int len = phi.bitLength();
		int max = len, min = len/2;
		int range = max - min + 1;
		
		do {
			number = this.getRandom((int) (Math.random() * range) + min);
		} while ((phi.gcd(number).compareTo(BigInteger.ONE) != 0) || phi.compareTo(number) == -1 || minVal.compareTo(number) == 1);
				
		return number;
	}
	
	private BigInteger[] extendedEuclides(BigInteger a, BigInteger b) {
				
		BigInteger[] resp = new BigInteger[3];
		BigInteger x = BigInteger.ZERO, y = BigInteger.ZERO;
		 
		if(b.compareTo(BigInteger.ZERO) == 0) {
			resp[0] = a; resp[1] = BigInteger.ONE; resp[2] = BigInteger.ZERO;
			System.out.println("-----------Entro aca ----------");
		} else {
			
			BigInteger x2 = BigInteger.ONE, x1 = BigInteger.ZERO, y2 = BigInteger.ZERO, y1 = BigInteger.ONE;
			BigInteger q = BigInteger.ZERO, r = BigInteger.ZERO;
			
			while(b.compareTo(BigInteger.ZERO) > 0) {
				q = Calculator.dividir(a, b);
				r = Calculator.restar(a, Calculator.multiplicar(q, b));
				x = Calculator.restar(x2, Calculator.multiplicar(q, x1));
				y = Calculator.restar(y2, Calculator.multiplicar(q, y1));
				a = b;
				b = r;
				x2 = x1;
				x1 = x;
				y2 = y1;
				y1 = y;
			}
			resp[0] = a;
			resp[1] = x2;
			resp[2] = y2;
		}
		
		return resp;   
	}
	
	public BigInteger genD(BigInteger e, BigInteger phi) {
		
		BigInteger mcd[] = new BigInteger[3];
        BigInteger y = BigInteger.ZERO;
        
        if (e.compareTo(phi) == 1) {
            mcd = this.extendedEuclides(e, phi);
        } else {
            mcd = this.extendedEuclides(phi, e);
        }
        
        if( mcd[0].compareTo(BigInteger.ONE) != 0)
        {
            //System.out.println("EL INVERSO NO EXISTE");
            return BigInteger.ZERO;
        } else {
            
        	y = mcd[2];
            if( y.compareTo(BigInteger.ZERO) == -1) {
                y = Calculator.sumar(y, phi);
            }
        }
        
        return y;
	}
	
	private boolean isPrime(BigInteger number) {
	    //Verificar si es probablemente primo, si retorna falso sabemos que no lo es.
	    if (!number.isProbablePrime(5))
	    	return false;

	    //Chequeamos si es par, si lo es, no es primo
	    BigInteger two = new BigInteger("2");
	    if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
	    	return false;

	    /*
	    //Se testean los numeros impares, buscando divisores HASTA la raiz cuadrada del numero.
	    //Si no se encuentra uno sera primo 
	    for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { //For loop desde i=3, mientras el cuadrado de i sea menor o igual al numero, aumentando de a 2
	    	if (BigInteger.ZERO.equals(number.mod(i))) //Si i es divisor del numero, no es primo
	    		return false;
	    }*/
	    return true;
	}
}

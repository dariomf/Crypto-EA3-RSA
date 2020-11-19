package generator;

import java.math.BigInteger;

public class RSA {

	private int bitLen;
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger phi;
	private BigInteger e;
	private BigInteger d;
	
	public RSA(int len) {
		this.bitLen = len;
	}
	
	public void generateKeys() {
		
		Generator gen = new Generator();
		
		this.p = gen.getRandom(this.bitLen);
		this.q = gen.getRandom(this.bitLen);		
		this.n = Calculator.multiplicar(this.p, this.q);
		
		this.phiEuler();
		do {
			this.e = gen.genE(this.phi);
			this.d = gen.genD(this.e, this.phi);
		} while (this.d.compareTo(BigInteger.ZERO) == 0);	
		
		//System.out.println(Calculator.resto(Calculator.multiplicar(this.d, this.e), this.phi));
	}
	
	private void phiEuler() {
		this.phi = Calculator.multiplicar(Calculator.restar(this.p, BigInteger.ONE), Calculator.restar(this.q, BigInteger.ONE));
	}
	
	public String encrypt(String msj) {
	
		int i;
		BigInteger c;
		String encryptedMsj = "";
		
		for	(i = 0; i < msj.length(); i++) {
			c = BigInteger.valueOf((int) msj.charAt(i)); 
			c = c.modPow(this.e, this.n);
			encryptedMsj = encryptedMsj.concat(c.toString());
			encryptedMsj = encryptedMsj.concat("\n");
		}
		
		return encryptedMsj;
	}	
	
	public String decrypt(String msj) {
		
		String [] encryptedMsj = msj.split("\n");
		String originalMsj = "";
		int i;
		BigInteger m, c;
		
		for (i = 0; i < encryptedMsj.length; i++) {
			c = new BigInteger(encryptedMsj[i]);
			m = c.modPow(this.d, this.n);
			originalMsj = originalMsj.concat( String.valueOf((char) m.intValue()));
			//System.out.print((char) m.intValue());
		}
		
		return originalMsj;
	}
}

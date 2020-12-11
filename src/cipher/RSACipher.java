package cipher;

import java.math.BigInteger;

public class RSACipher {

	private int bitLen;
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger phi;
	private BigInteger e;
	private BigInteger d;
	private Generator gen;
	
	public RSACipher(int len) {
		this.bitLen = len;
		 gen = new Generator();
		this.p = gen.getRandom(this.bitLen);
		this.q = gen.getRandom(this.bitLen);		
		this.n = Calculator.multiplicar(this.p, this.q);
		
	}
	
	public void generateKeys() {
		this.phiEuler();
		do {
			this.e = gen.genE(this.phi);
			this.d = gen.genD(this.e, this.phi);
		} while (this.d.compareTo(BigInteger.ZERO) == 0);
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
			originalMsj = originalMsj.concat(String.valueOf((char) m.intValue()));
		}
		
		return originalMsj;
	}

	public int getBitLen() {
		return bitLen;
	}

	public void setBitLen(int bitLen) {
		this.bitLen = bitLen;
	}

	public BigInteger getP() {
		return p;
	}

	public void setP(BigInteger p) {
		this.p = p;
	}

	public BigInteger getQ() {
		return q;
	}

	public void setQ(BigInteger q) {
		this.q = q;
	}

	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}

	public BigInteger getPhi() {
		return phi;
	}

	public void setPhi(BigInteger phi) {
		this.phi = phi;
	}

	public BigInteger getE() {
		return e;
	}

	public void setE(BigInteger e) {
		this.e = e;
	}

	public BigInteger getD() {
		return d;
	}

	public void setD(BigInteger d) {
		this.d = d;
	}
	
	

	
}

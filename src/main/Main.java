package main;

import generator.RSA;

public class Main {

	public static void main(String[] args) {
		
		RSA rsa = new RSA(100);
		rsa.generateKeys();
		String encryptedMsj = rsa.encrypt("Hola Mundo!");
		String originalMsj = rsa.decrypt(encryptedMsj);
		
		System.out.println(encryptedMsj);
		System.out.println(originalMsj);
	}

}

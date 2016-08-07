package code;

import java.math.BigInteger;

public class Modulo implements Comparable<Modulo> {
	int value;
	int modulus;
	
	public Modulo(int value) {
		this(value, 26);
	}
	
	public Modulo(int value, int modulus) {
		if (modulus == 0) {
			throw new IllegalArgumentException("n mod 0 is undefined");
		}
		this.value=mod(value, modulus);
		this.modulus=modulus;
	}

	public int add(int operand) {
		value = mod((value + operand), modulus);
		return value;
	}
	
	public int subtract(int operand) {
		value = mod((value - operand), modulus);
		return value;
	}
	
	public int multiply(int operand) {
		value = mod((value * operand), modulus);
		return value;
	}
	
	public int divide(int operand) {
		BigInteger operandDec = new BigInteger(String.valueOf(operand));
		BigInteger modulusDec = new BigInteger(String.valueOf(modulus));
		try {
			BigInteger operandInverse = operandDec.modInverse(modulusDec);
			int valueMod = mod(value, modulus);
			value = mod((valueMod * operandInverse.intValue()), modulus);
		}catch(ArithmeticException e) {
			System.err.println(e.getMessage());
		}
		return value;
	}
	
	public int pow(int operand) {
		value = mod((int)Math.pow(value, operand), modulus);
		return value;
	}
	
	int mod(int one, int two) {
		int r = one % two;
		return (r < 0) ? r += two : r;
	}
	
	@Override
	public String toString() {
		return "value: " + value + " mod: " + this.modulus;
	}
	
	@Override
	public boolean equals(Object a) {
		Modulo b = (Modulo) a;
		return b.value == value;
	}
	
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 89 * hash + value;
		return hash;
	}
	
	@Override
	public int compareTo(Modulo o) {
		return value - o.value;
	}
}

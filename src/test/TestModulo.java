package test;

import code.Modulo;

import java.util.Arrays;
import junit.framework.TestCase;
import org.junit.Test;

public class TestModulo extends TestCase {
	int max = Integer.MAX_VALUE;

	@Test
	public void testModuloEquality() {
		Modulo a = new Modulo(23);
		Modulo b = new Modulo(23);
		Modulo c = new Modulo(179);
		assertEquals(a, b);
		assertEquals(a, c);
	}

	@Test
	public void testAddZero() {
		Modulo a = new Modulo(23);
		assertEquals(23, a.add(0));
	}

	@Test
	public void testPositiveSum() {
		Modulo a = new Modulo(15);
		assertEquals(8, a.add(19));
	}
	

	@Test
	public void testNegativeSum() {
		Modulo a = new Modulo(15);
		assertEquals(22, a.add(-19));
	}

	@Test
	public void testPositiveDifference() {
		Modulo a = new Modulo(50);
		assertEquals(1, a.subtract(23));
	}

	@Test
	public void testNegativeDifference() {
		Modulo a = new Modulo(15);
		assertEquals(22, a.subtract(19));
	}

	@Test
	public void testPositiveProduct() {
		Modulo a = new Modulo(15);
		assertEquals(9, a.multiply(11));
	}

	@Test
	public void testNegativeProduct() {
		Modulo a = new Modulo(15);
		assertEquals(7, a.multiply(-3));
	}
	
	@Test
	public void testQuotient() {
		Modulo a = new Modulo(5, 7);
		assertEquals(3, a.divide(4));
		Modulo b = new Modulo(3, 7);
		assertEquals(1, b.divide(3));
		Modulo c = new Modulo(3, 15);
		try {
			c.divide(12);
		} catch (Exception e) {
			assertEquals("BigInteger not invertible.", e.getMessage());
		}
	}
	
	@Test
	public void testPositivePow() {
		Modulo a = new Modulo(2, 10);
		assertEquals(6, a.pow(4));
	}
	
	@Test
	public void testNegativePow() {
		Modulo a = new Modulo(2, 10);
		assertEquals(0, a.pow(-4));
	}
	
	@Test
	public void testNonDefaultModulus() {
		Modulo a = new Modulo(15, 11);
		assertEquals(2, a.add(9));
		a = new Modulo(15, 11);
		assertEquals(6, a.subtract(9));
		a = new Modulo(15, 11);
		assertEquals(3, a.multiply(9));
	}

	@Test
	public void testSort() {
		Modulo[] act = new Modulo[]{new Modulo(15), new Modulo(29), new Modulo(-6), new Modulo(57)};
		Modulo[] exp = new Modulo[]{new Modulo(3), new Modulo(5), new Modulo(15), new Modulo(20)};
		Arrays.sort(act);
		assertTrue(Arrays.equals(exp, act));
	}
	
	@Test
	public void testIntegerOverflow() {
		Modulo a = new Modulo(1, 8);
		assertEquals(0, a.add(max));
		Modulo b = new Modulo(1, 8);
		assertEquals(1, b.subtract(Integer.MIN_VALUE));
		Modulo c = new Modulo(2, 8);
		assertEquals(6, c.multiply(max));
	}
	
	@Test
	public void testIntegerUnderflow() {
		Modulo a = new Modulo(0, 26);
		assertEquals(2, a.subtract(max + 1));
	}
}

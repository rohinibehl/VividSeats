Vivid Seats Coding Assessment
=============================
###Ruby Quiz 179: Modular Arithmetic

http://rubyquiz.strd6.com/quizzes/179-modular-arithmetic

Modulo behaves similarly to Integer class and supports addition, subtraction, multiplication, division, and exponentiation. As operator overloading is not supported in Java as it is in Ruby, please use the following as a guide for invoking these methods.

**Examples:**

The first argument to Modulo constructor is the value, while the second is the modulus. 26 is the default value of the modulus. 

- *Addition:*

		//equivalent to (20 + 9) mod 26
		Modulo a = new Modulo(20);
		a.add(9);

- *Subtraction*

		//equivalent to (10 - 6) mod 26
		Modulo b = new Modulo(10);
		b.subtract(6);
		

- *Multiplication*

		//equivalent to (15*3) mod 26
		Modulo c = new Modulo(15);
		c.multiply(3);
	
- *Division*

		//equivalent to (5/4) mod 7
		Modulo d = new Modulo(5, 7);
		d.divide(4);
	
	
	
		
		


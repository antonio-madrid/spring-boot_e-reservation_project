package com.platzi.ereservation.alternative;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import com.platzi.ereservation.alternative.Calculator;

class CalculatorTest {

	@Test
	void testSum() {
		Calculator calculator = new Calculator();
		assertThat(calculator.sum(5, 5), equalTo(10));
	}

}

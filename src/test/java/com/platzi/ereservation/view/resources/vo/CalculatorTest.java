package com.platzi.ereservation.view.resources.vo;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import com.platzi.ereservation.util.Calculator;

class CalculatorTest {

	@Test
	void testSum() {
		Calculator calculator = new Calculator();
		assertThat(calculator.sum(5, 5), equalTo(10));
	}

}

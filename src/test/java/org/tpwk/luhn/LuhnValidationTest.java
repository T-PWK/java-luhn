package org.tpwk.luhn;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class LuhnValidationTest
{
	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers()
	{
		return Arrays.asList(new Object[][] {
				{ "79927398710", false },
				{ "79927398712", false },
				{ "79927398713", true },
				{ "79927398714", false },
				{ "2772502047190676862", true },
				{ "49927398716", true },
				{ "49927398717", false },
				{ "1234567812345678", false },
				{ "1234567812345670", true },
		});
	}

	@Parameter
	public String number;

	@Parameter(1)
	public boolean isValid;

	@Test
	public void validation()
	{
		assertEquals(isValid, Luhn.isValid(number));
	}
}

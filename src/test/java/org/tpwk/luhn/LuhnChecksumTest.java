package org.tpwk.luhn;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class LuhnChecksumTest
{

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers()
	{
		return Arrays.asList(new Object[][] {
				{ "7992739871", '3' },
				{ "277250204719067686", '2' },
				{ "123456781234567", '0' },
		});
	}

	@Parameter
	public String number;

	@Parameter(1)
	public char validChecksum;

	@Test
	public void validation()
	{
		assertEquals(validChecksum, Luhn.checksum(number));
	}
}

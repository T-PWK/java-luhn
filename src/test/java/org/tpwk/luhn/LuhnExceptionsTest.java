package org.tpwk.luhn;

import org.junit.Test;

public class LuhnExceptionsTest
{
	@Test(expected = NullPointerException.class)
	public void testValidationNPE()
	{
		Luhn.isValid(null);
	}

	@Test(expected = NullPointerException.class)
	public void testChecksumNPE()
	{
		Luhn.checksum(null);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidationIndex()
	{
		Luhn.isValid("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testChecksumIndex()
	{
		Luhn.checksum("");
	}
}

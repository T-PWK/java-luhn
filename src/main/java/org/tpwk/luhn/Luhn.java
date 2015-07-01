package org.tpwk.luhn;

public class Luhn
{
	/**
	 * Checks if the given number contains correct checksum digit at the last position
	 *
	 * @param number number to be verified
	 * @return {@code true} if the last digit is a correct checksum digit; otherwise {@code false}
	 * @throws NullPointerException if the given number is {@code null}
	 * @throws IndexOutOfBoundsException if the given number is
	 */
	public static boolean isValid(final String number)
	{
		final int lastCharIndex = number.length() - 1;
		return calculateChecksum(number.substring(0, lastCharIndex)) == number.charAt(lastCharIndex);
	}

	public static char checksum(final String number)
	{
		if (number.length() < 1)
		{
			throw new IllegalArgumentException("Empty string is not allowed");
		}

		return calculateChecksum(number);
	}

	private static char calculateChecksum(final String number)
	{
		final char[] digits = number.toCharArray();
		int sum = 0;

		reverse(digits);

		for (int i = 0; i < digits.length; i++)
		{
			digits[i] = (char) (digits[i] - '0'); // convert characters to its numerical values

			if ((i & 0x01) == 0)
			{
				digits[i] <<= 1; // double the value of every second digit
				digits[i] -= (digits[i] > 9) ? 9 : 0; // sum the digits of the numbers e.g. 11->2, 14->5 etc.
			}
			sum += digits[i];
		}

		return (char) ((10 - sum % 10) % 10 + '0'); // 10 - last digit and convert number to a digit character
	}

	private static void reverse(final char[] array)
	{
		int hi = array.length - 1, lo = 0;

		while (hi > lo)
		{
			array[lo] = (char) (array[lo] ^ array[hi]);
			array[hi] = (char) (array[lo] ^ array[hi]);
			array[lo] = (char) (array[lo] ^ array[hi]);
			hi--;
			lo++;
		}
	}
}

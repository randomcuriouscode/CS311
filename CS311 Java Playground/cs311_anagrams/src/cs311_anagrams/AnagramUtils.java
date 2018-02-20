package cs311_anagrams;

import java.util.Arrays;

public final class AnagramUtils {
	
	/***
	 * Uses counting sort to sort in ascending order any possible ascii string
	 * 
	 * Note: java characters are 2 bytes and can represent utf-16 characters.
	 * It is assumed that only ascii characters will be in the string.
	 * 
	 * @param str
	 * @return
	 */
	public static final String sortString(String str) {
		char[] str_array= str.toCharArray(); //convert string to character array

		char[] retArr = new char[str_array.length]; //create return array with sorted character values

		int[] ctArr = new int[256];
		Arrays.fill(ctArr, 0); //create and fill count array
		
		for (int i = 0; i < str_array.length; i++)
			ctArr[str_array[i]] ++; //increment count of each character

		for (int i = 1; i < 256; i++)
			ctArr[i] += ctArr[i - 1]; //sum counts so each ctArr[i] represents the index location for each character for i=str_array[j]
		
		for (int i = 0; i < str_array.length; i++) {
			retArr[ctArr[str_array[i]] - 1] = str_array[i]; //populate output array with proper character at index given by ctArr
			ctArr[str_array[i]] --; //decrement count/index for character at i
		}
		
		return new String(retArr); //construct new string representing sorted string
	}
}

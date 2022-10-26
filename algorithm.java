package Day_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class algorithm {
	public static void main (String args[]) {
		
		// Square Root O(n)
		
		System.out.println(squareRoot(0.25));
		
		// Roman Number O(n)
		int romanNumber = RomanNumberToInt("III");
		System.out.println(romanNumber);
		System.out.println(isRomanNumber(romanNumber));
		
		// Longest Same String O(n*n) 
		String[] strs = {"flower", "flow", "flight"};
		System.out.println(longestSameString(strs));
		
		//Sort O(n)
		int[] nums = { 0, 2, 1, 2, 0, 1, 1 };
		int[] sortedArray = sortArray(nums);
		System.out.println(Arrays.toString(sortedArray));
		System.out.println(isSorted(sortedArray));
		
	}

	public static double squareRoot(double number) {
		double t;	
		double sr = number / 2;
		
		do {
			t = sr;
			sr = (t + (number / t)) / 2;
		} while (t != sr);
		
		return (double) Math.round(sr * 100) / 100;
	}
	
	private static int RomanNumberToInt(String romanInput) {
		int total = 0;
		for (int i = 0; i < romanInput.length(); i++) {
			if (romanInput.charAt(i) == 'I') {
				if (i + 1 < romanInput.length()) {
					if (romanInput.charAt(i + 1) == 'V' || romanInput.charAt(i + 1) == 'X') {
						total = total - 1;
					} else {
						total = total + 1;
					}
				} else {
					total = total + 1;
				}
				
			} else if (romanInput.charAt(i) == 'V') {
				total += 5;
				
			} else if (romanInput.charAt(i) == 'X') {
				if (i + 1 < romanInput.length()) {
					if (romanInput.charAt(i + 1) == 'L' || romanInput.charAt(i + 1) == 'C') {
						total = total - 10;
					} else {
						total = total + 10;
					}
				} else {
					total = total + 10;
				}
				
			} else if (romanInput.charAt(i) == 'L') {
				total += 50;
				
			} else if (romanInput.charAt(i) == 'C') {
				if (i + 1 < romanInput.length()) {
					if (romanInput.charAt(i + 1) == 'D' || romanInput.charAt(i + 1) == 'M') {
						total = total - 100;
					} else {
						total = total + 100;
					}
				} else {
					total = total + 100;
				}
				
			} else if (romanInput.charAt(i) == 'D' || romanInput.charAt(i) == 'd') {
				total += 500;
				
			} else if (romanInput.charAt(i) == 'M' || romanInput.charAt(i) == 'm') {
				total += 1000;
				
			} else {
				return 0;
			}

			//System.out.println(total);
		}
		return total;
	}
	
	private static boolean isRomanNumber(int romanNumberOutput) {
		if (romanNumberOutput == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	private static String longestSameString(String[] inputStringArray) {
		String commonString = "";
		char tempChar = inputStringArray[0].charAt(0);
		int counter = 0;
		
		while (counter < inputStringArray[0].length()) {
			tempChar = inputStringArray[0].charAt(counter);
			
			for (int i = 1; i < inputStringArray.length; i++) {
				if (inputStringArray[i].charAt(counter) != tempChar) {
					return commonString;
				}
			}
			
			commonString = commonString + tempChar;
			counter++;
		}
			

		return commonString;
	}
	
	private static int[] sortArray(int[] numbers) {
		int[] count = new int[3];
		List<Integer> tempList = new ArrayList<Integer>();
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		
		for (int num : numbers) {
			if (num == 0) count0++;
			else if(num == 1) count1++;
			else count2++;
		}
			
		for (int i = 0; i < count0; i++) {
			tempList.add(0);
		}

		for (int i = 0; i < count1; i++) {
			tempList.add(1);
		}

		for (int i = 0; i < count2; i++) {
			tempList.add(2);
		}

//		System.out.println(count0);
//		System.out.println(count1);
//		System.out.println(count2);
//		System.out.println(tempList);

		int[] sortedArray = new int[tempList.size()];

		for (int i = 0; i < tempList.size(); i++) {
			sortedArray[i] = tempList.get(i);
		}

		return sortedArray;
	}

	private static boolean isSorted(int[] sortedArray) {
		for (int i = 0; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] > sortedArray[i + 1]) {
				return false;
			} 
		}
		
		return true;
	}
	
	
}

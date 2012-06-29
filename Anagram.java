import java.util.*;

public class Anagram
{
	// Delete one array element
	public static int[] deleteArrayElement(int[] oldArray, int element)
	{
		int newSize = oldArray.length - 1;
		int[] newArray = new int[newSize];
		System.arraycopy(oldArray, 0, newArray, 0, element);
		System.arraycopy(oldArray, element + 1, newArray, element, newSize - element);
		return newArray;
	}

	// Generate sorted array of code points without duplicated values
	public static int[] codePointArray(String inputString)
	{
		String inputStringNoSpaces = inputString.toLowerCase().replaceAll(" ","");

		int maxCodePointCount = inputStringNoSpaces.codePointCount(0, inputStringNoSpaces.length());

		int[] inputStringCodePoints = new int[maxCodePointCount];

		int codePoint = 0;
		int index = 0;
		while (index < maxCodePointCount)
		{
			codePoint = inputStringNoSpaces.codePointAt(index);
			inputStringCodePoints[index] = codePoint;
			if (Character.isSupplementaryCodePoint(codePoint)) index += 2;
			else index++;
		}
		Arrays.sort(inputStringCodePoints);

		// Remove duplicates in array of code points and decrease its size
		index = 0;
		while (index < inputStringCodePoints.length - 1)
		{
			while (inputStringCodePoints[index] == inputStringCodePoints[index + 1])
			{
				inputStringCodePoints = Anagram.deleteArrayElement(inputStringCodePoints,index + 1);
				if ((inputStringCodePoints.length < 2) || (index == inputStringCodePoints.length - 1))
				{
					break;
				}
			}
			index++;
		}
		return inputStringCodePoints;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter first string: ");
		String firstString = in.nextLine();
		System.out.print("Please enter second string: ");
		String secondString = in.nextLine();

		int[] firstStringCodePoints = codePointArray(firstString);
		int[] secondStringCodePoints = codePointArray(secondString);

		if ( Arrays.toString(firstStringCodePoints).equals(Arrays.toString(secondStringCodePoints)) )
		{
			System.out.println("Two strings are anagram");
		}
		else
		{
			System.out.println("Two strings are not anagram");
		}
	}
}

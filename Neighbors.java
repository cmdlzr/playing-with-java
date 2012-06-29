import java.util.*;

public class Neighbors
{
	public static void main(String[] args)
	{

		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the size of the array: ");
		int sizeOfArray = in.nextInt();

		int[] neighbouringNumbers = new int[sizeOfArray];

		for (int index = 0; index < sizeOfArray; index++)
		{
			System.out.print("Please enter an element of the array:");
			neighbouringNumbers[index] = in.nextInt();
		}

		int Distance = Math.abs(neighbouringNumbers[1] - neighbouringNumbers[0]);
		int newDistance = 0;
		int firstNumber = 0;
		for (int index = 1; index < sizeOfArray - 1; index++)
		{
			newDistance = Math.abs(neighbouringNumbers[index+1] - neighbouringNumbers[index]);
			if ( Distance > newDistance )
			{
                Distance = newDistance;
                firstNumber = index;
			}
		}

		System.out.println("First number has index: " + firstNumber);
	}
}

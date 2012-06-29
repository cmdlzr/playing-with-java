import java.util.*;

public class PrimeNumbers
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter an integer: ");
		int upperLimit = in.nextInt();

		for (int anInteger = 2; anInteger <= upperLimit; anInteger++)
		{
			boolean PrimeNumber = true;
			for (int divider = 2; divider < anInteger; divider++)
			{
				if ( anInteger%divider == 0 )
				{
					PrimeNumber = false;
					break;
				}
			}

			if (PrimeNumber)
			{
				System.out.print( anInteger + " " );
			}
		}
		System.out.print("\n");
	}
}

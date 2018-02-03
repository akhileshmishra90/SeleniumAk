package milselenious;
public class Prime {
	public static void main(String arg[])
	{
		for (int counter = 0; counter <= 100; counter++) {

		    boolean notPrime = false;
		    for (int i = 2; i <= counter; i++) {
		        if (counter%i==0 && i!=counter) {
		            notPrime = true;
		        }
		    }
		    if (notPrime == false) {
		                System.out.println(counter);
		    }
		}
	}
}

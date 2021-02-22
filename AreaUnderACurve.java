import java.util.Scanner;

public class AreaUnderACurve {

	
	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.
		PriorityQueue pq = new PriorityQueue(50);
		
	    int numRects = 1;
		double area = 0;
		double last_area = 0;
		double final_area = -1;
		
		
		
		
		while (  (int)((((final_area-last_area)) )/error) != 0 /*numRects < 3*/) {
			last_area = area;
		area = 0;
		double temp_a = b - ((b-a)/numRects);
		double temp_b = b;
		
		
		Interval temp;
		
		
		for (int i = 1; i <= numRects; i++) {
			temp = new Interval(temp_a,temp_b);
			area = area + (f(temp_b) * temp.getLength());
			temp_b = temp_a;
			temp_a = b - ( (i+1)*((b-a)/numRects));	
		}
		
		final_area = area;
			
		
		numRects++;
		}
		
		
		//should be 41.76 with preset values of a and b
		return final_area; 
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();
		
	
		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
		
	}
}

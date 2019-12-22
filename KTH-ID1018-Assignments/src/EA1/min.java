package EA1;

public class min {

	/**
	 * THE min METHOD
	 * 
	 * The min method returns the least element in a sequential collection. If the
	 * collection is empty an IllegalArgumentException is thrown. Find the error 
	 * that keeps the program from halting. 
	 * 
	 * Created by -----------------------------------------------------------------
	 * Tom K. Axberg - Assignment EU1 - ID1018 - KTH - 2019 November
	 */

	public static int min(int[] elements) throws IllegalArgumentException {

		if (elements.length == 0)
			throw new IllegalArgumentException("empty collection");

		int nofIters = 1;
		int[] sequence = elements;
		int nofPairs = sequence.length / 2;
		int nofUnpairedElements = sequence.length % 2;
		int nofPossibleElements = nofPairs + nofUnpairedElements;
		int[] partialSeq = new int[nofPossibleElements];
		int i = 0;
		int j = 0;

	while (nofPairs > 0) //<----- First problem
		
		{
			// Extract a partial sequence of possible elements by evaluate pairs of elements in sequence.

			i = 0;
			j = 0;
		
			while (j < nofPairs) {
				partialSeq[j++] = (sequence[i] < sequence[i + 1]) ? sequence[i] : sequence[i + 1];
				i += 2;}
			if (nofUnpairedElements == 1) {
				partialSeq[j] = sequence[i]; //<------ Second problem
			    //nofPossibleElements++;
			}
		
			// Now we update the constant and array values
			
			sequence = partialSeq;
			nofPairs = nofPossibleElements / 2;
			nofUnpairedElements = nofPossibleElements % 2;
			nofPossibleElements = nofPairs + nofUnpairedElements;
			// Trace printing 1 - to follow the sequence
			//System.out.println (java.util.Arrays.toString (sequence));
			// Trace printing 2 - to terminate the loop preemptively
			// (to be able to see what happens initially)
			// if (nofIters++ == 10)
			// System.exit(0);
		}
		// sequence[0] is the only remaining possible element // - it is the least
		// element
		return sequence[0];
	}
	
	public static int minn(int[] elements) throws IllegalArgumentException{
		
		if (elements.length == 0)
			throw new IllegalArgumentException("empty collection");
	
		for (int i = 1; elements.length > i; i++) {
			
			if(elements[i] < elements[0]) 
				elements[0] = elements[i];
			}	
		return elements[0];
	}
}

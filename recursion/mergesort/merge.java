// merge.java
// demostrates merging two arrays into a third
//////////////////////////
class MergeApp {
	public static void main(String args[]) {
		int[] arrayA = {23, 47, 81, 95};
		int[] arrayB = {7, 14, 39, 55, 62, 74};
		int[] arrayC = new int[10];

		merge(arrayA, 4, arrayB, 6, arrayC);
		display(arrayC, 10);
	}

	// merge A and B into C

	public static void merge(int[] arrayA, int sizeA, 
		                     int[] arrayB, int sizeB,
		                     int[] arrayC) {
		int aDex = 0, bDex = 0, cDex = 0;

		// neither array is empty
		while (aDex < sizeA && bDex < sizeB)
			if(arrayA[aDex] < arrayB[bDex])
				arrayC[cDex++] = arrayA[aDex++];
			else 
				arrayC[cDex++] = arrayB[bDex++];

		// arrayB is empty, but arrayA is not
		while(aDex < sizeA)
			arrayC[cDex++] = arrayA[aDex++];

		// arrayA is empty, but arrayB is not
		while(bDex < sizeB)
			arrayC[cDex++] = arrayB[bDex++];
	}

	public static void display(int[] theArray, int size) {
		for(int j = 0; j < size; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}
}
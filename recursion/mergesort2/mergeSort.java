// merge sort
////////////////////////
class Array{
	private long[] a;
	private int nElem;
	private int maxSize;

	public Array (int max) {
		maxSize = max;
		a = new long[maxSize];
		nElem = 0;
	}

	public void display () {
		System.out.print("The array is: ");
		for(int j = 0; j < nElem; j++)
			System.out.print(a[j] + " ");
		System.out.println("---END");
	}

	public boolean isEmpty() {
		return nElem == 0;
	}

	public void insert(long value) {
		a[nElem] = value;
		nElem++;
	}

	public void mergeSort() {
		long[] workSpace = new long[nElem];
		recMergeSort(workSpace, 0, nElem - 1);
		//copy workSpace --> a(the array)
		/*
		for(int k = 0; k < nElem; k++) {
			a[k++] = workSpace[k++];
		}
*/
	}

	public void recMergeSort(long[] workSpace, int left, int right) {
		//int mid = right / 2;
		int mid = (left + right) / 2;
		if (left == right)
			return;
		else {
			recMergeSort(workSpace, left,mid);
			//System.out.print("Left: ");
			//display();
			recMergeSort(workSpace, mid + 1, right);
			//System.out.print("Right: ");
			//display();
			merge(workSpace, left, mid + 1, right);
		}
		//System.out.print("Sorting: ");
		//display();
	}
/*
	public void merge (long[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;

		while(lowPtr <= mid && highPtr <= upperBound)
			if ( a[lowPtr] < a[highPtr])
				workSpace[j++] = a[lowPtr++];
			else
				workSpace[j++] = a[highPtr++];

		while (lowPtr <= mid)
			workSpace[j++] = a[lowPtr++];

		while (highPtr <= upperBound)
			workSpace[j++] = a[highPtr++];

		for (j = 0; j < n; j++)
			a[lowerBound + j] = workSpace[j];
	}
*/

	public void merge(long[] workSpace, int arr1Ptr, int arr2Ptr, int rightest) {
		int mid = arr2Ptr - 1;
		int end = rightest;
		int begin = arr1Ptr;
		int i = 0;
		int size = rightest - arr1Ptr + 1;
		// left part: arr1Ptr >>> mid; right part: arr2Ptr = mid + 1 >>> end
		while(arr1Ptr <= mid && arr2Ptr <= end) {
			if (a[arr1Ptr] > a[arr2Ptr])
				workSpace[i++] = a[arr1Ptr++]; // larger one copy to the workSpace
			else
				workSpace[i++] = a[arr2Ptr++];
		}

		if(arr1Ptr <= mid) {
			for(int j = arr1Ptr; j <=mid; j++) {
				workSpace[i++] = a[arr1Ptr++];
			}
		}
		else if (arr2Ptr <= end) {
			for (int j = arr2Ptr; j <= end; j++) {
				workSpace[i++] = a[arr2Ptr++];
			}
		}
		else ;

		for (int j = 0; j < size; j++) 
			a[begin + j] = workSpace[j];
/*
		for (int j = begin; j < nElem; j++) {
			// no items left
			if (arr1Ptr >= mid && arr2Ptr > rightest)
				break;
			// only has right part
			else if (arr1Ptr >= mid && arr2Ptr <= rightest && arr2Ptr >= mid) {
				workSpace[j] = a[arr2Ptr++];
			}
			// only has left part
			else if (arr2Ptr > rightest && arr1Ptr < mid) {
				workSpace[j] = a[arr1Ptr++];
			}
			// have both left right part
			else {
				//left > right
				if(a[arr1Ptr] > a[arr2Ptr]) {
					workSpace[j] = a[arr2Ptr++];
				}
				else {
					workSpace[j] = a[arr1Ptr++];
				}
			}
		}
*/

		System.out.print("Merge: ");
		for(int k = 0; k < nElem; k++)
			System.out.print(workSpace[k] + " ");
		System.out.println("--END--");
	
		
		//System.out.print("Merge:   ");
		//display();
	}
}
//========================
class MergeSortApp {
	public static void main(String args[]) {
		int maxSize = 100;
		Array arr;
		arr = new Array(maxSize);

		arr.insert(64);
		arr.insert(21);
		arr.insert(33);
		arr.insert(70);
		arr.insert(12);
		arr.insert(85);
		arr.insert(44);
		arr.insert(3);
		arr.insert(96);
		arr.insert(0);
		arr.insert(108);
		arr.insert(36);

		arr.display();

		arr.mergeSort();

		arr.display();
	}
}
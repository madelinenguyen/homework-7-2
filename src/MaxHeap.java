import java.util.Arrays;

public class MaxHeap implements Heap {
	int size;

	Integer[] data;

	public MaxHeap(int capacity) {
		data = new Integer[capacity];
		size = 0;
	}
	
	/*
	 * I used this website to help me:
	 * https://www.geeksforgeeks.org/max-heap-in-java/
	 */
	
	// build a heap based on data
	// to be implemented in O(nlogn)
	public void MaxHeapLogN(Integer[] data) {
		int start = (data.length/2)-1;
		for (int i = start; i>=0; i--) {
			heapify(data, data.length, i);
		}
	}

	static void heapify(Integer arr[], int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		// left leaf > root
		if (left < n && arr[left] > arr[largest])
			largest = left;

		// right leaf > root
		if (right < n && arr[right] > arr[largest])
			largest = right;

		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapify(arr, n, largest);
		}
	}

	// build a heap based on data
	// to be implemented in O(n)
	public void MaxHeapN(Integer[] data) {
		// copy data into heap
		this.data = Arrays.copyOf(data, data.length);
		
		this.size = data.length;
		int lastPar = parent(size-1);
		for (int i = lastPar; i>=0; i--) heapDown(i);
	}

	// add an item to the heap
	public boolean add(Integer item) {
		// check size
		if (size>=data.length) return false;
		
		// set item
		data[size] = item;
		size++;
		
		// call recursive heap up
		heapUp(size-1);
		return true;
	}

	// recursive heap up
	private void heapUp(int n) {
		if (n==0)
			return;
		Integer parent = (n-1)/2;
		if (data[n]>data[parent]) {
			swap(n, parent);
			heapUp(parent);
		}
	}

	// recursive heap down
	private void heapDown(int n) {
        if (n==size) return;
        
        Integer left = 2*n+1;
        Integer right = 2*n+2;
        
        if (right <= size-1) {
        	// parent vs. left leaf
            if (data[n] < data[left]) {
            	// parent vs. right leaf
                if (data[left] >= data[right]) {
                    swap(n, left);
                    heapDown(left);
                }
                else {
                	swap(n, right);
                    heapDown(right);
                }
            }
            else if (data[n] < data[right]) {
            	swap(n, right);
                heapDown(right);
            }
        }
    }

	// Returns position of parent
	private int parent(int pos) {
		return pos / 2;
	}

	public Integer pop() {
		// check size
		if (size<1) return null;
		
		int max = data[0];
		data[0] = data[size - 1];
		
		// call recursive heap down
		heapDown(0);
		size--;
		return max;
	}

	private void swap(int pos1, int pos2) {
		int temp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = temp;
	}

	// return the max item in the heap
	public Integer get() {
		// check if heap is empty
		if (size==0)
			return null;
		return data[0];
	}

	// used to compare in J-Unit tests
	public boolean equal(Integer[] data) {
		for (int i=0; i<this.size; i++) {
			if (this.data[i]!=data[i]) return false;
		}
		return true;
	}
}

public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 1;
	}
	
	private int getParent(int pos){ 
        return pos / 2; 
    }
	private int getLeft(int pos){ 
        return pos * 2; 
    }
	private int getRight(int pos){ 
        return (pos * 2) + 1; 
    }
	private void swapIntervals(int pos1, int pos2){ 
        Interval tmp; 
        tmp = heap[pos1]; 
        heap[pos1] = heap[pos2]; 
        heap[pos2] = tmp; 
    }

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	*/
	public void insert(Interval k) {
		
		//if array is full double the size
		if (numElements == size) {
			size = size * 2;
			Interval [] tmp = new Interval[size];
			for (int i = 1; i < numElements+1; i++){
				tmp[i] = heap[i];
			}
			heap = new Interval[size];
			heap = tmp;
		}
		
		//insert Interval K at the end of the array and increase num elements
		heap[numElements+1] = k;
		numElements++;
		
		//now fix the ordering of the array
		int curr = size;
		
		while (heap[curr].getLength() > heap[getParent(curr)].getLength())
		{
			swapIntervals(curr, getParent(curr)); 
            curr= getParent(curr);
			
		}
	}
	
	private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    }
	
	
	
	private void siftDown(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (heap[pos].getLength() < heap[getLeft(pos)].getLength() ||  
            heap[pos].getLength() < heap[getRight(pos)].getLength()) { 
  
            if (heap[getLeft(pos)].getLength() > heap[getRight(pos)].getLength()) { 
                swapIntervals(pos, getLeft(pos)); 
                siftDown(getLeft(pos)); 
            } 
            else { 
                swapIntervals(pos, getRight(pos)); 
                siftDown(getRight(pos)); 
            } 
        } 
    }
	
	
	
	
	

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	TODO: Please complete this method.
	*/
	public Interval remove_max() {
		if (numElements == 1) return null; // Retuns null if heap is empty.
		// Remove_max code here.
		
		//heap[1] or the root should be the max element
		Interval max = heap[1];
        heap[1] = heap[size--]; 
        siftDown(1); 
 
		return max; // Replace this statement with returning the max element (root) in the heap.
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println(heap[i]);
	}
}

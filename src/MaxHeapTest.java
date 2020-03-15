import static org.junit.Assert.*;

import org.junit.Test;

public class MaxHeapTest {

	@Test
	public void buildMaxHeapNLogN() {
		/*
		Integer[][] inputs = {
				{},
				{1, 1, 1},
				{1, 4, 2, 7, 3},
				{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}
		};
		
		Integer[][] expects = {
				{},
				{1, 1, 1},
				{7, 4, 2, 1, 3},
				{17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1}
		};
		
		for (int i=0; i<inputs.length; i++) {
			MaxHeap testHeap = new MaxHeap(9);
			testHeap.MaxHeapLogN(inputs[i]);
			assertTrue(testHeap.equal(expects[i]));
		}
		*/
		
		MaxHeap emptyHeap = new MaxHeap(5);
		Integer[] emptyInput = {};
		emptyHeap.MaxHeapN(emptyInput);
        assertTrue(emptyHeap.equal(emptyInput));
        
        MaxHeap testHeap1 = new MaxHeap(10);
        Integer[] input1 = {1, 4, 2, 7, 3};
        Integer[] answer1 = {7, 4, 2, 1, 3};
        testHeap1.MaxHeapN(input1);
        assertTrue(testHeap1.equal(answer1));

        MaxHeap testHeap2 = new MaxHeap(10);
        Integer[] input2 = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        Integer[] answer2 =  {17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1};
        testHeap2.MaxHeapN(input2);
        assertTrue(testHeap2.equal(answer2));
        
        MaxHeap testHeap3 = new MaxHeap(10);
        Integer[] input3 = {1, 1, 1};
        Integer[] answer3 = {1, 1, 1};
        testHeap3.MaxHeapN(input3);
        assertTrue(testHeap3.equal(answer3));
	}

	@Test
	public void buildMaxHeapN() {
		MaxHeap emptyHeap = new MaxHeap(5);
		Integer[] emptyInput = {};
		emptyHeap.MaxHeapN(emptyInput);
        assertTrue(emptyHeap.equal(emptyInput));
        
        MaxHeap testHeap1 = new MaxHeap(10);
        Integer[] input1 = {1, 4, 2, 7, 3};
        Integer[] answer1 = {7, 4, 2, 1, 3};
        testHeap1.MaxHeapN(input1);
        assertTrue(testHeap1.equal(answer1));

        MaxHeap testHeap2 = new MaxHeap(10);
        Integer[] input2 = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        Integer[] answer2 =  {17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1};
        testHeap2.MaxHeapN(input2);
        assertTrue(testHeap2.equal(answer2));
        
        MaxHeap testHeap3 = new MaxHeap(10);
        Integer[] input3 = {1, 1, 1};
        Integer[] answer3 = {1, 1, 1};
        testHeap3.MaxHeapN(input3);
        assertTrue(testHeap3.equal(answer3));
	}

	@Test
	public void addTest() {

		MaxHeap heap = new MaxHeap(5);
		Integer[][] expects = { {}, { 1 }, { 4, 1 }, { 4, 1, 2 }, { 7, 4, 2, 1 }, { 7, 4, 2, 1, 3 } };

		/*
		 * Integer[] valuesToAdd = {1, 4, 2, 7, 3};
		 * 
		 * for (int i=0; i<expects.length; i++) { if (i>=1)
		 * assertTrue(heap.add(valuesToAdd[i])); assertTrue(heap.equal(expects[i]));
		 * heap.print();
		 * 
		 * }
		 */

		MaxHeap testHeap = new MaxHeap(5);
		assertTrue(testHeap.equal(expects[0]));

		assertTrue(testHeap.add(1));
		assertTrue(testHeap.equal(expects[1]));

		assertTrue(testHeap.add(4));
		assertTrue(testHeap.equal(expects[2]));

		assertTrue(testHeap.add(2));
		assertTrue(testHeap.equal(expects[3]));

		assertTrue(testHeap.add(7));
		assertTrue(testHeap.equal(expects[4]));

		assertTrue(testHeap.add(3));
		assertTrue(testHeap.equal(expects[5]));

		assertFalse(testHeap.add(123));

	}

	@Test
	public void getTest() {
		MaxHeap testHeap = new MaxHeap(7);

		assertEquals(null, testHeap.get());

		// add values
		testHeap.add(1);
		testHeap.add(2);
		testHeap.add(5);

		// must type cast to Integer object, otherwise can't read
		assertEquals((Integer) 5, testHeap.get());
		testHeap.add(4);

		assertEquals((Integer) 5, testHeap.get());
		testHeap.add(123);

		assertEquals((Integer) 123, testHeap.get());
		testHeap.add(-500);

		assertEquals((Integer) 123, testHeap.get());

	}

	@Test
	public void popTest() {
		MaxHeap testHeap = new MaxHeap(7);
		testHeap.add(1);
		assertEquals((Integer) 1, testHeap.pop());

		// remove again, should be null
		assertEquals(null, testHeap.pop());

		// add more values
		testHeap.add(6);
		testHeap.add(4);

		assertEquals((Integer) 6, testHeap.pop());
		assertEquals((Integer) 4, testHeap.pop());

		testHeap.add(2);
		testHeap.add(5);
		testHeap.add(99);
		testHeap.add(501);

		assertEquals((Integer) 501, testHeap.pop());

		testHeap.pop();

		assertEquals((Integer) 5, testHeap.pop());
	}

}
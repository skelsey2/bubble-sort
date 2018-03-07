package com.skelsey2.bubblesort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.Result;

import junit.textui.TestRunner;

/**
 * JUnit Class to Test the different bubble sort methods
 * 	 Using @Before/AfterClass to setup the arrays: actual/expected
 *	 Using @Before/After to reset the testArray and start/stop a timer
 * 
 * @author Steve_Revature
 *
 */
public class JavaBubbleSortTest {

	private static int[] array;
	private static int[] testArray;
	private static int[] expectedArray;
	
	static final long TEST_TIME_OUT = 5000; //5 seconds
	
	long startClock;
	long stopClock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass -Starting to test the Bubble Sort Class");

		// Setting the size of the Array Dynamically 
		int randomArraySize = (int) Math.floor(((Math.random()+1)*10000)); 
		array = new int[randomArraySize];
		
		// Setting values to the Elements in the Array 
		for(int i = 0; i < array.length -1; i++){
			array[i] =  (int) Math.floor(((Math.random()+1)*100));
		}
		
		// 2nd Array with Sorted values of 1st Array
		expectedArray = new int[randomArraySize];
		expectedArray = Arrays.copyOf(array, array.length);
		Arrays.sort(expectedArray);
		
		System.out.println("@BeforeClass -The amount of elements: " + randomArraySize);
		System.out.println("@BeforeClass -Class Setup complete");
		
	}
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("\t@Before -Testing new Method");
		
		// Reset testArray
		testArray = Arrays.copyOf(array, array.length);
		
		// Array's contents can be too long in terminal comment/uncomment to see @BeforeClass, @Before etc
//		System.out.println("\t@Before -Array is: " + Arrays.toString(array));  
		
		// Starting the clock
		startClock = System.currentTimeMillis();
	}

	@After
	public void tearDown() throws Exception {
		
		// Stopping the clocking and converting to Seconds
		stopClock = System.currentTimeMillis();
		double seconds = (stopClock - startClock);
		seconds = seconds/1000;
		
		System.out.println("\t@After -Completed method test in " + seconds + " ms");
		System.out.println(); // extra space
	}

	@Test(timeout=TEST_TIME_OUT)
	public void testBubbleSort1() {
//		fail("Not yet implemented"); //leaving here for reference
		System.out.println("\t\t@Test -testBubbleSort1");
		assertArrayEquals( expectedArray, JavaBubbleSort.bubbleSort1(testArray));
	}

	@Test(timeout=TEST_TIME_OUT)
	public void testBubbleSort2() {
		System.out.println("\t\t@Test -testBubbleSort2");
	
		assertArrayEquals( expectedArray, JavaBubbleSort.bubbleSort2(testArray));
	}

	@Test(timeout=TEST_TIME_OUT)
	public void testBubbleSort3() {
		
		System.out.println("\t\t@Test -testBubbleSort3");
		assertArrayEquals( expectedArray, JavaBubbleSort.bubbleSort3(testArray));
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass -Ending of testing of the Bubble Sort Class");
	}

}

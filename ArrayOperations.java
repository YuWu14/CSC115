import java.lang.Math;

// YU WU
// V00917423
/*
 * ArrayOperations
 *
 * A class with basic array methods to
 *  - print the values in an array
 *  - calculate the sum of the values in an array
 *  - calculate the minimum of the values in an array
 *  - calculate the maximum of the values in an array
 *  - calculate the average of the values in an array
 *
 */
public class ArrayOperations {
    /*
     * printArray
     *
     * Purpose: prints all the values in the array to the console
     *  example format:  {1,2,3,4}
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: void
     *
     */
    public static void printArray ( int[] array ) {
        System.out.print("{");
        for(int i=0; i<array.length-1; i++)
            System.out.print(array[i] + ",");
        
        System.out.println(array[array.length-1] + "}");
    }
    
    /*
     * arraySum
     *
     * Purpose: totals all the values in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: total of all values in the array
     *
     */
    public static int arraySum ( int[] array ) {
        int sum = 0;
        
        // TODO ...
 
        for(int i=0; i<array.length; i++){
			sum = sum + array[i];
		}
		
        return sum;
    }
    
    /*
     * arrayMax
     *
     * Purpose: finds the maximum value in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: maximum value in the array
     *
     */
	  // TODO
	 public static int arrayMax(int[] array){
		 int max = 0;
		 
		 if (array.length == 1){
			 
			max = array[0];
		}	
		
		 max = array[0];
		 for(int i=1; i<array.length;i++){
			if (array[i-1]<array[i]){
				max = array[i];
			}	
			 
		}

		return max; 
	}
    
    /*
     * arrayMin
     *
     * Purpose: finds the maximum value in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns:  minimum value in the array
     *
     */
    // TODO
	 public static int arrayMin(int[] array){
		 int min = 0;
		 
		 if (array.length == 1){
			 
			min = array[0];
		}	
		 
		 min = array[0];
		 for(int i=1; i<array.length;i++){
			if (array[i-1]<array[i]&& min> array[i-1]){
				min = array[i-1];
			}	
			 
		}

		return min; 
	}    
    /*
     * arrayAvg
     *
     * Purpose: finds the average of all the values in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: average of values in the array as a double
     *
     */
    // TODO
    public static double arrayAvg( int[] array ) {
        int sum = 0;
		double avg = 0;

        // TODO ...
 		if (array.length == 1){
			 
			avg = array[0];
		}	
		
		if (array.length != 1){
			int l = array.length;
		
			for(int i=0; i<array.length; i++){
			sum = sum + array[i];
			}
		
			avg = (double)sum/l; 
		}
		
        return avg;
    }
        
	
	
	
	
	
	
	
    /*
     * arraysEqual
     *
     * Purpose: determines whether the two arrays are equal
     *      where equal means array1 and array2 are the same length
     *      and the contain the same values in the same order
     *
     * Parameters: two arrays of integers
     *
     * Returns: true if the are equal, false otherwise
     *
     */
    // TODO
    public static boolean arraysEqual( int[] array1,int[] array2 ) {
		if(array1.length != array2.length){
			return false;
		}
		
		if(array1.length == 1){
			if(array1[0] != array2[0]){
				return false;
			}
		}
		
		for(int i=1; i<array1.length; i++){
			if (array1[i] != array2[i]){
				return false;
			}
			
		}		
		return true;
	}	
}
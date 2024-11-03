/******************************************************************
 *
 *   LISSETE RAMIREZ / SECTION 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;
class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */
    public boolean isSubset(int list1[], int list2[]) {
        //HashSet is created to store the elements of list1
        Set<Integer> set = new HashSet<>();
        for (int num: list1) {
            set.add(num); //adds each element of list1 to the set
        }
        //checks if every element from list2 is in the set
        for (int num : list2) {
            if (!set.contains(num)) {//if elements from list2 are missing in the set
                return false; //then list2 is not a subset of list1
            }
        }
        return true;//will return true if all elements in list2 are in list1
    }

    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */
    public int findKthLargest(int[] array, int k) {
        //A min-heap is created to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : array) {
            minHeap.offer(num); // each element from the array is added to the heap
            if (minHeap.size() > k) {
                minHeap.poll(); //if the heap size exceed k then the smallest elements are removed
            }
        } //the root of the min-heap contains the k's largest element
        return minHeap.peek();
    }

    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */
    public int[] sort2Arrays(int[] array1, int[] array2) {
        //new array is created to hold all elements from array1 and array2
        int[] merged = new int[array1.length + array2.length];
        //copies elements from array1 and array2 into the merged array
        System.arraycopy(array1, 0, merged, 0, array1.length);
        System.arraycopy(array2, 0, merged, array1.length, array2.length);
        //the merged array is sorted to get all elements in sorted order
        Arrays.sort(merged);
        return merged;
        }
    }

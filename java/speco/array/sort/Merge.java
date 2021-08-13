package speco.array.sort;

import kompari.Order;
import speco.array.Sort;

/**
 * <p>MergeSort algorithm</p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 * 
 * @author Jonatan Gomez Perdomo
 * @version 1.0
 */
public class Merge<T> extends Sort<T> {
    /**
     * InsertionSort for sorting an array of less than 8 elements
     */
    protected Insertion<T> insertion;
    /**
     * Crates a sorting algorithm with the given order
     * @param order Order used for sorting the objects
     */
    public Merge(Order<T> order) { super(order); }

    /**
     * Crates a sorting algorithm with the given order
     * @param order Order used for sorting the objects
     * @param start Initial position in the array to be sorted
     * @param end Final position in the array to be sorted
     */
    public Merge(Order<T> order, int start, int end){ super(order, start, end ); }
    
    protected int type;
    
    protected Object copy( Object a, int start, int n ) {
    	Object x;
    	if( a instanceof int[] ) x = new int[n];
    	else if( a instanceof long[] ) x = new long[n];
    	else if( a instanceof double[] ) x = new double[n];
    	else if( a instanceof char[] ) x = new char[n];
    	else if( a instanceof byte[] ) x = new byte[n];
    	else x = new Object[n];
    	System.arraycopy(a, start, x, 0, n);
    	return x;
    }

    /**
     * Sorts a portion of the array of objects according to the given order (it does not creates a new array)
     * @param a Array of objects to be sorted
     * @param start Initial position in the array to be sorted
     * @param end Final position in the array to be sorted
     * @return <i>true</i> If the sorting process was done without fails, <i>false</i> otherwise
     */
    @SuppressWarnings("unchecked")
    public void apply(Object a, int start, int end, Order<T> order) {
	insertion = new Insertion<T>(order);
	int i=start;
	while( i<end-1 && order.compare((T)java.lang.reflect.Array.get(a, i), (T)java.lang.reflect.Array.get(a, i+1)) <= 0 ){ i++; }
        if( i<end-1 ){
            int n = end - start;
            Object ca = copy(a, start, n);
            this.rec_apply( ca );
            System.arraycopy(ca,0,a,start,n);
        }
    }
    
    /**
     * Recursive merge sort method
     * @param a Array to be sorted
     */
    @SuppressWarnings("unchecked")
    public void rec_apply(Object a) {
        int n = java.lang.reflect.Array.getLength(a);
        if (n > 7) {
            int nLeft = n / 2;
            int nRight = n - nLeft;
            Object aLeft = copy(a,0,nLeft);
            Object aRight = copy(a, nLeft, nRight);

            this.rec_apply(aLeft);
            this.rec_apply(aRight);
            int k = 0;
            int left = 0;
            int right = 0;
          
	    T x = (T)java.lang.reflect.Array.get(aLeft,left);
            T y = (T)java.lang.reflect.Array.get(aRight,right);
            while (left < nLeft && right < nRight) {
                if(order.compare(x, y) < 0) {
                    java.lang.reflect.Array.set(a,k,x);
                    left++;
                    if( left<nLeft ) x = (T)java.lang.reflect.Array.get(aLeft,left);
                } else {
                    java.lang.reflect.Array.set(a,k,y);
                    right++;
                    if( right<nRight ) y = (T)java.lang.reflect.Array.get(aRight,right);
                }
                k++;
            } 
            while (left < nLeft) {
            	java.lang.reflect.Array.set(a,k, java.lang.reflect.Array.get(aLeft,left));
                left++;
                k++;
            } while (right < nRight) {
            	java.lang.reflect.Array.set(a,k, java.lang.reflect.Array.get(aRight,right));
                right++;
                k++;
            }
        } else {
            insertion.apply(a);
        }
    }
    
}
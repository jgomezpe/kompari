/**
 * <p>Copyright: Copyright (c) 2019</p>
 *
 * <h3>License</h3>
 *
 * Copyright (c) 2019 by Jonatan Gomez-Perdomo. <br>
 * All rights reserved. <br>
 *
 * <p>Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <ul>
 * <li> Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * <li> Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <li> Neither the name of the copyright owners, their employers, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * </ul>
 * <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 *
 *
 * @author <A HREF="http://disi.unal.edu.co/profesores/jgomezpe"> Jonatan Gomez-Perdomo </A>
 * (E-mail: <A HREF="mailto:jgomezpe@unal.edu.co">jgomezpe@unal.edu.co</A> )
 * @version 1.0
 */
package speco.array.sort;

import kompari.Order;
import speco.array.Sort;

/**
 * <p>Title: Merge</p>
 *
 * <p>Description: Merge Sort algorithm</p>
 * @param <T> Type of elements in the array
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
	 */
	@SuppressWarnings("unchecked")
	public void apply(Object a, int start, int end, Order<T> order) {
		insertion = new Insertion<T>(order);
		int i=start;
		while( i<end-1 && order.compare((T)java.lang.reflect.Array.get(a, i), 
				(T)java.lang.reflect.Array.get(a, i+1)) <= 0 ){ i++; }
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
		} else  insertion.apply(a);
	}    
}
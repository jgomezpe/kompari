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
package speco.array;

import kompari.Order;

/**
 * <p>Title: SortedSearch</p>
 *
 * <p>Description: Searching algorithm for sorted arrays of objects</p>
 * @param <T> Type of elements in the array
 */
public class SortedSearch<T> {
	/**
	 * Elements order
	 */
	protected Order<T> order;
    
	/**
	 * Sorted array being analyzed
	 */
	protected Array<T> sorted;
	
	/**
	 * Creates a search operation for the given sorted array
	 * @param order Order used for locating the object
	 */
	public SortedSearch(Order<T> order){ this.order = order; }
	
	/**
	 * Creates a search operation for the given sorted array
	 * @param sorted Array of elements (should be sorted)
	 * @param order Order used for locating the object
	 */
	public SortedSearch(Array<T> sorted, Order<T> order){ 
		this(order);
		set(sorted);
	}
	
	/**
	 * Creates a search operation for the given sorted array
	 * @param sorted Array of elements (should be sorted)
	 * @param order Order used for locating the object
	 */
	public SortedSearch(Object sorted, Order<T> order){
		this(order);
		set(sorted);
	}
	
	/**
	 * Sets the sorted array to be analyzed 
	 * @param sorted Array to be analyzed
	 */
	public void set( Object sorted ){ this.sorted = new Array<T>(sorted); } 

	/**
	 * Sets the sorted array to be analyzed 
	 * @param sorted Array to be analyzed
	 */
	public void set( Array<T> sorted ){ this.sorted = sorted; } 

	/**
	 * Searches for the position of the given element. The vector should be sorted
	 * @param x Element to be located
	 * @return The position of the given object, -1 if the given object is not in the array
	 */
	public int find(T x) { return find( 0, sorted.size(), x ); }

	/**
	 * Searches for the position of the given element. The vector should be sorted
	 * @param x Element to be located
	 * @param start Starting searching position
	 * @param end Ending (not included) searching position
	 * @return The position of the given object, -1 if the given object is not in the array
	 */
	public int find(int start, int end, T x) {
		int pos = findRight(start, end, x);
		if (pos > start && order.compare(x, sorted.get(pos - 1)) == 0) pos--;
		else pos = -1;
		return pos;
	}

	/**
	 * Determines if the sorted array contains the given element (according to the associated order)
	 * @param x Element to be located
	 * @param start Starting searching position
	 * @param end Ending (not included) searching position
	 * @return <i>true</i> if the element belongs to the sorted array, <i>false</i> otherwise
	 */
	public boolean contains(int start, int end, T x){ return (find(start, end, x) != -1); }

	/**
	 * Determines if the sorted array contains the given element (according to the associated order)
	 * @param x Element to be located
	 * @return <i>true</i> if the element belongs to the sorted array, <i>false</i> otherwise
	 */
	public boolean contains(T x) { return (find(x) != -1); }

	/**
	 * Searches for the position of the first element in the array that is bigger
	 * than the element given. The array should be sorted
	 * @param x Element to be located
	 * @return Position of the object that is bigger than the given element
	 */
	public int findRight(T x) { return findRight( 0, sorted.size(), x ); }

	/**
	 * Searches for the position of the first element in the array that is bigger
	 * than the element given. The array should be sorted
	 * @param x Element to be located
	 * @param start Starting searching position
	 * @param end Ending (not included) searching position
	 * @return Position of the object that is bigger than the given element
	 */
	public int findRight(int start, int end, T x){ 
		if (end > start) {
			int a = start;
			int b = end - 1;
			if (order.compare(x, sorted.get(a)) < 0)  return start;
			if (order.compare(x, sorted.get(b)) >= 0) return end;
			while (a + 1 < b) {
				int m = (a + b) / 2;
				if (order.compare(x, sorted.get(m)) < 0) b = m;
				else a = m;
			}
			return b;
		}else return start;
	}

	/**
	 * Searches for the position of the last element in the array that is smaller
	 * than the element given. The array should be sorted
	 * @param x Element to be located
	 * @return Position of the object that is smaller than the given element
	 */
	public int findLeft(T x){ return findLeft( 0, sorted.size(), x ); }

	/**
	 * Searches for the position of the last element in the array that is smaller
	 * than the element given. The array should be sorted
	 * @param start Starting searching position
	 * @param end Ending (not included) searching position
	 * @param x Element to be located
	 * @return Position of the object that is smaller than the given element
	 */
	public int findLeft(int start, int end, T x) {
		if (end > start) {
			int a = start;
			int b = end - 1;
			if (order.compare(x, sorted.get(a)) <= 0)  return start-1;
			if (order.compare(x, sorted.get(b)) > 0) return b;
			while (a + 1 < b) {
				int m = (a + b) / 2;
				if (order.compare(x, sorted.get(m)) <= 0) b = m;
				else a = m;
			}
			return a;
		}else return start;
	} 
}
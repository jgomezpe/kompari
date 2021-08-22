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
 * <p>Title: BubbleSort</p>
 *
 * <p>Description: BubbleSort algorithm</p>
 * @param <T> Type of elements in the array
 */
public class Bubble<T> extends Sort<T> {
	/**
	 * Creates a sorting algorithm with the given order
	 * @param order Order used for sorting the objects
	 */
	public Bubble(Order<T> order) { super(order); }

	/**
	 * Crates a sorting algorithm with the given order
	 * @param order Order used for sorting the objects
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 */
	public Bubble(Order<T> order, int start, int end){ super(order, start, end ); }

	/**
	 * Sorts a portion of the array of objects according to the given order (it does not creates a new array)
	 * @param a Array of objects to be sorted
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 */
	@Override
	public void apply(Object a, int start, int end, Order<T> order) {
		for(int i = start; i < end - 1; i++){
			@SuppressWarnings("unchecked")
			T x = (T)java.lang.reflect.Array.get(a, i);
			for(int j = i + 1; j < end; j++) {
				@SuppressWarnings("unchecked")
				T y = (T)java.lang.reflect.Array.get(a, j);
				if(order.compare(y, x)<0) {
					java.lang.reflect.Array.set(a, i, y);
					java.lang.reflect.Array.set(a, j, x);
					x = y;
				}
			}	
		}	
	}
}
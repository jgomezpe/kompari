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
 * <p>Abstract Sorting algorithm for Arrays of objects</p>
 * @param <T> Type of elements in the array
 */
public abstract class Sort<T>{
	/**
	 * Order used for sorting the objects
	 */
	protected Order<T> order = null;

	/**
	 * start Initial position in the array to be sorted
	 */
	protected int start=0;

	/**
	 * end Final position in the array to be sorted
	 */
	protected int end=-1;

	/**
	 * Crates a sorting algorithm with the given order
	 * @param order Order used for sorting the objects
	 */
	public Sort(Order<T> order) { this.order = order; }

	/**
	 * Crates a sorting algorithm with the given order
	 * @param order Order used for sorting the objects
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 */
	public Sort(Order<T> order, int start, int end){ 
		this(order); 
		this.start = start;
		this.end = end;
	}

	/**
	 * Sets the sorting limits
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 */
	public void setLimits(int start, int end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * Sorts the array of objects according to the given order (it does not creates a new array)
	 * @param a Array of objects to be sorted
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 * @param order Order used for sorting the objects
	 */
	public abstract void apply(Object a, int start, int end, Order<T> order);

	/**
	 * Sorts the array of objects according to the given order (it does not creates a new array)
	 * @param a Array of objects to be sorted
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 * @param order Order used for sorting the objects
	 */
	public void apply(Array<T> a, int start, int end, Order<T> order){ apply(a.buffer,start,end,order); }

	/**
	 * Runs the sorting algorithm on the given array and the established order
	 * @param input Array to be sorted
	 */
	public void apply(Object input) {
		apply(input, start, (end==-1)?java.lang.reflect.Array.getLength(input):end, order);
	}

	/**
	 * Runs the sorting algorithm on the given array and the established order
	 * @param input Array to be sorted
	 */
	public void apply(Array<T> input){ apply(input.buffer); }
}
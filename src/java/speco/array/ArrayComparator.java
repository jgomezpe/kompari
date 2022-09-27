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

import kompari.Comparator;

/**
 * <p>Compares two Arrays</p>
 * @param <T> Type of elements in the array
 */
public class ArrayComparator<T> implements Comparator<Array<T>>{
	/**
	 * Elements comparator
	 */
	protected Comparator<T> inner;
    
	/**
	 * Creates an Array comparator using the provided element's comparator
	 * @param inner Elements comparator
	 */
	public ArrayComparator(Comparator<T> inner) { this.inner = inner; }
    
	/**
	 * Compares two object arrays 
	 * @param one First array
	 * @param n Size of the first array
	 * @param two Second array
	 * @param m Size of the second array
	 * @return (one==two): n==m and one[i] == two[i] for all i=0,..,n-1
	 */
	@SuppressWarnings("unchecked")
	public boolean eq(Object one, int n, Object two, int m) {
		if( n!=m ) return false;
		boolean flag = true;
		for( int i=0; flag && i<n; i++ ) 
			flag = inner.eq((T)java.lang.reflect.Array.get(one, i),
		(T)java.lang.reflect.Array.get(two, i));
		return flag; 	
	}

	/**
	 * Compares two arrays 
	 * @param one First array
	 * @param two Second array
	 * @return (one==two): size(one)==size(two) and one[i] == two[i] for all i=0,..,size(one)
	 */
	public boolean eq(Array<T> one, Array<T> two) {
		return eq(one.buffer, one.size(), two.buffer, two.size());
	}
}
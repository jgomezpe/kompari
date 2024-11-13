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


import kompari.integer.IntL2HOrder;
import speco.array.SortedSearch;
import kompari.Order;
import speco.array.sort.Merge;

/**
 * <p>Testing sort algorithms</p>
 */
public class KompariDemo {
	public static void merge( String[] args ) {
		Order<Integer> order = new IntL2HOrder();
		Merge<Integer> sort = new Merge<Integer>(order);
		int[] x = new int[] {3,1,5,9,7,13,11,15,4,2,8,6,0,12,10,16,14,18};
		sort.apply(x, 0, x.length, order);
		for( int i=0; i<x.length; i++)
			System.out.println(x[i]);
	} 
    
	public static void search() {
		Order<Integer> order = new IntL2HOrder();
		Merge<Integer> sort = new Merge<Integer>(order);
		int[] x = new int[] {3,1,5,9,7,13,11,15,4,2,8,6,0,12,10,16,14,18};
		sort.apply(x, 0, x.length, order);
		for( int i=0; i<x.length; i++)
			System.out.println(x[i]);
		SortedSearch<Integer> search = new SortedSearch<Integer>(x,order); 
		for( int i=0; i<x.length; i++ )
			System.out.println(x[i] + ":" + search.find(x[i]));
		System.out.println("-10:" + search.find(-10));
		System.out.println("17:" + search.find(17));
		System.out.println("20:" + search.find(20));
	} 
    
	public static void main( String[] args ) {
		search();
	}
}
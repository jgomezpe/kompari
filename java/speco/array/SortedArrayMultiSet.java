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

import java.util.Iterator;
import kompari.Order;

/**
 * <p>Title: SortedArrayMultiSet</p>
 *
 * <p>Description: A set allowing multiple copies of an element. Provide access to elements using an index/key.</p>
 *
 */
public class SortedArrayMultiSet<T> extends ArrayMultiSet<T>{
    /**
     * Binary search algorithm
     */
    protected SortedSearch<T> search;
    /**
     * Order function
     */
    protected Order<T> order;

    /**
     * Creates a set using the Array for maintaining the elements
     * @param order Order function
     */
    public SortedArrayMultiSet( Order<T> order ) { 
	super();
	this.order = order;
	this.search = new SortedSearch<T>(array, order);
    }

    /**
     * Creates a set using the Array for maintaining the elements
     * @param array Array maintaining the elements
     * @param order Order function
     */
    public SortedArrayMultiSet( Array<T> array, Order<T> order ) { 
	super(array);
	this.order = order;
	this.search = new SortedSearch<T>(array, order);
    }

    /**
     * Gets the associated index (key) of the first appearance (in some order) of the given object.
     * @param data Object from which an associated index will be returned.
     * @return The associated index of the first appearance of the object, <i>null</i> otherwise.
     */
    @Override
    public Integer first(T data) {
	int i=search.findLeft(data);
	if(i<array.size() && order.compare(data, array.get(i+1))==0) return i+1;
	return null;
    }

    /**
     * Gets the associated index (key) of the first appearance (in some order) of the given object.
     * @param data Object from which an associated index will be returned.
     * @return The associated index of the first appearance of the object, <i>null</i> otherwise.
     */
    @Override
    public Integer last(T data) {
	int i=search.findRight(data);
	if(i>0 && order.compare(data, array.get(i-1))==0) return i-1;
	return null;
    }
    /**
     * Gets an iterable version of the collection of indices associated to a given object
     * @param data Object from which associated indices will be returned.
     * @return An iterable version of the collection of indices associated to a given object
     */
    @Override
    public Iterator<Integer> get(T data) {
	return new Iterator<Integer>() {
	    protected int min=search.findLeft(data)+1;
	    protected int max=search.findRight(data)-1;
	    @Override
	    public boolean hasNext() { return min<=max; }

	    @Override
	    public Integer next() {
		if(min<=max) return min++;
		return null;
	    } 
	};
    }

    /**
     * Adds a data element to the set
     * @param data Data element to be inserted
     * @return <i>true</i> if the element could be added, <i>false</i> otherwise
     */
    @Override
    public boolean add(T data) { 
        int index = search.findRight(data);
        if( index == array.size() ) return array.add(data);
        else return array.add(index, data);
    }
    
    /**
     * Removes completely (all copies) the given data from the associated collection 
     * @param data Object to be removed from the associated collection
     * @return <i>true</i> if the element was in the multiset and could be (completely) removed, <i>false</i> otherwise
     */
    @Override
    public boolean remove(T data) {	
	int min=search.findLeft(data)+1;
	int max=search.findRight(data)-1;
	if(min<=max) {
	    while(min<=max) {
		array.remove(max);
		max--;
	    }
	    return true;
	}
	return false;
    }    
}

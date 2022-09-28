/**
*
* kompari.js
* <P>Java Script for objects comparisson and ordering.</P>
* <P>A numtseng module <A HREF="https://numtseng.com/modules/kompari.js">https://numtseng.com/modules/kompari.js</A> 
*
* Copyright (c) 2021 by Jonatan Gomez-Perdomo. <br>
* All rights reserved. See <A HREF="https://github.com/jgomezpe/kompari">License</A>. <br>
*
* @author <A HREF="https://disi.unal.edu.co/~jgomezpe/"> Professor Jonatan Gomez-Perdomo </A>
* (E-mail: <A HREF="mailto:jgomezpe@unal.edu.co">jgomezpe@unal.edu.co</A> )
* @version 1.0
*/

/////// Kompari.js ////////////
/**
 * Determines if the first number is less than (in some order) the second number(one&lt;two)
 * @param one First number
 * @param two Second number
 * @return (one&lt;two)
 */
function l2h(one,two){ return (one-two) }

/**
 * Determines if the first number is greater than (in some order) the second number(one&gt;two)
 * @param one First number
 * @param two Second number
 * @return (one&gt;two)
 */
function h2l(one,two){ return (two-one) }

Compare = {
    equals(one, two){
        if(one.equals !== undefined) return one.equals(two)
        else return one==two
    }    
}

/** Searching algorithm for sorted arrays of objects */
class SortedSearch {
    /**
     * Creates a search operation for the given sorted array
     * @param sorted Array of elements (should be sorted)
     * @param order Order used for locating the object
     */
    constructor(order, sorted){ 
        this.order = order
        this.sorted = sorted
    }
    
    /**
     * Searches for the position of the given element. The vector should be sorted
     * @param x Element to be located
     * @param start Starting searching position
     * @param end Ending (not included) searching position
     * @return The position of the given object, -1 if the given object is not in the array
     */
    find(x, start, end) { 
        end = end || this.sorted.length
        start = start || 0
        var pos = this.findRight(x, start, end)
        if (pos > start && this.order(x, this.sorted[pos-1]) == 0) pos--
        else pos = -1
        return pos
    }

    /**
     * Determines if the sorted array contains the given element (according to the associated order)
     * @param x Element to be located
     * @param start Starting searching position
     * @param end Ending (not included) searching position
     * @return <i>true</i> if the element belongs to the sorted array, <i>false</i> otherwise
     */
    contains(x, start, end){ return (this.find(x, start, end) != -1) }

    /**
     * Searches for the position of the first element in the array that is bigger
     * than the element given. The array should be sorted
     * @param x Element to be located
     * @param start Starting searching position
     * @param end Ending (not included) searching position
     * @return Position of the object that is bigger than the given element
     */
    findRight(x, start, end){ 
        end = end || this.sorted.length
        start = start || 0
        if(end > start) {
            var a = start
            var b = end - 1
            if (this.order(x, this.sorted[a]) < 0)  return start
            if (this.order(x, this.sorted[b]) >= 0) return end
            while (a + 1 < b) {
                var m = Math.floor((a + b) / 2)
                if (this.order(x, this.sorted[m]) < 0) b = m
                else a = m
            }
            return b
        }else return start
    }

    /**
     * Searches for the position of the last element in the array that is smaller
     * than the element given. The array should be sorted
     * @param start Starting searching position
     * @param end Ending (not included) searching position
     * @param x Element to be located
     * @return Position of the object that is smaller than the given element
     */
    findLeft(x, start, end) {
        end = end || this.sorted.length
        start = start || 0
        if (end > start) {
            var a = start
            var b = end - 1
            if (this.order(x, this.sorted[a]) <= 0)  return start-1
            if (this.order(x, this.sorted[b]) > 0) return b
            while (a + 1 < b) {
                var m = Math.floor((a + b) / 2)
                if (this.order(x, this.sorted[m]) <= 0) b = m
                else a = m
            }
            return a
        }else return start
    } 
}

/**
 * <p>Abstract Sorting algorithm for Arrays of objects</p>
 */
 class Sort{
	/**
	 * Crates a sorting algorithm with the given order
	 * @param order Order used for sorting the objects
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 */
	constructor(order, start=0, end=-1){ 
		this.order = order
		this.start = start
		this.end = end
	}

	/**
	 * Sets the sorting limits
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 */
	setLimits(start, end) {
		this.start = start
		this.end = end
	}

	/**
	 * Sorts the array of objects according to the given order (it does not creates a new array)
	 * @param a Array of objects to be sorted
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 * @param order Order used for sorting the objects
	 */
	apply(a, start=0, end=-1, order=null){ return a }
}

/**
 * <p>Insertion sort algorithm</p>
 */
 class Insertion extends Sort{
	/**
	 * Crates a sorting algorithm with the given order
	 * @param order Order used for sorting the objects
	 */
	constructor(order, start=0, end=-1){ super(order, start, end ) }

	/**
	 * Sorts a vector of objects using Insertion sort
	 * @param a array to be sorted
	 */
	apply(a, start=0, end=-1, order=null) {
        if(order == null) order = this.order
        if(end=-1) end = a.length
		for (var i = start+1; i < end; i++) {
			var y
			var x = a[i]
			var j = i - 1
			while(j >= start && order(x, y=a[j])<0 ) {
				a[j+1] = y
				j--
			}
			a[j+1] = x
		}
	}
}

/**
 * <p>Bubble sort algorithm</p>
 */
class Bubble extends Sort{
	/**
	 * Crates a sorting algorithm with the given order
	 * @param order Order used for sorting the objects
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 */
	constructor(order, start=0, end=-1){ super(order, start, end ) }

	/**
	 * Sorts a portion of the array of objects according to the given order (it does not creates a new array)
	 * @param a Array of objects to be sorted
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 */
	apply( a, start=0, end=-1, order=null) {
        if(order == null) order = this.order
        if(end=-1) end = a.length
		for(var i = start; i < end - 1; i++){
			var x = a[i]
			for(var j = i + 1; j < end; j++) {
				var y = a[j]
				if(order(y, x)<0) {
					a[i] = y
					a[j] = x
					x = y
				}
			}	
		}
	}
}

/**
 * <p>Merge Sort algorithm</p>
 */
class Merge extends Sort{
	/**
	 * Crates a sorting algorithm with the given order
	 * @param order Order used for sorting the objects
	 */
	constructor(order, start=0, end=-1){ super(order, start, end ) }
    
	copy( a, start, n ) {
		var x = []
        for(var i=0; i<n; i++) x[i] = a[start+i]
		return x
	}

	/**
	 * Sorts a portion of the array of objects according to the given order (it does not creates a new array)
	 * @param a Array of objects to be sorted
	 * @param start Initial position in the array to be sorted
	 * @param end Final position in the array to be sorted
	 */
	apply(a, start=0, end=-1, order=null) {
        if(order==null) order = this.order
        if(end=-1) end = a.length
		this.insertion = new Insertion(order)
		this.rec_apply( a, order );
	}
    
	/**
	 * Recursive merge sort method
	 * @param a Array to be sorted
	 */
	rec_apply(a, order) {
		var n = a.length
		if (n > 7) {
			var nLeft = Math.floor(n / 2)
			var nRight = n - nLeft
			var aLeft = this.copy(a, 0, nLeft)
			var aRight = this.copy(a, nLeft, nRight)

            this.rec_apply(aLeft, order)
			this.rec_apply(aRight, order)

			var k = 0
			var left = 0
			var right = 0
          
			var x = aLeft[left]
			var y = aRight[right]
			while (left < nLeft && right < nRight) {
				if(order(x, y) < 0) {
					a[k] = x
					left++
					if( left<nLeft ) x = aLeft[left]
				} else {
					a[k] = y
					right++
					if( right<nRight ) y = aRight[right]
				}
				k++
			} 
			while (left < nLeft) {
				a[k] = aLeft[left]
				left++
				k++
			} while (right < nRight) {
				a[k] = aRight[right]
				right++
				k++
			}
		} else this.insertion.apply(a)
	}    
}
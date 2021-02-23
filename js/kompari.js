/**
 * Determines if the first number is less than (in some order) the second number(one<two)
 * @param one First number
 * @param two Second number
 * @return (one<two)
 */
function l2h(one,two){ return (one-two) }

/**
 * Determines if the first number is greater than (in some order) the second number(one<two)
 * @param one First number
 * @param two Second number
 * @return (one>two)
 */
function h2l(one,two){ return (two-one) }

Compare = {
    equals(one, two){
        if(one.equals !== undefined) return one.equals(two)
        else return one==two
    }    
}

/**
 * <p>Searching algorithm for sorted arrays of objects</p>
 * 
 * <p>Copyright: Copyright (c) 2010</p>
 * 
 * @author Jonatan Gomez Perdomo
 * @version 1.0
 */
class SortedSearch {
    /**
     * Creates a search operation for the given sorted array
     * @param sorted Array of elements (should be sorted)
     */
    constructor(order, sorted){ 
        this.order = order
        this.sorted = sorted
    }
    
    /**
     * Searches for the position of the given element. The vector should be sorted
     * @param x Element to be located
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
     * @return <i>true</i> if the element belongs to the sorted array, <i>false</i> otherwise
     */
    contains(x, start, end){ return (this.find(x, start, end) != -1) }

    /**
     * Searches for the position of the first element in the array that is bigger
     * than the element given. The array should be sorted
     * @param x Element to be located
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
                var m = (a + b) / 2
                if (this.order(x, this.sorted[m]) < 0) b = m
                else a = m
            }
            return b
        }else return start
    }

    /**
     * Searches for the position of the last element in the array that is smaller
     * than the element given. The array should be sorted
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
                var m = (a + b) / 2
                if (this.order(x, this.sorted[m]) <= 0) b = m
                else a = m
            }
            return a
        }else return start
    } 
}

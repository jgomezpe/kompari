package speco.array;

import kompari.Order;

/**
 * <p>Abstract Sorting algorithm for Arrays of objects</p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 * 
 * @author Jonatan Gomez Perdomo
 * @version 1.0
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
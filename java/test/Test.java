package test;

import kompari.integer.L2HOrder;
import speco.array.SortedSearch;
import kompari.Order;
import speco.array.sort.Merge;

public class Test {
    public static void merge( String[] args ) {
    	Order<Integer> order = new L2HOrder();
    	Merge<Integer> sort = new Merge<Integer>(order);
    	int[] x = new int[] {3,1,5,9,7,13,11,15,4,2,8,6,0,12,10,16,14,18};
    	sort.apply(x, 0, x.length, order);
    	for( int i=0; i<x.length; i++)
    		System.out.println(x[i]);
    } 
    
    public static void search() {
    	Order<Integer> order = new L2HOrder();
    	Merge<Integer> sort = new Merge<Integer>(order);
    	int[] x = new int[] {3,1,5,9,7,13,11,15,4,2,8,6,0,12,10,16,14,18};
    	sort.apply(x, 0, x.length, order);
    	for( int i=0; i<x.length; i++)
    		System.out.println(x[i]);
    	SortedSearch<Integer> search = new SortedSearch<Integer>(x,order); 
    	for( int i=0; i<x.length; i++ ) {
    		System.out.println(x[i] + ":" + search.find(x[i]));
    	}
    } 
    
    public static void main( String[] args ) {
	search();
    }
}

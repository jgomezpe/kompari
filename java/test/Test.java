package test;

import kompari.integer.L2HOrder;
import speco.array.SortedSearch;
import kompari.Order;
import speco.array.Sorted;
import speco.array.sort.Merge;

public class Test {
    public static void merge( String[] args ) {
    	Order order = new L2HOrder();
    	Merge sort = new Merge(order);
    	int[] x = new int[] {3,1,5,9,7,13,11,15,4,2,8,6,0,12,10,16,14,18};
    	sort.apply(x, 0, x.length, order);
    	for( int i=0; i<x.length; i++)
    		System.out.println(x[i]);
    } 
    
    public static void search() {
    	Order order = new L2HOrder();
    	Merge sort = new Merge(order);
    	int[] x = new int[] {3,1,5,9,7,13,11,15,4,2,8,6,0,12,10,16,14,18};
    	sort.apply(x, 0, x.length, order);
    	for( int i=0; i<x.length; i++)
    		System.out.println(x[i]);
    	SortedSearch search = new SortedSearch(x,order); 
    	for( int i=0; i<x.length; i++ ) {
    		System.out.println(x[i] + ":" + search.find(x[i]));
    	}
    } 
    
	public static void main( String[] args ) {
		Sorted<Integer> s = new Sorted<Integer>(new L2HOrder());
		for( int i=0; i<100; i++) {
			int x = (int)(1000*Math.random());
			s.add(x);
			System.out.print(x+" ");
		}
		System.out.println("\n **************");
		for( int k=0; k<s.size(); k++ ) System.out.print(s.get(k)+" ");
		System.out.println("\n **************");
	}

}

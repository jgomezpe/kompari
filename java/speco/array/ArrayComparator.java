package speco.array;

import kompari.Comparator;

public class ArrayComparator<T> implements Comparator<Array<T>>{
    protected Comparator<T> inner;
    
    public ArrayComparator(Comparator<T> inner) { this.inner = inner; }
    
    @SuppressWarnings("unchecked")
    public boolean eq(Object one, int n, Object two, int m) {
	if( n!=m ) return false;
	boolean flag = true;
	for( int i=0; flag && i<n; i++ ) 
	    flag = inner.eq((T)java.lang.reflect.Array.get(one, i),
		    (T)java.lang.reflect.Array.get(two, i));
	return flag; 	
    }

    public boolean eq(Array<T> one, Array<T> two) {
	return eq(one.buffer, one.size(), two.buffer, two.size());
    }
}

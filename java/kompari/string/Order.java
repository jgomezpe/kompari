package kompari.string;

public class Order implements kompari.Order {
    /**
     * Determines if the first Double is less than (in some order) the second Double (one<two)
     * @param one First Double
     * @param two Second Double
     * @return (one<two)
     */
    public int compare(String one, String two) {
	int n=one.length();
	int m=two.length();
	int i=0;
	while(i<n && i<m && one.charAt(i)==two.charAt(i)) i++;
	if(i==n) {
	    if(i==m) return 0;
	    else return -1;
	}else return 1;
    }

    /**
     * Determines if the first Integer is less than (in some order) the second Integer (one<two)
     * @param one First Integer
     * @param two Second Integer
     * @return (one<two)
     */
    public int compare(Object one, Object two){ return compare((String)one, (String)two); }
}
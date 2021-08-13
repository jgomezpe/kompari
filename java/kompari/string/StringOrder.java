package kompari.string;

import kompari.Order;

public class StringOrder implements Order<String> {
    /**
     * Determines if the first String is less than (lexicographical) the second String (one<two)
     * @param one First String
     * @param two Second String
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
}
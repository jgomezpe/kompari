package kompari.integer;

import kompari.Order;

public interface IntOrder extends Order<Integer> {
    /**
     * Determines if the first int is less than (in some order) the second int (one<two)
     * @param one First int
     * @param two Second int
     * @return (one<two)
     */
    default int compare(int one, int two){ return compare((Integer)one, (Integer)two); }
}
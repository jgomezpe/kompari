package kompari.large;

import kompari.Order;

public interface LongOrder extends Order<Long> {
    /**
     * Determines if the first long is less than (in some order) the second long (one<two)
     * @param one First long
     * @param two Second long
     * @return (one&lt;two)
     */
    default int compare(long one, long two){ return compare((Long)one, (Long)two); }
}
package kompari.large;

public interface Order extends kompari.Order {
    /**
     * Determines if the first Double is less than (in some order) the second Double (one<two)
     * @param one First Double
     * @param two Second Double
     * @return (one<two)
     */
    default int compare(long one, long two){ return compare((Long)one, (Long)two); }
}
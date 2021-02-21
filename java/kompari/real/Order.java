package kompari.real;

public interface Order extends kompari.Order{
    /**
     * Determines if the first Double is less than (in some order) the second Double (one<two)
     * @param one First Double
     * @param two Second Double
     * @return (one<two)
     */
    default int compare(double one, double two){ return compare((Double)one, (Double)two); }
}
package kompari.real;

import kompari.Order;

public interface DoubleOrder extends Order<Double>{
    /**
     * Determines if the first double is less than (in some order) the second double (one<two)
     * @param one First double
     * @param two Second double
     * @return (one&lt;two)
     */
    default int compare(double one, double two){ return compare((Double)one, (Double)two); }
}
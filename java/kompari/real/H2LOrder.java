package kompari.real;

/**
 * <p>Compares to Doubles</p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 * 
 * @author Jonatan Gomez Perdomo
 * @version 1.0
 */

public class H2LOrder implements DoubleOrder {
    /**
     * Determines if the first Double is greater than the second Double (one>two)
     * @param one First Double
     * @param two Second Double
     * @return (one>two)
     */
    public int compare(Double one, Double two){ return two.compareTo(one); }
}
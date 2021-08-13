package kompari.integer;

/**
 * <p>Compares two Integer</p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 * 
 * @author Jonatan Gomez Perdomo
 * @version 1.0
 */

public class H2LOrder implements IntOrder {
    /**
     * Determines if the first Integer is greater than the second Integer (one>two)
     * @param one First Integer
     * @param two Second Integer
     * @return (one&gt;two)
     */
    public int compare(Integer one, Integer two){ return (two-one); }
}
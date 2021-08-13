package kompari.large;

public class L2HOrder implements LongOrder {
   /**
     * Determines if the first Long is less than (in some order) the second Long (one<two)
     * @param one First Long
     * @param two Second Long
     * @return (one<two)
     */
    public int compare(Long one, Long two){ return one.compareTo(two); }

}
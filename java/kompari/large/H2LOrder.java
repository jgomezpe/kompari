package kompari.large;

public class H2LOrder implements LongOrder {
   /**
     * Determines if the first Integer is greater than the second Integer (one>two)
     * @param one First Integer
     * @param two Second Integer
     * @return (one>two)
     */
    public int compare(Long one, Long two){ return two.compareTo(one); }
}
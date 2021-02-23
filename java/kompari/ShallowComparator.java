package kompari;

public class ShallowComparator implements Comparator{

    @Override
    public boolean eq(Object one, Object two) {
	return one==two || one.equals(two);
    }
}
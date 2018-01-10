package pluralSight.generics.classAndInterface;

import java.util.Comparator;

/**
 * Created by SaravanaWork on 05-11-2017.
 */
public class ReverseAgeComparator<T> implements Comparator<T> {
    private final Comparator<T> delegateComparator; //Actually doing the reverse thing
    public ReverseAgeComparator(final Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    public int compare(final T left, final T right) {
        return -1* delegateComparator.compare(left, right);
    }
}

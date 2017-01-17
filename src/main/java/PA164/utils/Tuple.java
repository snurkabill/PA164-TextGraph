package PA164.utils;

public class Tuple<T extends Comparable<T>> implements Comparable<Tuple<T>> {

    private final T first;
    private final T second;

    public Tuple(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public int compareTo(Tuple<T> o) {
        if(o.first.compareTo(this.first) == 0) {
            if(o.second.compareTo(this.second) == 0) {
                return 0;
            } else if(o.second.compareTo(this.second) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if(o.first.compareTo(this.first) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tuple)) {
            return false;
        }
        Tuple<?> tuple = (Tuple<?>) o;
        if (getFirst() != null ? !getFirst().equals(tuple.getFirst()) : tuple.getFirst() != null) {
            return false;
        }
        return getSecond() != null ? getSecond().equals(tuple.getSecond()) : tuple.getSecond() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirst() != null ? getFirst().hashCode() : 0;
        result = 31 * result + (getSecond() != null ? getSecond().hashCode() : 0);
        return result;
    }
}

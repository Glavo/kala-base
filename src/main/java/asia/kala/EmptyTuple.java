package asia.kala;

import org.jetbrains.annotations.NotNull;

import java.util.function.IntFunction;

/**
 * A tuple of no elements.
 *
 * @author Glavo
 */
public final class EmptyTuple extends Tuple {

    private static final long serialVersionUID = -6688467811848818630L;

    public static final EmptyTuple INSTANCE = new EmptyTuple();

    private EmptyTuple() {
    }

    @Override
    public final int arity() {
        return 0;
    }

    @Override
    public final <U> U elementAt(int index) {
        throw new IndexOutOfBoundsException("EmptyTuple.elementAt()");
    }

    @NotNull
    @Override
    public final <U> U[] toArray(@NotNull IntFunction<U[]> generator) {
        return generator.apply(0);
    }

    @NotNull
    @Override
    public final <H> Tuple1<H> cons(H head) {
        return new Tuple1<>(head);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        return Tuple.HASH_MAGIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return "()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

package Task_2;

@FunctionalInterface
interface FourNumberOperation<T extends Comparable<T>> {
    T operate(T a, T b, T c, T d);
}

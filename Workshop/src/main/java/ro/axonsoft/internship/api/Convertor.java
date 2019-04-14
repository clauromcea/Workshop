package ro.axonsoft.internship.api;

public interface Convertor<T, R> {
    T convert(R r);
}

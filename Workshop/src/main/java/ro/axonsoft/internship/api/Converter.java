package ro.axonsoft.internship.api;

public interface Converter<T, R> {
    T convert(R r);
}

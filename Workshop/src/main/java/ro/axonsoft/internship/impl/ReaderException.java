package ro.axonsoft.internship.impl;

import java.io.IOException;

public class ReaderException extends IOException {
    public ReaderException() {
        super("Failed to read from file!");
    }
}

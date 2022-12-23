package org.example;

public enum CRTValue {
    HASH("#"),
    DOT(".");

    private final String value;

    CRTValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

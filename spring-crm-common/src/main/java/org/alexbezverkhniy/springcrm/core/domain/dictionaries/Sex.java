package org.alexbezverkhniy.springcrm.core.domain.dictionaries;

public enum Sex {
    MALE(1), FEMALE (0);

    private int value;

    Sex(int value) { this.value = value; }

    public int getValue() { return value; }
}

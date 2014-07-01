package org.alexbezverkhniy.springcrm.core.domain;

public enum AddressType {
    LIVING("LIVING_ADDR"), 
    REGISTRATION("REGISTRATION_ADDR"),
    OUTDATED("OUTDATED_ADDR");
    
    private String value;

    AddressType(String value) { this.value = value; }

    public String getValue() { return value; }
}
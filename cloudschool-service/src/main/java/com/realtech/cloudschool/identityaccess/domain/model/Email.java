package com.realtech.cloudschool.identityaccess.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static java.util.regex.Pattern.matches;

@Embeddable
public final class Email {


    private static final String EMAIL_PATTERN = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    @Column(name = "EMAIL")
    private String address;

    protected Email() {
    }

    public Email(String anAddress) {
        super();
        this.setAddress(anAddress);
    }

    public String getAddress() {
        return this.address;
    }

    private void setAddress(String anAddress) {
        if( anAddress == null ){
            throw new IllegalArgumentException("Email address must not be null.");
        }
        if( anAddress.length() == 0 ){
            throw new IllegalArgumentException("Email address is required.");
        }
        if( anAddress.length() > 150 ){
            throw new IllegalArgumentException("Email address must be 150 characters or less.");
        }
        if( !matches(EMAIL_PATTERN, anAddress)) {
            throw new IllegalArgumentException("Email address format is not valid.");
        }
        this.address = anAddress;
    }
}

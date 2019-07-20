package edu.sunway.pustak.enums;

public enum BookLicense {

    /*types of license*/
    OPEN_SOURCE("OPEN-SOURCE"),
    PROPRIETARY("PROPRIETARY");

    private String license;

    BookLicense(String license) {
        this.license = license;
    }

    public String getLicense() {
        return license;
    }
}

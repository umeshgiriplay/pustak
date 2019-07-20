package edu.sunway.pustak.enums;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER"),
    GUEST("GUEST");

    private String userRole;

    Role(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }
}

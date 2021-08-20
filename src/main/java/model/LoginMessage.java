package model;

import enumerator.EROLE;

/**
 * blaise irakoze
 */
public class LoginMessage extends Message {
    private String names;
    private EROLE role;

    public LoginMessage(String message) {
        super(message);
    }

    public LoginMessage(String message, String names, EROLE role) {
        super(message);
        this.names = names;
        this.role = role;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public EROLE getRole() {
        return role;
    }

    public void setRole(EROLE role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "names='" + names + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

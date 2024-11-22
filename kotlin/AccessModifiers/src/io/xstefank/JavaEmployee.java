package io.xstefank;

public class JavaEmployee {

    private final String firstName;
    private boolean fullTime;

    public JavaEmployee(String firstName) {
        this.firstName = firstName;
        this.fullTime = true;
    }

    public JavaEmployee(String firstName, boolean fullTime) {
        this.firstName = firstName;
        this.fullTime = fullTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }
}

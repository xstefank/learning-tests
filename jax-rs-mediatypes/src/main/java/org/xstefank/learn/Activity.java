package org.xstefank.learn;

public class Activity {
    
    private int i;
    private String s;
    
    public Activity(int i, String s) {
        this.i = i;
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }
}

package org.xstefank.lt.model;

public class ParamDummy {

    private String name;
    private int age;

    public ParamDummy() {
    }

    public ParamDummy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ParamDummy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

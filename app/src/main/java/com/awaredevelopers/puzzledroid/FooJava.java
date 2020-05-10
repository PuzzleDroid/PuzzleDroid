package com.awaredevelopers.puzzledroid;

public class FooJava {

    public enum RANDOMDES {
        DES1,
        DES2,
        DES3,
    }

    private String stringJava;
    private Integer integerJava;
    private Boolean booleanJava;
    private RANDOMDES randomEnum;

    public FooJava() {
    }

    public FooJava(String stringJava, Integer integerJava, Boolean booleanJava, RANDOMDES enumJava) {
        this.stringJava = stringJava;
        this.integerJava = integerJava;
        this.booleanJava = booleanJava;
        this.randomEnum = enumJava;
    }

    public String getStringJava() {
        return stringJava;
    }

    public void setStringJava(String stringJava) {
        this.stringJava = stringJava;
    }

    public Integer getIntegerJava() {
        return integerJava;
    }

    public void setIntegerJava(Integer integerJava) {
        this.integerJava = integerJava;
    }

    public Boolean getBooleanJava() {
        return booleanJava;
    }

    public void setBooleanJava(Boolean booleanJava) {
        this.booleanJava = booleanJava;
    }

    public FooJava.RANDOMDES getRANDOMDES() {
        return randomEnum;
    }

    public void setRANDOMDES(FooJava.RANDOMDES randomEnum) {
        this.randomEnum = randomEnum;
    }

    @Override
    public String toString() {
        return "FooJava{" +
                "stringJava='" + stringJava + '\'' +
                ", integerJava=" + integerJava +
                ", booleanJava=" + booleanJava +
                ", randomEnum=" + randomEnum +
                '}';
    }
}

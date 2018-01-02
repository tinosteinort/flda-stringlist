package com.github.tinosteinort.flda.stringlist.fullexample;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;

public class InterfaceDescription {

    public static final int ATTRIBUTE_COUNT = 4;

    public static final StringListAttribute<String> FIRSTNAME = new StringListAttribute<>(String.class, 0);
    public static final StringListAttribute<String> LASTNAME = new StringListAttribute<>(String.class, 1);
    public static final StringListAttribute<Integer> AGE = new StringListAttribute<>(Integer.class, 2);
    public static final StringListAttribute<Type> TYPE = new StringListAttribute<>(Type.class, 3);

    private InterfaceDescription() {

    }
}

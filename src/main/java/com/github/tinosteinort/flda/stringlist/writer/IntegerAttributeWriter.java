package com.github.tinosteinort.flda.stringlist.writer;

public class IntegerAttributeWriter extends NumberAttributeWriter<Integer> {

    @Override protected String nullSafeConvertToString(final Integer value) {
        return String.valueOf(value);
    }
}

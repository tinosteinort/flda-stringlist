package com.github.tinosteinort.flda.stringlist.writer;

public class DoubleAttributeWriter extends NumberAttributeWriter<Double> {

    @Override protected String nullSafeConvertToString(final Double value) {
        return String.valueOf(value);
    }
}

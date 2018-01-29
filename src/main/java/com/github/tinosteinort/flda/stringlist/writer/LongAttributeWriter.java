package com.github.tinosteinort.flda.stringlist.writer;

public class LongAttributeWriter extends NumberAttributeWriter<Long> {

    @Override protected String nullSafeConvertToString(final Long value) {
        return String.valueOf(value);
    }
}

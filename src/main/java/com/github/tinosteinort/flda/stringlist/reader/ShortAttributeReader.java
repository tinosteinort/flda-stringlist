package com.github.tinosteinort.flda.stringlist.reader;

public class ShortAttributeReader extends NumberAttributeReader<Short> {

    @Override protected Short nullSafeConvertToNumber(final String value) {
        return Short.valueOf(value);
    }
}

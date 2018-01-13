package com.github.tinosteinort.flda.stringlist.reader;

public class ByteAttributeReader extends NumberAttributeReader<Byte> {

    @Override protected Byte nullSafeConvertToNumber(final String value) {
        return Byte.valueOf(value);
    }
}

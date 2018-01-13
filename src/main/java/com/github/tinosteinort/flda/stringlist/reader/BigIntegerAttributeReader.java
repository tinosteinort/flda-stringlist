package com.github.tinosteinort.flda.stringlist.reader;

import java.math.BigInteger;

public class BigIntegerAttributeReader extends NumberAttributeReader<BigInteger> {

    @Override protected BigInteger nullSafeConvertToNumber(final String value) {
        return new BigInteger(value);
    }
}

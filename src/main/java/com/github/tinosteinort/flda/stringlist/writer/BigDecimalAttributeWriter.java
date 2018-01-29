package com.github.tinosteinort.flda.stringlist.writer;

import java.math.BigDecimal;

public class BigDecimalAttributeWriter extends NumberAttributeWriter<BigDecimal> {

    @Override protected String nullSafeConvertToString(final BigDecimal value) {
        return String.valueOf(value);
    }
}

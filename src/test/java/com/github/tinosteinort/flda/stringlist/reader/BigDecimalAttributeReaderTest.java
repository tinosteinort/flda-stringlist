package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BigDecimalAttributeReaderTest {

    private final BigDecimalAttributeReader reader = new BigDecimalAttributeReader();

    @Test public void bigValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        final StringListAttribute<BigDecimal> attribute = new StringListAttribute<>(BigDecimal.class, 0);

        assertEquals(new BigDecimal("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"), reader.read(record, attribute));
    }

    @Test public void nullValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("     ");
        final StringListAttribute<BigDecimal> attribute = new StringListAttribute<>(BigDecimal.class, 0);

        assertNull(reader.read(record, attribute));
    }
}

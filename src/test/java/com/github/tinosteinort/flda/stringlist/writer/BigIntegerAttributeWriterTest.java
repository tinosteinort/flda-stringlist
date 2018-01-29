package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BigIntegerAttributeWriterTest {

    private final BigIntegerAttributeWriter writer = new BigIntegerAttributeWriter();

    @Test public void writeBigValue() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<BigInteger> attribute = new StringListAttribute<>(BigInteger.class, 0);

        writer.write(record, attribute, new BigInteger("999999999999999999999999999999999999999999999999"));

        assertEquals("999999999999999999999999999999999999999999999999", record.get(0));
    }

    @Test public void writeNull() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<BigInteger> attribute = new StringListAttribute<>(BigInteger.class, 0);

        writer.write(record, attribute, null);

        assertNull(record.get(0));
    }
}

package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BigIntegerAttributeReaderTest {

    private final BigIntegerAttributeReader reader = new BigIntegerAttributeReader();

    @Test public void bigValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("999999999999999999999999999999999999999999999999");
        final StringListAttribute<BigInteger> attribute = new StringListAttribute<>(BigInteger.class, 0);

        assertEquals(new BigInteger("999999999999999999999999999999999999999999999999"), reader.read(record, attribute));
    }

    @Test public void nullValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("     ");
        final StringListAttribute<BigInteger> attribute = new StringListAttribute<>(BigInteger.class, 0);

        assertNull(reader.read(record, attribute));
    }
}

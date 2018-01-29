package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IntegerAttributeWriterTest {

    private final IntegerAttributeWriter writer = new IntegerAttributeWriter();

    @Test public void writeMin() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Integer> attribute = new StringListAttribute<>(Integer.class, 0);

        writer.write(record, attribute, -2147483648);

        assertEquals("-2147483648", record.get(0));
    }

    @Test public void writeMax() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Integer> attribute = new StringListAttribute<>(Integer.class, 0);

        writer.write(record, attribute, 2147483647);

        assertEquals("2147483647", record.get(0));
    }

    @Test public void writeValue() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Integer> attribute = new StringListAttribute<>(Integer.class, 0);

        writer.write(record, attribute, 123);

        assertEquals("123", record.get(0));
    }

    @Test public void writeNullValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("SomeValue");
        final StringListAttribute<Integer> attribute = new StringListAttribute<>(Integer.class, 0);

        writer.write(record, attribute, null);

        assertNull(record.get(0));
    }
}

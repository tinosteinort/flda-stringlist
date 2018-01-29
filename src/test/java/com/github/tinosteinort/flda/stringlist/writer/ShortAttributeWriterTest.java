package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ShortAttributeWriterTest {

    private final ShortAttributeWriter writer = new ShortAttributeWriter();

    @Test public void writeMin() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Short> attribute = new StringListAttribute<>(Short.class, 0);

        writer.write(record, attribute, (short) -32768);

        assertEquals("-32768", record.get(0));
    }

    @Test public void writeMax() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Short> attribute = new StringListAttribute<>(Short.class, 0);

        writer.write(record, attribute, (short) 32767);

        assertEquals("32767", record.get(0));
    }

    @Test public void writeNull() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Short> attribute = new StringListAttribute<>(Short.class, 0);

        writer.write(record, attribute, null);

        assertNull(record.get(0));
    }
}

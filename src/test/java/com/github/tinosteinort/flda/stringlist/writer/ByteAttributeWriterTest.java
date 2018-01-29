package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ByteAttributeWriterTest {

    private final ByteAttributeWriter writer = new ByteAttributeWriter();

    @Test public void writeMin() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Byte> attribute = new StringListAttribute<>(Byte.class, 0);

        writer.write(record, attribute, (byte) -128);

        assertEquals("-128", record.get(0));
    }

    @Test public void writeMax() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Byte> attribute = new StringListAttribute<>(Byte.class, 0);

        writer.write(record, attribute, (byte) 127);

        assertEquals("127", record.get(0));
    }

    @Test public void writeNull() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Byte> attribute = new StringListAttribute<>(Byte.class, 0);

        writer.write(record, attribute, null);

        assertNull(record.get(0));
    }
}

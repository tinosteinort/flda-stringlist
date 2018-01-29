package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FloatAttributeWriterTest {

    private final FloatAttributeWriter writer = new FloatAttributeWriter();

    @Test public void writeMin() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Float> attribute = new StringListAttribute<>(Float.class, 0);

        writer.write(record, attribute, 0x0.000002P-126f);

        assertEquals("1.4E-45", record.get(0));
    }

    @Test public void writeMinNormal() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Float> attribute = new StringListAttribute<>(Float.class, 0);

        writer.write(record, attribute, 0x1.0p-126f);

        assertEquals("1.17549435E-38", record.get(0));
    }

    @Test public void writeMax() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Float> attribute = new StringListAttribute<>(Float.class, 0);

        writer.write(record, attribute, 0x1.fffffeP+127f);

        assertEquals("3.4028235E38", record.get(0));
    }

    @Test public void writeNull() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Float> attribute = new StringListAttribute<>(Float.class, 0);

        writer.write(record, attribute, null);

        assertNull(record.get(0));
    }
}

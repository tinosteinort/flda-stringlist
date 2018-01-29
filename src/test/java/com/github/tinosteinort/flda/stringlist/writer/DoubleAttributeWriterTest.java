package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DoubleAttributeWriterTest {

    private final DoubleAttributeWriter writer = new DoubleAttributeWriter();

    @Test public void writeMin() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Double> attribute = new StringListAttribute<>(Double.class, 0);

        writer.write(record, attribute, 0x0.0000000000001P-1022);

        assertEquals("4.9E-324", record.get(0));
    }

    @Test public void writeMinNormal() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Double> attribute = new StringListAttribute<>(Double.class, 0);

        writer.write(record, attribute, 0x1.0p-1022);

        assertEquals("2.2250738585072014E-308", record.get(0));
    }

    @Test public void writeMax() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Double> attribute = new StringListAttribute<>(Double.class, 0);

        writer.write(record, attribute, 0x1.fffffffffffffP+1023);

        assertEquals("1.7976931348623157E308", record.get(0));
    }

    @Test public void writeNull() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Double> attribute = new StringListAttribute<>(Double.class, 0);

        writer.write(record, attribute, null);

        assertNull(record.get(0));
    }
}

package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FloatAttributeReaderTest {

    private final FloatAttributeReader reader = new FloatAttributeReader();

    @Test public void minValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("1.4e-45f");
        final StringListAttribute<Float> attribute = new StringListAttribute<>(Float.class, 0);

        assertEquals((Float) 0x0.000002P-126f, reader.read(record, attribute));
    }

    @Test public void minNormalValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("1.17549435E-38f");
        final StringListAttribute<Float> attribute = new StringListAttribute<>(Float.class, 0);

        assertEquals((Float) 0x1.0p-126f, reader.read(record, attribute));
    }

    @Test public void maxValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("3.4028235e+38f");
        final StringListAttribute<Float> attribute = new StringListAttribute<>(Float.class, 0);

        assertEquals((Float) 0x1.fffffeP+127f, reader.read(record, attribute));
    }

    @Test public void nullValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("     ");
        final StringListAttribute<Float> attribute = new StringListAttribute<>(Float.class, 0);

        assertNull(reader.read(record, attribute));
    }
}

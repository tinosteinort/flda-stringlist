package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DoubleAttributeReaderTest {

    private final DoubleAttributeReader reader = new DoubleAttributeReader();

    @Test public void minValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("4.9e-324");
        final StringListAttribute<Double> attribute = new StringListAttribute<>(Double.class, 0);

        assertEquals((Double) 0x0.0000000000001P-1022, reader.read(record, attribute));
    }

    @Test public void minNormalValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("2.2250738585072014E-308");
        final StringListAttribute<Double> attribute = new StringListAttribute<>(Double.class, 0);

        assertEquals((Double) 0x1.0p-1022, reader.read(record, attribute));
    }

    @Test public void maxValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("1.7976931348623157e+308");
        final StringListAttribute<Double> attribute = new StringListAttribute<>(Double.class, 0);

        assertEquals((Double) 0x1.fffffffffffffP+1023, reader.read(record, attribute));
    }

    @Test public void nullValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("     ");
        final StringListAttribute<Double> attribute = new StringListAttribute<>(Double.class, 0);

        assertNull(reader.read(record, attribute));
    }
}

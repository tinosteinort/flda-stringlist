package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ByteAttributeReaderTest {

    private final ByteAttributeReader reader = new ByteAttributeReader();

    @Test public void minValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("-128");
        final StringListAttribute<Byte> attribute = new StringListAttribute<>(Byte.class, 0);

        final Byte result = reader.read(record, attribute);
        assertEquals(-128, (int) result);
    }

    @Test public void maxValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("127");
        final StringListAttribute<Byte> attribute = new StringListAttribute<>(Byte.class, 0);

        final Byte result = reader.read(record, attribute);
        assertEquals(127, (int) result);
    }

    @Test public void nullValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("     ");
        final StringListAttribute<Byte> attribute = new StringListAttribute<>(Byte.class, 0);

        assertNull(reader.read(record, attribute));
    }

    @Test(expected = NumberFormatException.class)
    public void valueOutOfBounds() {
        final List<String> record = new ArrayList<>(1);
        record.add("128");
        final StringListAttribute<Byte> attribute = new StringListAttribute<>(Byte.class, 0);

        reader.read(record, attribute);
    }
}

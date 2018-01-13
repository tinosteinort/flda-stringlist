package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ShortAttributeReaderTest {

    private final ShortAttributeReader reader = new ShortAttributeReader();

    @Test public void readValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("123");
        final StringListAttribute<Short> attribute = new StringListAttribute<>(Short.class, 0);

        assertEquals(123, (short) reader.read(record, attribute));
    }

    @Test public void readNullValue() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Short> attribute = new StringListAttribute<>(Short.class, 0);

        assertNull(reader.read(record, attribute));
    }
}

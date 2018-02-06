package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BooleanAttributeReaderTest {

    private final BooleanAttributeReader reader = new BooleanAttributeReader();

    @Test public void readTrue() {
        final List<String> record = new ArrayList<>(1);
        record.add("true");
        final StringListAttribute<Boolean> attribute = new StringListAttribute<>(Boolean.class, 0);

        assertTrue(reader.read(record, attribute));
    }

    @Test public void readFalse() {
        final List<String> record = new ArrayList<>(1);
        record.add("false");
        final StringListAttribute<Boolean> attribute = new StringListAttribute<>(Boolean.class, 0);

        assertFalse(reader.read(record, attribute));
    }

    @Test public void readOtherFalseValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("other");
        final StringListAttribute<Boolean> attribute = new StringListAttribute<>(Boolean.class, 0);

        assertFalse(reader.read(record, attribute));
    }

    @Test public void readNullValue() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Boolean> attribute = new StringListAttribute<>(Boolean.class, 0);

        assertNull(reader.read(record, attribute));
    }
}

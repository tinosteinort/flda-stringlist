package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BooleanAttributeWriterTest {

    private final BooleanAttributeWriter writer = new BooleanAttributeWriter();

    @Test public void writeTrue() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Boolean> attribute = new StringListAttribute<>(Boolean.class, 0);

        writer.write(record, attribute, true);

        assertEquals("true", record.get(0));
    }

    @Test public void writeFalse() {
        final List<String> record = new ArrayList<>(1);
        record.add(null);
        final StringListAttribute<Boolean> attribute = new StringListAttribute<>(Boolean.class, 0);

        writer.write(record, attribute, false);

        assertEquals("false", record.get(0));
    }

    @Test public void writeNullValue() {
        final List<String> record = new ArrayList<>(1);
        record.add("SomeValue");
        final StringListAttribute<Boolean> attribute = new StringListAttribute<>(Boolean.class, 0);

        writer.write(record, attribute, null);

        assertNull(record.get(0));
    }
}

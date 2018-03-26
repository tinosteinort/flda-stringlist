package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.accessor.AttributeWriter;
import com.github.tinosteinort.flda.stringlist.StringListAttribute;

import java.util.List;

public class BooleanAttributeWriter implements AttributeWriter<List<String>, Boolean, StringListAttribute<Boolean>> {

    @Override public void write(final List<String> record, final StringListAttribute<Boolean> attribute,
                                final Boolean value) {
        final String s = (value == null ? null : String.valueOf(value));
        record.set(attribute.getIndex(), s);
    }
}

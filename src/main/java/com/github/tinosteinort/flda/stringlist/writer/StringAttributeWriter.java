package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.accessor.AttributeWriter;
import com.github.tinosteinort.flda.stringlist.StringListAttribute;

import java.util.List;

public class StringAttributeWriter implements AttributeWriter<List<String>, String, StringListAttribute<String>> {

    @Override public void write(final List<String> record, final StringListAttribute<String> attribute, final String value) {
        record.set(attribute.getIndex(), value);
    }
}

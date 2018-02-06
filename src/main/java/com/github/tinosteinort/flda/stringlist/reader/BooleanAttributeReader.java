package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.accessor.reader.AttributeReader;
import com.github.tinosteinort.flda.stringlist.StringListAttribute;

import java.util.List;

public class BooleanAttributeReader implements AttributeReader<List<String>, Boolean, StringListAttribute<Boolean>> {

    @Override public Boolean read(final List<String> record, final StringListAttribute<Boolean> attribute) {
        final String value = record.get(attribute.getIndex());
        if (value == null) {
            return null;
        }
        return Boolean.valueOf(value);
    }
}

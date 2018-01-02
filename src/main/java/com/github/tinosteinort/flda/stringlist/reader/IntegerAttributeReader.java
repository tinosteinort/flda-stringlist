package com.github.tinosteinort.flda.stringlist.reader;


import com.github.tinosteinort.flda.accessor.reader.AttributeReader;
import com.github.tinosteinort.flda.stringlist.StringListAttribute;

import java.util.List;

public class IntegerAttributeReader implements AttributeReader<List<String>, Integer, StringListAttribute<Integer>> {

    @Override public Integer read(final List<String> record, final StringListAttribute<Integer> attribute) {
        final String value = record.get(attribute.getIndex());
        if (value == null || "".equals(value.trim())) {
            return null;
        }
        return Integer.valueOf(value);
    }
}

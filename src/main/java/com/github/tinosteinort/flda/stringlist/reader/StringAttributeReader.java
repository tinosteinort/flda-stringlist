package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.accessor.AttributeReader;
import com.github.tinosteinort.flda.stringlist.StringListAttribute;

import java.util.List;

public class StringAttributeReader implements AttributeReader<List<String>, String, StringListAttribute<String>> {

    @Override public String read(final List<String> record, final StringListAttribute<String> attribute) {
        return record.get(attribute.getIndex());
    }
}

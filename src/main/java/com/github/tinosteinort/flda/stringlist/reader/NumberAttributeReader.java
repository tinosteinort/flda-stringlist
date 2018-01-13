package com.github.tinosteinort.flda.stringlist.reader;

import com.github.tinosteinort.flda.accessor.reader.AttributeReader;
import com.github.tinosteinort.flda.stringlist.StringListAttribute;

import java.util.List;

public abstract class NumberAttributeReader<T extends Number>
        implements AttributeReader<List<String>, T, StringListAttribute<T>> {

    @Override public T read(final List<String> record, final StringListAttribute<T> attribute) {
        final String value = record.get(attribute.getIndex());
        return convertToNumber(value);
    }

    protected T convertToNumber(final String value) {
        if (value == null || "".equals(value.trim())) {
            return null;
        }
        return nullSafeConvertToNumber(value);
    }

    protected abstract T nullSafeConvertToNumber(final String value);
}

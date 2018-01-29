package com.github.tinosteinort.flda.stringlist.writer;

import com.github.tinosteinort.flda.accessor.writer.AttributeWriter;
import com.github.tinosteinort.flda.stringlist.StringListAttribute;

import java.util.List;

public abstract class NumberAttributeWriter<T extends Number>
        implements AttributeWriter<List<String>, T, StringListAttribute<T>> {

    @Override public void write(final List<String> record, final StringListAttribute<T> attribute,
                                final T value) {

        final String newValue = convertToString(value);
        record.set(attribute.getIndex(), newValue);
    }

    protected String convertToString(final T value) {
        if (value == null) {
            return null;
        }
        return nullSafeConvertToString(value);
    }

    protected abstract String nullSafeConvertToString(final T value);
}

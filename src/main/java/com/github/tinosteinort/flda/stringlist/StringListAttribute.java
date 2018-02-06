package com.github.tinosteinort.flda.stringlist;

import com.github.tinosteinort.flda.accessor.Attribute;

public class StringListAttribute<T> implements Attribute<T> {

    private final Class<T> type;
    private final int index;

    public StringListAttribute(final Class<T> type, final int index) {
        this.type = type;
        this.index = index;
    }

    @Override public Class<T> getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringListAttribute<?> that = (StringListAttribute<?>) o;

        if (index != that.index) return false;
        return type != null ? type.equals(that.type) : that.type == null;
    }

    @Override public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + index;
        return result;
    }
}

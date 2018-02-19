package com.github.tinosteinort.flda.stringlist;

import com.github.tinosteinort.flda.accessor.AccessorConfig;
import com.github.tinosteinort.flda.accessor.reader.ReadAccessor;
import com.github.tinosteinort.flda.accessor.writer.WriteAccessor;

import java.util.List;

/**
 * Accessor configuration class of FLDA for records of type {@code List<String>}.
 */
public interface StringListAccessorConfig extends AccessorConfig<List<String>, StringListAttribute<?>> {

    /**
     * Creates a new {@link ReadAccessor} for the given record.
     *
     * @param record to read from
     * @return a new {@code ReadAccessor} for the record.
     */
    ReadAccessor<List<String>, StringListAttribute<?>> newReadAccessor(final List<String> record);

    /**
     * Creates a new {@link WriteAccessor} for the given record.
     *
     * @param record to write to
     * @return a new {@code WriteAccessor} for the record.
     */
    WriteAccessor<List<String>, StringListAttribute<?>> newWriteAccessor(final List<String> record);
}

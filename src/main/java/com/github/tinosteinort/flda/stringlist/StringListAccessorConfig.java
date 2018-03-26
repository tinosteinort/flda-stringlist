package com.github.tinosteinort.flda.stringlist;

import com.github.tinosteinort.flda.accessor.AccessorConfig;
import com.github.tinosteinort.flda.accessor.Attribute;
import com.github.tinosteinort.flda.accessor.AttributeReader;
import com.github.tinosteinort.flda.accessor.AttributeWriter;
import com.github.tinosteinort.flda.accessor.RecordFactory;
import com.github.tinosteinort.flda.accessor.RecordValidator;

import java.util.List;
import java.util.Map;

/**
 * Accessor configuration class of FLDA for records of type {@code List<String>}.
 */
public abstract class StringListAccessorConfig extends AccessorConfig<List<String>, StringListAttribute<?>> {

    StringListAccessorConfig(
            final Map<Class<?>, AttributeReader<List<String>, ?, ? extends Attribute<?>>> readersByType,
            final Map<Class<?>, AttributeWriter<List<String>, ?, ? extends Attribute<?>>> writersByType,
            final Map<StringListAttribute<?>, AttributeReader<List<String>, ?, ? extends Attribute<?>>> readersByAttribute,
            final Map<StringListAttribute<?>, AttributeWriter<List<String>, ?, ? extends Attribute<?>>> writersByAttribute,
            final RecordFactory<List<String>> recordFactory,
            final RecordValidator<List<String>> readValidator,
            final RecordValidator<List<String>> writeValidator) {

        super(readersByType, writersByType, readersByAttribute, writersByAttribute, recordFactory, readValidator,
                writeValidator);
    }
}

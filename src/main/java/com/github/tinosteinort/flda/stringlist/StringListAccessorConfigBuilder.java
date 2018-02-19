package com.github.tinosteinort.flda.stringlist;

import com.github.tinosteinort.flda.accessor.AccessorConfig;
import com.github.tinosteinort.flda.accessor.AccessorConfigBuilder;
import com.github.tinosteinort.flda.accessor.Attribute;
import com.github.tinosteinort.flda.accessor.RecordValidator;
import com.github.tinosteinort.flda.accessor.reader.AttributeReader;
import com.github.tinosteinort.flda.accessor.writer.AttributeWriter;
import com.github.tinosteinort.flda.stringlist.reader.BigDecimalAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.BigIntegerAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.BooleanAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.ByteAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.DoubleAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.FloatAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.IntegerAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.LongAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.ShortAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.StringAttributeReader;
import com.github.tinosteinort.flda.stringlist.writer.BigDecimalAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.BigIntegerAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.BooleanAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.ByteAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.DoubleAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.FloatAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.IntegerAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.LongAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.ShortAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.StringAttributeWriter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * AccessorConfigBuilder for {@link StringListAttribute}.
 *
 *  To read and write Enums, custom reader/writer with the specific type has to be registered:
 *  <pre>
 *      ...
 *      .registerReader(EnumType.class, new EnumAttributeReader<>(EnumType.class))
 *      .registerWriter(EnumType.class, new EnumAttributeWriter<>())
 *      ...
 *  </pre>
 */
public class StringListAccessorConfigBuilder extends AccessorConfigBuilder<List<String>, StringListAttribute<?>> {

    public StringListAccessorConfigBuilder() {

    }

    public StringListAccessorConfigBuilder(
            final AccessorConfig<List<String>, StringListAttribute<?>> baseConfig) {
        super(baseConfig);
    }

    /**
     * Registers the build in readers for types:
     *  <ul>
     *      <li>String</li>
     *      <li>Boolean</li>
     *      <li>Byte</li>
     *      <li>Short</li>
     *      <li>Integer</li>
     *      <li>Long</li>
     *      <li>Float</li>
     *      <li>Double</li>
     *      <li>BigInteger</li>
     *      <li>BigDecimal</li>
     *  </ul>
     *
     * @return the Builder for method chaining
     */
    public StringListAccessorConfigBuilder withDefaultReaders() {
        registerReader(String.class, new StringAttributeReader());
        registerReader(Boolean.class, new BooleanAttributeReader());
        registerReader(Byte.class, new ByteAttributeReader());
        registerReader(Short.class, new ShortAttributeReader());
        registerReader(Integer.class, new IntegerAttributeReader());
        registerReader(Long.class, new LongAttributeReader());
        registerReader(Float.class, new FloatAttributeReader());
        registerReader(Double.class, new DoubleAttributeReader());
        registerReader(BigInteger.class, new BigIntegerAttributeReader());
        registerReader(BigDecimal.class, new BigDecimalAttributeReader());
        return this;
    }

    /**
     * Registers the build in writers for types:
     *  <ul>
     *      <li>String</li>
     *      <li>Boolean</li>
     *      <li>Byte</li>
     *      <li>Short</li>
     *      <li>Integer</li>
     *      <li>Long</li>
     *      <li>Float</li>
     *      <li>Double</li>
     *      <li>BigInteger</li>
     *      <li>BigDecimal</li>
     *  </ul>
     *
     * @return the Builder for method chaining
     */
    public StringListAccessorConfigBuilder withDefaultWriters() {
        registerWriter(String.class, new StringAttributeWriter());
        registerWriter(Boolean.class, new BooleanAttributeWriter());
        registerWriter(Byte.class, new ByteAttributeWriter());
        registerWriter(Short.class, new ShortAttributeWriter());
        registerWriter(Integer.class, new IntegerAttributeWriter());
        registerWriter(Long.class, new LongAttributeWriter());
        registerWriter(Float.class, new FloatAttributeWriter());
        registerWriter(Double.class, new DoubleAttributeWriter());
        registerWriter(BigInteger.class, new BigIntegerAttributeWriter());
        registerWriter(BigDecimal.class, new BigDecimalAttributeWriter());
        return this;
    }

    @Override public <T> StringListAccessorConfigBuilder registerReader(
            final Class<T> type, AttributeReader<List<String>, T, ? extends Attribute<T>> reader) {
        return (StringListAccessorConfigBuilder) super.registerReader(type, reader);
    }

    @Override public <T> StringListAccessorConfigBuilder registerWriter(
            final Class<T> type, AttributeWriter<List<String>, T, ? extends Attribute<T>> writer) {
        return (StringListAccessorConfigBuilder) super.registerWriter(type, writer);
    }

    @Override public <T> StringListAccessorConfigBuilder registerReader(
            final StringListAttribute<?> attribute, AttributeReader<List<String>, T, ? extends Attribute<T>> reader) {
        return (StringListAccessorConfigBuilder) super.registerReader(attribute, reader);
    }

    @Override public <T> StringListAccessorConfigBuilder registerWriter(
            final StringListAttribute<?> attribute,
            final AttributeWriter<List<String>, T, ? extends Attribute<T>> writer) {
        return (StringListAccessorConfigBuilder) super.registerWriter(attribute, writer);
    }

    @Override public StringListAccessorConfigBuilder withRecordFactory(final Supplier<List<String>> recordFactory) {
        return (StringListAccessorConfigBuilder) super.withRecordFactory(recordFactory);
    }

    @Override public StringListAccessorConfigBuilder withReadValidator(final RecordValidator<List<String>> validator) {
        return (StringListAccessorConfigBuilder) super.withReadValidator(validator);
    }

    @Override public StringListAccessorConfigBuilder withWriteValidator(final RecordValidator<List<String>> validator) {
        return (StringListAccessorConfigBuilder) super.withWriteValidator(validator);
    }

    @Override public StringListAccessorConfig build() {

        final AccessorConfig<List<String>, StringListAttribute<?>> innerConfig = super.build();

        return new StringListAccessorConfig() {
            @Override public <ATTR_TYPE> AttributeReader<List<String>, ATTR_TYPE, StringListAttribute<?>> readerFor(
                    final StringListAttribute<?> attribute) {
                return innerConfig.readerFor(attribute);
            }

            @Override public <ATTR_TYPE> AttributeWriter<List<String>, ATTR_TYPE, StringListAttribute<?>> writerFor(
                    final StringListAttribute<?> attribute) {
                return innerConfig.writerFor(attribute);
            }

            @Override public List<String> createNewRecord() {
                return innerConfig.createNewRecord();
            }

            @Override public void validateForRead(final List<String> record) {
                innerConfig.validateForRead(record);
            }

            @Override public void validateForWrite(final List<String> record) {
                innerConfig.validateForWrite(record);
            }

            @Override public Map<Class<?>, AttributeReader<List<String>, ?, ? extends Attribute<?>>> readers() {
                return innerConfig.readers();
            }

            @Override public Map<Class<?>, AttributeWriter<List<String>, ?, ? extends Attribute<?>>> writers() {
                return innerConfig.writers();
            }

            @Override public Supplier<List<String>> recordFactory() {
                return innerConfig.recordFactory();
            }

            @Override public RecordValidator<List<String>> readValidator() {
                return innerConfig.readValidator();
            }

            @Override public RecordValidator<List<String>> writeValidator() {
                return innerConfig.writeValidator();
            }
        };
    }
}

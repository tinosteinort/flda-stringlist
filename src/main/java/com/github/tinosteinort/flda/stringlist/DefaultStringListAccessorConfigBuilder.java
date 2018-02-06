package com.github.tinosteinort.flda.stringlist;

import com.github.tinosteinort.flda.accessor.AccessorConfigBuilder;
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

/**
 * Default AccessorConfigBuilder for {@link StringListAttribute}. Readers and writers for
 *  types
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
 *  are registered by default.<br/><br/>
 *
 *  To read and write Enums, custom reader/writer with the specific type has to be registed:
 *  <pre>
 *      ...
 *      .registerReader(EnumType.class, new EnumAttributeReader<>(EnumType.class))
 *      .registerWriter(EnumType.class, new EnumAttributeWriter<>())
 *      ...
 *  </pre>
 */
public class DefaultStringListAccessorConfigBuilder
        extends AccessorConfigBuilder<List<String>, StringListAttribute<?>> {

    public DefaultStringListAccessorConfigBuilder() {
        registerBuildInReader();
        registerBuildInWriter();
    }

    private void registerBuildInReader() {
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
    }

    private void registerBuildInWriter() {
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
    }
}

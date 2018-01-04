package com.github.tinosteinort.flda.stringlist.fullexample;

import com.github.tinosteinort.flda.accessor.AccessorConfig;
import com.github.tinosteinort.flda.accessor.AccessorConfigBuilder;
import com.github.tinosteinort.flda.accessor.reader.ReadAccessor;
import com.github.tinosteinort.flda.accessor.writer.WriteAccessor;
import com.github.tinosteinort.flda.stringlist.SizeValidator;
import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import com.github.tinosteinort.flda.stringlist.StringListFactory;
import com.github.tinosteinort.flda.stringlist.reader.EnumAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.IntegerAttributeReader;
import com.github.tinosteinort.flda.stringlist.reader.StringAttributeReader;
import com.github.tinosteinort.flda.stringlist.writer.EnumAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.IntegerAttributeWriter;
import com.github.tinosteinort.flda.stringlist.writer.StringAttributeWriter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StringListInterfaceTest {

    private final SizeValidator validator = new SizeValidator(InterfaceDescription.ATTRIBUTE_COUNT);

    private final AccessorConfig<List<String>, StringListAttribute<?>> config =
            new AccessorConfigBuilder<List<String>, StringListAttribute<?>>()
                    .registerReader(String.class, new StringAttributeReader())
                    .registerReader(Integer.class, new IntegerAttributeReader())
                    .registerReader(Type.class, new EnumAttributeReader<>(Type.class))
                    .registerWriter(String.class, new StringAttributeWriter())
                    .registerWriter(Integer.class, new IntegerAttributeWriter())
                    .registerWriter(Type.class, new EnumAttributeWriter<>())
                    .withRecordFactory(new StringListFactory(InterfaceDescription.ATTRIBUTE_COUNT))
                    .withReadValidator(validator)
                    .withWriteValidator(validator)
                    .build();

    @Test public void readExample() {

        final String lineFromFile = "Donnie;Doe;7;RABBIT";

        // Convert line to Record Type
        final List<String> record = Arrays.asList(lineFromFile.split(";"));

        final ReadAccessor<List<String>, StringListAttribute<?>> readAccessor = new ReadAccessor<>(config, record);

        assertEquals("Donnie", readAccessor.read(InterfaceDescription.FIRSTNAME));
        assertEquals("Doe", readAccessor.read(InterfaceDescription.LASTNAME));
        assertEquals(7, (int) readAccessor.read(InterfaceDescription.AGE));
        assertEquals(Type.RABBIT, readAccessor.read(InterfaceDescription.TYPE));
    }

    @Test public void writeExample() {

        final List<String> record = config.createNewRecord();

        final WriteAccessor<List<String>, StringListAttribute<?>> writeAccessor = new WriteAccessor<>(config, record);

        writeAccessor.write(InterfaceDescription.FIRSTNAME, "Bimmel");
        writeAccessor.write(InterfaceDescription.LASTNAME, "Bammel");
        writeAccessor.write(InterfaceDescription.AGE, 500);
        writeAccessor.write(InterfaceDescription.TYPE, Type.HUMAN);

        // Convert Record to String
        final String recordAsString = record
                .stream()
                .collect(Collectors.joining(";"));

        assertEquals("Bimmel;Bammel;500;HUMAN", recordAsString);
    }
}
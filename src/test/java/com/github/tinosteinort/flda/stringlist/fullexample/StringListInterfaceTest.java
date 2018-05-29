package com.github.tinosteinort.flda.stringlist.fullexample;

import com.github.tinosteinort.flda.accessor.ReadAccessor;
import com.github.tinosteinort.flda.accessor.WriteAccessor;
import com.github.tinosteinort.flda.stringlist.SizeValidator;
import com.github.tinosteinort.flda.stringlist.StringListAccessorConfig;
import com.github.tinosteinort.flda.stringlist.StringListAccessorConfigBuilder;
import com.github.tinosteinort.flda.stringlist.StringListAttribute;
import com.github.tinosteinort.flda.stringlist.StringListFactory;
import com.github.tinosteinort.flda.stringlist.reader.EnumAttributeReader;
import com.github.tinosteinort.flda.stringlist.writer.EnumAttributeWriter;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringListInterfaceTest {

    private static final int ATTRIBUTE_COUNT = 4;
    private static final StringListAttribute<String> FIRSTNAME = new StringListAttribute<>(String.class, 0);
    private static final StringListAttribute<String> LASTNAME = new StringListAttribute<>(String.class, 1);
    private static final StringListAttribute<Integer> AGE = new StringListAttribute<>(Integer.class, 2);
    private static final StringListAttribute<Type> TYPE = new StringListAttribute<>(Type.class, 3);

    private final SizeValidator validator = new SizeValidator(ATTRIBUTE_COUNT);

    private final StringListAccessorConfig config = new StringListAccessorConfigBuilder()
                    .withDefaultReaders()
                    .withDefaultWriters()
                    .registerReader(Type.class, new EnumAttributeReader<>(Type.class))
                    .registerWriter(Type.class, new EnumAttributeWriter<>())
                    .withRecordFactory(new StringListFactory(ATTRIBUTE_COUNT))
                    .withReadValidator(validator)
                    .withWriteValidator(validator)
                    .build();

    @Test public void readExample() {

        final List<String> record = Arrays.asList("Donnie", "Doe", "7", "RABBIT");

        final ReadAccessor<List<String>, StringListAttribute<?>> readAccessor = config.newReadAccessor(record);

        assertEquals("Donnie", readAccessor.read(FIRSTNAME));
        assertEquals("Doe", readAccessor.read(LASTNAME));
        assertEquals(7, (int) readAccessor.read(AGE));
        assertEquals(Type.RABBIT, readAccessor.read(TYPE));
    }

    @Test public void writeExample() {

        final List<String> record = config.createNewRecord();

        final WriteAccessor<List<String>, StringListAttribute<?>> writeAccessor = config.newWriteAccessor(record);

        writeAccessor.write(FIRSTNAME, "Bimmel");
        writeAccessor.write(LASTNAME, "Bammel");
        writeAccessor.write(AGE, 500);
        writeAccessor.write(TYPE, Type.HUMAN);

        assertEquals(
                Arrays.asList("Bimmel","Bammel","500","HUMAN"),
                record);
    }
}

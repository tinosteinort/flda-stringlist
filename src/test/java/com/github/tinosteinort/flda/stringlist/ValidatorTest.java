package com.github.tinosteinort.flda.stringlist;

import com.github.tinosteinort.flda.accessor.ReadAccessor;
import com.github.tinosteinort.flda.accessor.WriteAccessor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {

    private final SizeValidator readValidator = new SizeValidator(5);
    private final SizeValidator writeValidator = new SizeValidator(5);

    private final StringListAccessorConfig config = new StringListAccessorConfigBuilder()
                    .withReadValidator(readValidator)
                    .withWriteValidator(writeValidator)
                    .build();

    private List<String> newRecord(final int size) {
        final List<String> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(null);
        }
        return list;
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateRead() {

        final List<String> data = newRecord(4);
        new ReadAccessor<>(config, data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWrite() {

        final List<String> data = newRecord(6);
        new WriteAccessor<>(config, data);
    }

    @Test public void nullValidators() {
        final StringListAccessorConfig config = new StringListAccessorConfigBuilder()
                        .withReadValidator(null)
                        .withWriteValidator(null)
                        .build();

        final List<String> data = newRecord(5);

        new ReadAccessor<>(config, data);
        new WriteAccessor<>(config, data);
    }
}

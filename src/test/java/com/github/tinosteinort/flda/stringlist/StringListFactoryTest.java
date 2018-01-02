package com.github.tinosteinort.flda.stringlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StringListFactoryTest {

    @Test public void createEmptyList() {

        final StringListFactory factory = new StringListFactory(0);
        final List<String> list = factory.get();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.isEmpty());
    }

    @Test public void createWithMoreElements() {

        final StringListFactory factory = new StringListFactory(4);
        final List<String> list = factory.get();
        Assert.assertNotNull(list);
        Assert.assertEquals(4, list.size());
        Assert.assertNull(list.get(0));
        Assert.assertNull(list.get(1));
        Assert.assertNull(list.get(2));
        Assert.assertNull(list.get(3));
    }

    @Test(expected = IllegalArgumentException.class) public void createWithNegativeNumber() {

        final StringListFactory factory = new StringListFactory(-1);
        factory.get();
    }
}

package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("45rtg", "Name"));
        orders.add(new Order("34ert", "Phone"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("45rtg"), is(new Order("45rtg", "Name")));
    }

    @Test
    public void whenDuplicate() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("45rtg", "Name"));
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("34ert", "Phone"));
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        int expectedMapSize = 3;
        assertEquals(expectedMapSize, map.size());
    }
}
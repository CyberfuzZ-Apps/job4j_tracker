package ru.job4j.collection;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissed2() {
        List<String> input = List.of("K1/SK1", "K1/SK2", "K1/SK1/SSK1",
                "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<String> expect = List.of("K1", "K1/SK1", "K1/SK2", "K1/SK1/SSK1",
                "K1/SK1/SSK2", "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortDesc() {
        List<String> input = List.of("K1/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2");
        List<String> rsl = Departments.fillGaps(input);
        Departments.sortDesc(rsl);
        List<String> expected = List.of("K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2");
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSortAsk() {
        List<String> input = List.of("K1/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2");
        List<String> rsl = Departments.fillGaps(input);
        Departments.sortAsc(rsl);
        List<String> expected = List.of("K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2",
                "K1/SK2", "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2");
        assertThat(rsl, is(expected));
    }
}
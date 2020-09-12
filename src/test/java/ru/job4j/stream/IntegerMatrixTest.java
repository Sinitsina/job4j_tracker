package ru.job4j.stream;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class IntegerMatrixTest {
    @Test
    public void whenMatrixToList() {
    Integer[][] matrix = {{1, 2, 3},
            {4, 5, 6}};
    List<Integer> result = IntegerMatrix.convert(matrix);
    List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
    assertThat(result, is(expected));
}
}
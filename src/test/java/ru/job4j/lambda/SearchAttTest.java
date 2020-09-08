package ru.job4j.lambda;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearchAttTest {

    @Test
    public void whenFilterByName() {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("Impl task", 5),
                new Attachment("Fix bug", 1),
                new Attachment("Testing", 2)
        );
        assertThat(SearchAtt.filterName(attachments).toString(),
                Is.is("[Attachment{name='Fix bug', size=1}]"));
    }

    @Test
    public void whenFilterBySize() {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("Impl task", 500),
                new Attachment("Fix bug", 1),
                new Attachment("Testing", 200)
        );
        assertThat(SearchAtt.filterSize(attachments).toString(),
                Is.is("[Attachment{name='Impl task', size=500}, "
                        + "Attachment{name='Testing', size=200}]"));
    }
}
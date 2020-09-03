package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest  {
    @Test
    public void whenComparatorByNameDescendingOrder() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Testing", 2)
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs.toString(), is("[Job{Testing, 2}, " +
                "Job{Impl task, 0}, " +
                "Job{Fix bug, 1}]"));
    }

    @Test
    public void whenComparatorByNameAscendingOrder() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Testing", 2)
        );
        Collections.sort(jobs, new JobAscByName());
        assertThat(jobs.toString(), is("[Job{Fix bug, 1}, " +
                "Job{Impl task, 0}, " +
                "Job{Testing, 2}]"));
    }

    @Test
    public void whenComparatorByPriorityDescendingOrder() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 5),
                new Job("Fix bug", 1),
                new Job("Testing", 2)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs.toString(), is("[Job{Impl task, 5}, " +
                "Job{Testing, 2}, " +
                "Job{Fix bug, 1}]"));
    }

    @Test
    public void whenComparatorByPriorityAscendingOrder() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 5),
                new Job("Fix bug", 1),
                new Job("Testing", 2)
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertThat(jobs.toString(), is("[Job{Fix bug, 1}, " +
                "Job{Testing, 2}, " +
                "Job{Impl task, 5}]"));
    }

    @Test
    public void whenComparatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndProrityAscendingOrder() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }


}
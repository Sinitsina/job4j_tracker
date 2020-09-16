package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest  {
    @Test
    public void whenComparatorByNameDescendingOrder() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Testing", 2)
        ));
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs.toString(), is("[Job{Testing, 2}, "
                + "Job{Impl task, 0}, "
                + "Job{Fix bug, 1}]"));
    }

    @Test
    public void whenComparatorByNameAscendingOrder() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Testing", 2)
        ));
        Collections.sort(jobs, new JobAscByName());
        assertThat(jobs.toString(), is("[Job{Fix bug, 1}, "
                + "Job{Impl task, 0}, "
                + "Job{Testing, 2}]"));
    }

    @Test
    public void whenComparatorByPriorityDescendingOrder() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Impl task", 5),
                new Job("Fix bug", 1),
                new Job("Testing", 2)
        ));
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs.toString(), is("[Job{Impl task, 5}, "
                + "Job{Testing, 2}, "
                + "Job{Fix bug, 1}]"));
    }

    @Test
    public void whenComparatorByPriorityAscendingOrder() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Impl task", 5),
                new Job("Fix bug", 1),
                new Job("Testing", 2)
        ));
        Collections.sort(jobs, new JobAscByPriority());
        assertThat(jobs.toString(), is("[Job{Fix bug, 1}, "
                + "Job{Testing, 2}, "
                + "Job{Impl task, 5}]"));
    }

    @Test
    public void whenComparatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndProrityAscendingOrder() {
        Comparator<Job> cmpNamePriority =
                new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByProrityAndNameAscendingOrder() {
        Comparator<Job> cmpNamePriority =
                new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByProrityAndNameDescendingOrder() {
        Comparator<Job> cmpNamePriority =
                new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Check task", 2),
                new Job("Fix bug", 2)
        );
        assertThat(rsl, greaterThan(0));
    }
}
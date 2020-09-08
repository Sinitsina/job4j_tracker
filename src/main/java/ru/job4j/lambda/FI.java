package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    Attachment[] atts = {
            new Attachment("image 1", 20),
            new Attachment("image 3", 120),
            new Attachment("image 2", 23)
    };

    Comparator<Attachment> cmpText = (left, right) -> {
        System.out.println("compare - " + right.getSize() + " : " + left.getSize());
        return right.getName().compareTo(left.getName());
    };

    Comparator<String> cmpDescSize = (left, right) -> {
        System.out.println("compare length - " + right.length() + " : " + left.length());
        return right.length() - left.length();
    };
}

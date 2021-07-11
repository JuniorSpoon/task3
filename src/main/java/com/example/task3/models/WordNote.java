package com.example.task3.models;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WordNote implements Serializable {

    private LocalDate timestamp;
    private String sentence;

    @Override
    public String toString() {
        return "{\"timestamp:\": \"" + timestamp +
                "\",\"sentence:\"" + sentence + "\"" +
                '}';
    }
}

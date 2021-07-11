package com.example.task3.controllers;

import com.example.task3.models.WordNote;
import com.example.task3.utils.WriteToFileUtil;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="api/t3/note")
public class WordNoteController {

    @GetMapping
    public WordNote getWordNode(){
        RestTemplate restTemplate = new RestTemplate();
        WordNote wordNote = restTemplate.getForObject("http://localhost:8080/api/t2/note", WordNote.class);
        return wordNote;
    }

    @GetMapping("/multiple/{times}")
    public List<WordNote> getWordNodes(@PathVariable("times") Integer times){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WordNote[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8080/api/t2/note/multiple/"+ times,
                        WordNote[].class);
        List<WordNote> wordNotes = Arrays.asList(Objects.requireNonNull(response.getBody()));
        WriteToFileUtil.writeToFileWordNotes(wordNotes.stream().sorted(Comparator.comparing(WordNote::getTimestamp)).collect(Collectors.toList()));
        return wordNotes;
    }
}

package com.example.task3.utils;

import com.example.task3.models.WordNote;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.io.*;
import java.util.List;

public class WriteToFileUtil {

    @SneakyThrows
    public static void writeToFileWordNotes(@NonNull List<WordNote> wordNoteList){
        File fout = new File("out.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        bw.write(wordNoteList.toString());
           bw.newLine();

        bw.close();
    }
}

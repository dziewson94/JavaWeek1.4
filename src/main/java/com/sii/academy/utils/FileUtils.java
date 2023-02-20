package com.sii.academy.utils;


import com.sii.academy.main.Main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
    private FileUtils() {
    }

    public static Path getFilePathFromResources(String fileName) throws URISyntaxException {
        return Paths.get(Main.class.getClassLoader().getResource(fileName).toURI());
    }

    public static List<String> readFileAsStringList(String fileName) throws URISyntaxException, IOException {
        return Files.readAllLines(getFilePathFromResources(fileName));
    }
}



package io.baris.aoc.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtil {

    public static Stream<String> readFileAsStream(final String fileName) throws URISyntaxException, IOException {
        final URL url = FileUtil.class.getClassLoader().getResource(fileName);
        if (url == null) {
            System.out.println(String.format("Input file %s not found. ", fileName));
            System.exit(1);
        }
        return Files.lines(Paths.get(url.toURI()));
    }
}

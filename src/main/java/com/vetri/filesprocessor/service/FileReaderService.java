package com.vetri.filesprocessor.service;

import com.vetri.filesprocessor.model.Node;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;

import static java.nio.file.Files.isDirectory;

@Service
public class FileReaderService {

    public void readFile(Path path, Node node) throws IOException {
        if (isDirectory(path)) {
            Stream<Path> files = Files.list(path);
            files.forEach(p -> {
                try {
                    boolean directory = isDirectory(p);
                    Node child = new Node(p.getFileName().toString(), p.toAbsolutePath().toString(), directory, new ArrayList<>());
                    node.getChild().add(child);
                    if (directory) {
                        readFile(p, child);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            Node child = new Node(path.getFileName().toString(), path.toAbsolutePath().toString(), false, null);
            node.getChild().add(child);
        }
    }
}

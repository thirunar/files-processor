package com.vetri.filesprocessor.controller;


import com.vetri.filesprocessor.model.Node;
import com.vetri.filesprocessor.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.Files.isDirectory;

@RestController
public class FileReaderController {

    @Autowired
    private FileReaderService service;

    @RequestMapping(value = "read")
    public Node readFile(@RequestHeader("path") String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Node node = new Node(path.getFileName().toString(), path.toAbsolutePath().toString(), isDirectory(path), new ArrayList<>());
        service.readFile(path, node);
        return node;
    }
}

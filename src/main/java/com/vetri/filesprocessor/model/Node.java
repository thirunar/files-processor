package com.vetri.filesprocessor.model;

import java.util.List;

public class Node {

    private String name;
    private String path;
    private boolean isDirectory;
    private List<Node> child;

    public Node() {
    }

    public Node(String name, String path, boolean isDirectory, List<Node> child) {
        this.name = name;
        this.path = path;
        this.isDirectory = isDirectory;
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public List<Node> getChild() {
        return child;
    }
}

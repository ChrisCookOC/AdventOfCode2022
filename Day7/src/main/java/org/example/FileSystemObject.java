package org.example;

abstract public class FileSystemObject {

    Directory parent;

    String name;

    public FileSystemObject(String name) {
        this.name = name;
    }

}

package org.example;

public class File extends FileSystemObject{

    int size;

    public File(String name) {
        super(name);
    }

    public File(String name, int size){
        super(name);
        this.size = size;
    }
}

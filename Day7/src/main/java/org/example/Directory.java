package org.example;


import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemObject {

    List<FileSystemObject> contents = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public String getFullName(){

        StringBuilder fullName = new StringBuilder(name);

        if (parent != null && parent.name != null) {
            fullName.append("/");
            fullName.append(parent.getFullName());
        }

        return fullName.toString();
    }

    public int calculateTotalStorageSpace(){

        int sum = 0;

        for (FileSystemObject content : contents){
            if (content instanceof File){
                sum+=((File) content).size;
            } else {
                Directory subDirectory = (Directory) content;
                sum+=subDirectory.calculateTotalStorageSpace();
            }

        }

        return sum;
    }
}

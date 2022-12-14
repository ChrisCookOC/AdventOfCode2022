package org.example;

import java.util.*;

public class FileSystem {

    Map<String, Directory> directories = new HashMap<>();
    Directory currentDirectory;

    void executeChangeDirectoryCommand(CommandLine instruction) {
        if (!instruction.isChangeLineCommand()) {
            throw new RuntimeException("Bad request");
        }

        String newDirectory = instruction.getDirectoryFromChangeDirectoryCommand();

        if (Objects.equals(newDirectory, "..")) {
            if (currentDirectory.parent == null) {
                throw new RuntimeException("Root has no parent");
            }

            currentDirectory = currentDirectory.parent;

        } else {
            Directory newDirectoryObject;

            if (Objects.equals(newDirectory, "/")) {
                newDirectoryObject = directories.get("/");
            } else {
                newDirectoryObject = directories.get(newDirectory + "/" + currentDirectory.getFullName());
            }

            if (newDirectoryObject == null) {
                //Make a new folder
                newDirectoryObject = new Directory(newDirectory);
                newDirectoryObject.parent = currentDirectory;
                addDirectoryToCollection(newDirectoryObject);
            }

            currentDirectory = newDirectoryObject;

        }

    }

    protected void addDirectoryToCollection(Directory directory) {
        directories.put(directory.getFullName(), directory);
    }

    public void addFileToDirectoryContents(CommandLine commandLine) {

        if (commandLine.isCommand()) {
            throw new RuntimeException();
        }

        String[] components = commandLine.line.split(" ");

        int size = Integer.parseInt(components[0]);
        String filename = components[1];

        File file = new File(filename);
        file.size = size;

        file.parent = currentDirectory;

        currentDirectory.contents.add(file);

    }

    public void addDirectoryToDirectoryContents(CommandLine commandLine) {

        if (commandLine.isCommand()) {
            throw new RuntimeException();
        }

        String[] components = commandLine.line.split(" ");

        String filename = components[1];

        Directory directory = new Directory(filename);

        directory.parent = currentDirectory;

        currentDirectory.contents.add(directory);
        addDirectoryToCollection(directory);

    }

    public List<Directory> sortDirectoriesBySize() {

        List<Directory> sortedList;

        sortedList = directories.values().stream().sorted(Comparator.comparingInt(Directory::calculateTotalStorageSpace)).toList();

        return sortedList;
    }
}

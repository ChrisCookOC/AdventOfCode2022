package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    private final InputStream file;

    public FileParser(InputStream file) {
        this.file = file;
    }

    public List<CommandLine> parseSource() throws IOException {

        List<CommandLine> commands = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                commands.add(new CommandLine(line));

            }
        }
        return commands;
    }


    public FileSystem buildFileSystem() throws IOException {

        List<CommandLine> commands = parseSource();

        FileSystem fileSystem = new FileSystem();

        //Always have a root
        Directory rootDirectory = new Directory("/");
        fileSystem.addDirectoryToCollection(rootDirectory);
        fileSystem.currentDirectory = rootDirectory;

        for (CommandLine command : commands) {
            if (command.isChangeLineCommand()) {
                fileSystem.executeChangeDirectoryCommand(command);
            } else if (command.isListCommand()) {
                //Not really anything to do. Could add bool maybe
            } else if (command.isCommand()) {
                throw new RuntimeException();
            } else {
                if (command.line.startsWith("dir ")) {
                    fileSystem.addDirectoryToDirectoryContents(command);
                } else {
                    fileSystem.addFileToDirectoryContents(command);
                }
            }
        }

        //Ensure back at root for any further efforts
        fileSystem.currentDirectory = rootDirectory;

        return fileSystem;
    }

}

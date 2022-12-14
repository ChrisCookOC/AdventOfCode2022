package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandLine {

    String line;

    boolean isCommand(){
        return line.startsWith("$");
    }

    String getDirectoryFromChangeDirectoryCommand(){
        String directory = line.replace("cd", "");
        directory = directory.replace("$", "");
        directory = directory.trim();
        return directory;
    }

    public boolean isChangeLineCommand() {
        return isCommand() && line.contains("cd");
    }

    public boolean isListCommand(){
        return isCommand() && line.contains("ls");
    }
}

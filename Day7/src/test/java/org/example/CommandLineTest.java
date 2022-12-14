package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineTest {

    @Test
    void should_be_a_command_if_starts_with_dollar() {
        CommandLine instruction = new CommandLine("$cd");
        assertTrue(instruction.isCommand());
    }

    @Test
    void should_not_be_a_command_if_doesnt_starts_with_dollar() {
        CommandLine instruction = new CommandLine("dir a");
        assertFalse(instruction.isCommand());
    }

    @Test
    void should_return_directory_when_slash() {
        CommandLine commandLine = new CommandLine("$ cd /");
        assertEquals("/", commandLine.getDirectoryFromChangeDirectoryCommand());
    }

    @Test
    void should_return_directory() {
        CommandLine commandLine = new CommandLine("$ cd abc");
        assertEquals("abc", commandLine.getDirectoryFromChangeDirectoryCommand());
    }

    @Test
    void should_return_directory_when_dots() {
        CommandLine commandLine = new CommandLine("$ cd ..");
        assertEquals("..", commandLine.getDirectoryFromChangeDirectoryCommand());
    }

    @Test
    void changedirectory_should_return_true_if_change_directory() {
        CommandLine commandLine = new CommandLine("$ cd ..");
        assertTrue(commandLine.isChangeLineCommand());

    }

    @Test
    void changedirectory_should_return_false_if_list_command() {
        CommandLine commandLine = new CommandLine("$ ls");
        assertFalse(commandLine.isChangeLineCommand());

    }

    @Test
    void changedirectory_should_return_false_if_not_a_command() {
        CommandLine commandLine = new CommandLine("128272 file");
        assertFalse(commandLine.isChangeLineCommand());

    }

    @Test
    void list_should_return_true_if_list() {
        CommandLine commandLine = new CommandLine("$ ls");
        assertTrue(commandLine.isListCommand());

    }

    @Test
    void list_should_return_false_if_change_directory() {
        CommandLine commandLine = new CommandLine("$ cd ..");
        assertFalse(commandLine.isListCommand());

    }

    @Test
    void list_should_return_false_if_not_a_command() {
        CommandLine commandLine = new CommandLine("128272 file");
        assertFalse(commandLine.isListCommand());

    }
}
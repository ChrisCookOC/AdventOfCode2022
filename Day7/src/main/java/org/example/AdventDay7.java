package org.example;

import java.io.FileInputStream;
import java.util.List;

public class AdventDay7 {

    public static void main(String[] args) {

        int value = findTotalOfFoldersLessThan100000("src/input.txt");

        System.out.printf("The sum of those folders whose size is at most 100000 is %d\n", value);

        value = findSizeOfSmallestThatMeetsRequirements("src/input.txt");
        System.out.printf("The smallest one to delete has size %d\n", value);
    }

    public static int findTotalOfFoldersLessThan100000(String fileName) {

        int sum = 0;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            FileSystem fileSystem = fileParser.buildFileSystem();

            for (String directoryKey : fileSystem.directories.keySet()) {

                Directory directory = fileSystem.directories.get(directoryKey);
                int space = directory.calculateTotalStorageSpace();

                if (space <= 100000) {
                    sum += space;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return sum;
    }

    public static int findSizeOfSmallestThatMeetsRequirements(String fileName) {

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            FileParser fileParser = new FileParser(fileInputStream);
            FileSystem fileSystem = fileParser.buildFileSystem();

            List<Directory> sortedList = fileSystem.sortDirectoriesBySize();

            int freeSpace = 70000000 - fileSystem.directories.get("/").calculateTotalStorageSpace();


            for (Directory directory : sortedList) {
                if (directory.calculateTotalStorageSpace() + freeSpace >= 30000000) {
                    return directory.calculateTotalStorageSpace();
                }

            }

        } catch (Exception e) {
            throw new RuntimeException("Could not read file");
        }

        return 0;
    }
}
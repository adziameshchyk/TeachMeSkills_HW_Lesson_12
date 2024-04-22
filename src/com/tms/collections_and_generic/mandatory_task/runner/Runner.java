package com.tms.collections_and_generic.mandatory_task.runner;

import com.tms.collections_and_generic.mandatory_task.models.DocValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Task:
 * <p>
 * Let's go back to the homework assignment for lesson number 12 and modify it.
 * The program should receive file names with document numbers from the console: each new line is the path to the file and the file name.
 * To complete the file list entry, enter 0.
 * After receiving the list of documents, the program must process each document: subtract document numbers from the file and validate them.
 * At the end of the work, create one report file with the output information: document number - comment (valid or not valid and for what reason).
 * Let each file contain each document number on a new line and no other information on the line, just the document number.
 * A valid document number must be 15 characters long and begin with the sequence docnum (hereinafter any sequence of letters/numbers)
 *  or contract (hereinafter any sequence of letters/numbers).
 * Please note that document numbers can be repeated within the same file, and different documents can also contain the same document numbers.
 * If document numbers are repeated, then duplicate document numbers should not be checked or validated.
 * <p>
 * Some technical details:
 * <p>
 * 1. Read a list of documents from the console: if it’s a list, then these are collections of the List type,
 *  there are no other conditions - that means we save all the file names from the console into the ArrayList data structure.
 * 2. Document numbers can be repeated, but repeated documents do not need to be processed and validated,
 *  i.e. in fact, we don’t need duplicates - this means we need to read document numbers from files
 *  and save all document numbers into a collection of the Set type. There are no other conditions, which means you can use HashSet.
 * 3. At the end there should be a structure document number - comment - i.e. This structure is of key-value type, which means it is a collection of type Map.
 * <p>
 * There are no other conditions - which means you can use HashMap.
 * Create such a structure and then make a cycle through this structure and write all the information from this map into a report file.
 */

public class Runner {

    public static void main(String[] args) {
        System.out.println("Enter the paths to the files with document numbers.");
        List<String> inputFilePaths = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputFilePath;
            while (!(inputFilePath = bufferedReader.readLine()).equals("0")) {
                inputFilePaths.add(inputFilePath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String filePath : inputFilePaths) {
            DocValidator validator = new DocValidator(filePath);
            validator.validate();
        }
    }

}

package AccentureCoddingQue.Aug_30_2024_slot1_slot2;
/*
File Version
------------
Que:
You are given a string array S that contains the names of some files along with their versions.
Your task is to find and return an integer value representing the latest version out of all the files
that are correctly named in the array.
A file is considered correct if it follows the format of the file named as "File_X"
(where X represents the file version number). Return -1 if there are no correct files in the array.

Note:
• A file is incorrect if the name of the file does not match the format.
• If there is no file in the files array then also return -1.

Input Specification:
---------------------
input1: A string array S, representing the names of the files.
input2: An integer value representing the size of the array.

Output Specification:
----------------------
Return an integer value representing the latest version out of all the files that are correctly named
in the array.
 */

public class FileVersionFinder {

    public static int findLatestVersion(String[] files, int size) {
        if (size == 0) {
            return -1; // No files in the array
        }

        int latestVersion = -1;

        for (String fileName : files) {
            // Check if the file name matches the pattern "File_X"
            if (fileName.matches("File_\\d+")) {
                // Extract the version number
                String[] parts = fileName.split("_");
                int version = Integer.parseInt(parts[1]);
                // Update the latest version if this one is higher
                if (version > latestVersion) {
                    latestVersion = version;
                }
            }
        }

        return latestVersion; // Return -1 if no valid files were found
    }

    public static void main(String[] args) {
        String[] files = {"File_1", "File_2", "InvalidFile", "File_10"};
        int latestVersion = findLatestVersion(files, files.length);
        System.out.println(latestVersion); // Output should be 10
    }
}

/*
The matches() method in Java is a part of the String class that checks
if the entire string matches a specified regular expression (regex).
It returns true if the string matches the regex pattern and false otherwise.

Syntax:
-------
boolean matches(String regex)

 */
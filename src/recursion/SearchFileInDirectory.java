package recursion;

import java.util.ArrayList;
import java.util.List;

/*
    Given a directory structure, search a given file and return true if present

    given two inbuilt functions
    1. List<> getAllDirectories(dir) --> returns all directories inside the given directory
    2. List<> getAllFiles(dir)       --> returns all files inside the given directory

    approach:

    1. Search for the file in home directory, if present return true
    2. else check in other directories inside home directory one by one
 */
public class SearchFileInDirectory {

    private boolean search(String dir, String fileName) {


        List<String> fileList = getAllFiles(dir);

        for(String name: fileList) {
            if(name.equals(fileName)) {
                return true;
            }
        }

        List<String> dirList = getAllDirectories(dir);

        for(String dirName: dirList) {
            boolean ans = search(dirName, fileName);

            if(ans) {
                return true;
            }
        }

        return false;
    }

    // inbuilt functions for the program
    private List<String> getAllFiles(String dir) {
        return new ArrayList<>();
    }

    private List<String> getAllDirectories(String dir) {
        return new ArrayList<>();
    }
}

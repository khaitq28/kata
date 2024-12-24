package oop.removeRf;

import java.util.List;

public interface FileApi {

    int getFileSize(String file);

    boolean delete(String path); //  deletes the file or empty directory, returns false if deletion was not successful.

    boolean isDirectory(String path); //checks whether filepath is directory or not.

    boolean isExist(String path);

    List<String> GetAllFiles(String path); // gets the absolute paths of all files in a directory, including other sub-directories.
}

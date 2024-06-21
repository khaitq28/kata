package oop.unixFileSearch;


import lombok.Getter;

import java.nio.file.Files;

@Getter
public class File extends AbstractFile{

    private final byte[] content;

    public File(String name, byte[] content) {
        super(name);
        this.content = content;
    }
    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public int getSize() {
        return content.length;
    }

    public String getExtension() {
        String[] parts = name.split("\\.");
        return parts[parts.length-1];
    }
}

package oop.unixFileSearch;


import lombok.Getter;

@Getter
public abstract class AbstractFile {

    protected String name;
    public abstract boolean isDirectory();
    public abstract int getSize();

    public AbstractFile(String name) {
        this.name = name;
    }
}

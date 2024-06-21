package oop.unixFileSearch;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Directory extends AbstractFile{

    private final List<AbstractFile> files = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public int getSize() {
        return files.stream().map(AbstractFile::getSize).reduce(0, Integer::sum);
    }
}

package oop.removeRf;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RmRfApi {

    private FileApi fileApi;


    //Implement rm -rf: remove all file + sub directory
    public void deleteAllFilesAndDir(String path) {
        List<String> list = fileApi.GetAllFiles(path);
        List<String> files = new ArrayList<>();
        List<String> subs = new ArrayList<>();
        for (String sub: list) {
            if (!fileApi.isDirectory(sub))
                files.add(sub);
            else
                subs.add(sub);
        }
        for (String f: files) fileApi.delete(f);
        for (String sub: subs) deleteAllFilesAndDir(sub);
        fileApi.delete(path);
    }

    public void deleteAll(String path) {
        Stack<String> st = new Stack<>();
        st.add(path);
        while (!st.isEmpty()) {
            String cur = st.peek();
            if (fileApi.isDirectory(cur)) {
                List<String> all = fileApi.GetAllFiles(cur);
                if (all.isEmpty()) {
                    fileApi.delete(cur);
                    st.pop(); continue;
                }
                st.addAll(all);
            } else {
                fileApi.delete(cur);
                st.pop();
            }
        }
        fileApi.delete(path);
    }
}

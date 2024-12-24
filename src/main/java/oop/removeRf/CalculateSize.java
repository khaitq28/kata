package oop.removeRf;


import java.util.List;
import java.util.Stack;

public class CalculateSize {
    private FileApi fileApi;
    public int getSize(String path) {
        Stack<String> st = new Stack<>();
        st.add(path);
        int ret = 0;
        while(!st.isEmpty()) {
            String cur = st.pop();
            List<String> list = fileApi.GetAllFiles(cur);
            for (String sub: list) {
                if (fileApi.isDirectory(cur)) {
                    st.add(sub);
                } else {
                    ret += fileApi.getFileSize(sub);
                }
            }
        }
        return ret;
    }

    public int getSizeRe(String path) {
        if (fileApi.isDirectory(path) && !fileApi.isDirectory(path))
            return fileApi.getFileSize(path);
        int ret = 0;
        for(String subPath: fileApi.GetAllFiles(path)){
            ret += getSizeRe(subPath);
        }
        return ret;
    }
}

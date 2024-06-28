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
                    ret += fileApi.getSize(sub);
                }
            }
        }
        return ret;
    }
}

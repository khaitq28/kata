package interview.question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * INTERVIEW QUESTION 1 — Original (smelly) code.
 *
 * Smells present:
 *  - Unclear method name: getData()
 *  - Unclear parameter names: type, flag, s
 *  - Flag Argument (boolean flag) — Uncle Bob, Clean Code Ch.3
 *  - Primitive Obsession (int type used as type code)
 *  - Return type too generic: List<Map<String, Object>>
 *  - Method too large, does multiple things (violates SRP)
 *  - if/else branching on type code (violates OCP)
 */
public class Question1Original {

    public List<Map<String, Object>> getData(int type, boolean flag, String s) {
        List<Map<String, Object>> result = new ArrayList<>();

        if (type == 1 && flag) {
            // ~40 lines: fetch active orders logic
        } else if (type == 2) {
            // ~30 lines: fetch archived reports logic
        }

        return result;
    }
}

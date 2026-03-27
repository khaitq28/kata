package interview.craftsman.question2;

/**
 * INTERVIEW QUESTION 2 — Original (smelly) code.
 *
 * Smells present:
 *  - String used as type discriminator (Primitive Obsession)
 *  - if/else chain on type — violates OCP (Open/Closed Principle)
 *  - Adding XML export requires modifying this class (not closed for modification)
 *  - No abstraction — impossible to substitute exporters (violates LSP potential)
 *  - Caller must pass magic string "PDF", "CSV", "EXCEL" (Shotgun Surgery risk)
 */
public class Question2Original {

    public void export(Report report, String format) {
        if (format.equals("PDF")) {
            // export as PDF
        } else if (format.equals("CSV")) {
            // export as CSV
        } else if (format.equals("EXCEL")) {
            // export as EXCEL
        }
        // Adding XML = modify THIS class — violates OCP
    }
}

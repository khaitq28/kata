package interview.craftsman.question9;

import java.util.List;

/**
 * INTERVIEW QUESTION 9 — Original (smelly) code.
 *
 * Scenario: generating reports in different formats.
 * Each method follows the same algorithm but duplicates the shared steps.
 */
public class Question9Original {

    public void generatePdfReport(List<String> data) {
        // step 1 — validate
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("No data to export");
        }
        // step 2 — prepare header
        System.out.println("=== PDF REPORT ===");

        // step 3 — format (PDF specific)
        for (String item : data) {
            System.out.println("<pdf-row>" + item + "</pdf-row>");
        }

        // step 4 — write footer
        System.out.println("=== END OF REPORT ===");

        // step 5 — save
        System.out.println("Saving report.pdf to disk");
    }

    public void generateCsvReport(List<String> data) {
        // step 1 — validate (DUPLICATED)
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("No data to export");
        }
        // step 2 — prepare header (DUPLICATED)
        System.out.println("=== CSV REPORT ===");

        // step 3 — format (CSV specific)
        System.out.println("id,value");
        for (String item : data) {
            System.out.println(item + ",exported");
        }

        // step 4 — write footer (DUPLICATED)
        System.out.println("=== END OF REPORT ===");

        // step 5 — save (DUPLICATED)
        System.out.println("Saving report.csv to disk");
    }

    public void generateXmlReport(List<String> data) {
        // step 1 — validate (DUPLICATED)
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("No data to export");
        }
        // step 2 — prepare header (DUPLICATED)
        System.out.println("=== XML REPORT ===");

        // step 3 — format (XML specific)
        System.out.println("<report>");
        for (String item : data) {
            System.out.println("  <row>" + item + "</row>");
        }
        System.out.println("</report>");

        // step 4 — write footer (DUPLICATED)
        System.out.println("=== END OF REPORT ===");

        // step 5 — save (DUPLICATED)
        System.out.println("Saving report.xml to disk");
    }
}

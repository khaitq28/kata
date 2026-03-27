package interview.craftsman.question9;

import java.util.List;

public class Question9Correction {

    public static void main(String[] args) {
        List<String> data = List.of("1", "2", "3");
        ReportGenerator pdfReport = new PdfReportGenerator(data);
        pdfReport.generateReport();

        ReportGenerator excelReport = new ExcelReportGenerator(data);
        excelReport.generateReport();

        ReportGenerator csvReport = new CsvReportGenerator(data);
        csvReport.generateReport();
    }

    public abstract static class ReportGenerator {

        protected final List<String> data;

        protected ReportGenerator(List<String> data) {
            this.data = data;
        }

        public void validate() {
            if (data == null || data.isEmpty()) {
                throw new IllegalArgumentException("No data to export");
            }
        }

        public abstract void prepareHeader();

        public abstract void prepareBody();

        public void prepareFooter() {
            System.out.println("=== END OF REPORT ===");
        }

        public abstract void save();

        public final void generateReport() {
            validate();
            prepareHeader();
            prepareBody();
            prepareFooter();
            save();
        }
    }

    protected static class PdfReportGenerator extends ReportGenerator {

        public PdfReportGenerator(List<String> data) {
            super(data);
        }

        @Override
        public void prepareHeader() {
            System.out.println("=== PDF REPORT ===");
        }
        @Override
        public void prepareBody() {
            for (String item : data) {
                System.out.println("<pdf-row>" + item + "</pdf-row>");
            }
        }

        @Override
        public void save() {
            System.out.println("Saving report.pdf to disk");
        }

    }

    protected static class ExcelReportGenerator extends ReportGenerator {

        public ExcelReportGenerator(List<String> data) {
            super(data);
        }

        @Override
        public void prepareHeader() {
            System.out.println("=== EXCEL REPORT ===");
        }

        @Override
        public void prepareBody() {
            for (String item : data) {
                System.out.println("<excel-row>" + item + "</excel-row>");
            }
        }

        @Override
        public void save() {
            System.out.println("Saving report.xlsx to disk");
        }
    }

    protected static class CsvReportGenerator extends ReportGenerator {
        public CsvReportGenerator(List<String> data) {
            super(data);
        }

        @Override
        public void prepareHeader() {
            System.out.println("=== CSV REPORT ===");
            System.out.println("id,value");
        }

        @Override
        public void prepareBody() {
            for (String item : data) {
                System.out.println(item + ",exported");
            }
        }

        @Override
        public void save() {
            System.out.println("Saving report.csv to disk");
        }
    }

}

package interview.craftsman.question2;

public class PdfReportExporter implements ReportExporter {
    @Override
    public void export(Report report) {
        System.out.println("pdf report = " + report.toString());
    }
}

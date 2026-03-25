package interview.question2;

public class CsvReportExporter implements ReportExporter {
    @Override
    public void export(Report report) {
        System.out.println("csv report = " + report.toString());
    }
}

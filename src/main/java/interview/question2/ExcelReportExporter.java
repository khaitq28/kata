package interview.question2;

public class ExcelReportExporter implements ReportExporter {
    @Override
    public void export(Report report) {
        System.out.println("report.toString() = " + report.toString());
    }
}

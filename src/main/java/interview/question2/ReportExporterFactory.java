package interview.question2;

public class ReportExporterFactory {

    public ReportExporter getReportExporter(FileType type) {
        return switch (type) {
            case PDF -> new PdfReportExporter();
            case CSV -> new CsvReportExporter();
            case EXCEL -> new ExcelReportExporter();
        };
    }
}

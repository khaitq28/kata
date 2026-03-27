package interview.craftsman.question2;

public class ReportExportService {


    private final ReportExporterFactory exporterFactory;

    public ReportExportService(ReportExporterFactory exporterFactory) {
        this.exporterFactory = exporterFactory;
    }

    public void export(Report report, FileType fileType) {
        ReportExporter exporter = exporterFactory.getReportExporter(fileType);
        exporter.export(report);
    }
}

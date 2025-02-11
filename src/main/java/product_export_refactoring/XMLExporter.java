package product_export_refactoring;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

public class XMLExporter {

    private static final String XML_VERSION = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    private XMLExporter() {
    }
    public static String exportFull(Collection<Order> orders) {
        StringBuilder xml = new StringBuilder();
        xml.append(XML_VERSION);
        xml.append("<orders>");
        for (Order order : orders) {
            xml.append(order.getFullExport());
        }
        xml.append("</orders>");
        return xml.toString();
    }

    public static String exportTaxDetails(Collection<Order> orders) {

        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        DecimalFormat decimalFormat = (DecimalFormat) formatter;
        decimalFormat.applyPattern("#0.00");

        StringBuilder xml = new StringBuilder();
        xml.append(XML_VERSION);
        xml.append("<orderTax>");
        for (Order order : orders) {
            xml.append(order.getExportWithTax());
        }
        double totalTax = TaxCalculator.calculateAddedTax(orders);
        xml.append(formatter.format(totalTax));
        xml.append("</orderTax>");
        return xml.toString();
    }

    public static String exportStore(Store store) {
        StringBuilder xml = new StringBuilder();
        xml.append(XML_VERSION);
        xml.append("<store");
        xml.append(" name='");
        xml.append(store.getName());
        xml.append("'");
        xml.append(">");
        for (Product product : store.getStock()) {
            xml.append(product.exportWithStore());
        }
        xml.append("</store>");
        return xml.toString();
    }

    public static String exportHistory(Collection<Order> orders) {
        StringBuilder xml = new StringBuilder();
        xml.append(XML_VERSION);
        xml.append("<orderHistory");
        xml.append(" createdAt='");
        Date now = new Date();
        xml.append(Util.toIsoDate(now));
        xml.append("'");
        xml.append(">");
        for (Order order : orders) {
            xml.append(order.getExportHistory());
        }
        xml.append("</orderHistory>");
        return xml.toString();
    }

}

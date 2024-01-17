package com.easy.learn.ultils;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author modani
 */
@Slf4j
public class JasperReportUtils {
    private static final String CSV_DELIMITER = ";";

    public static JasperPrint getJasperPrint(String reportPath, Map<String, Object> params, List<?> data) throws JRException {
        File file = new File(reportPath);
        if (!file.exists()) {
            log.error("Report file at {} not found", reportPath);
            throw new JRException("Report file not found");
        }
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        return JasperFillManager.fillReport(jasperReport, params, dataSource);
    }

    public static byte[] exportPdf(String reportPath, Map<String, Object> params, List<?> data) throws JRException {
        JasperPrint jasperPrint = getJasperPrint(reportPath, params, data);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    public static byte[] exportExcel(String reportPath, Map<String, Object> params, List<?> data) throws JRException {
        JasperPrint jasperPrint = getJasperPrint(reportPath, params, data);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));

        SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
        reportConfig.setOnePagePerSheet(true);
        exporter.setConfiguration(reportConfig);

        exporter.exportReport();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] exportCsv(String reportPath, Map<String, Object> params, String delimiter, List<?> data) throws JRException {
        JasperPrint jasperPrint = getJasperPrint(reportPath, params, data);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JRCsvExporter exporter = new JRCsvExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(byteArrayOutputStream));

        SimpleCsvExporterConfiguration configuration = new SimpleCsvExporterConfiguration();
        configuration.setFieldDelimiter(StringUtils.defaultIfBlank(delimiter, CSV_DELIMITER));
        exporter.setConfiguration(configuration);

        exporter.exportReport();
        return byteArrayOutputStream.toByteArray();
    }
}

/**
 * @param jasperPrint
 * @param destFileName contain .xlsx
 * @throws JRException
 */
package com.easy.learn.callApi;

import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaid;
import com.easy.learn.ultils.JasperReportUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {

    public byte[] generateTrainerSalaryPaidReport(List<TrainerSalaryPaid> trainerSalaries, String format) throws JRException {
        String reportPath = "src/main/resources/reports/Simple_Blue.jrxml";
        Map<String, Object> params = new HashMap<>(); // Add any required parameters here

        switch (format.toLowerCase()) {
            case "pdf":
                return JasperReportUtils.exportPdf(reportPath, params, trainerSalaries);
            case "excel":
                return JasperReportUtils.exportExcel(reportPath, params, trainerSalaries);
            case "csv":
                return JasperReportUtils.exportCsv(reportPath, params, ";", trainerSalaries);
            default:
                throw new IllegalArgumentException("Invalid report format");
        }
    }
}
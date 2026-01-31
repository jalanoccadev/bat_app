package com.jalanocca.bat_backend.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.jalanocca.bat_backend.model.dto.checklistlt.MvpAgilDto;
import com.jalanocca.bat_backend.service.ExcelChecklistService;

@Service
public class ExcelChecklistServiceImpl implements ExcelChecklistService {

    @Override
    public ByteArrayInputStream generateExcel() throws IOException {

        InputStream template = getClass()
                .getClassLoader()
                .getResourceAsStream("templates/PlantillaChecklistLT.xlsx");

        Workbook workbook = new XSSFWorkbook(template);

        replaceCaratula(workbook.getSheet("CARATULA"));
        fillMvpAgil(workbook.getSheet("MVP AGIL"), buildTestData(), workbook);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

    private List<MvpAgilDto> buildTestData() {

        List<MvpAgilDto> list = new ArrayList<>();

        list.add(new MvpAgilDto(1, "Git", "Repositorio", "Branch protegido", "SI", "SI"));
        list.add(new MvpAgilDto(2, "Sonar", "Calidad", "Coverage mínimo", "SI", "NO"));
        list.add(new MvpAgilDto(3, "Jenkins", "CI/CD", "Pipeline estable", "no aplica", "SI"));

        return list;
    }

    private void replaceCaratula(Sheet sheet) {

        Map<String, String> vars = Map.of(
            "{varOCD}", "TCK-2025-001",
            "{varApp}", "Pagos / MVP Ágil",
            "{varName}", "Juan Alanocca"
        );

        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING) {
                    String value = cell.getStringCellValue();
                    for (var entry : vars.entrySet()) {
                        value = value.replace(entry.getKey(), entry.getValue());
                    }
                    cell.setCellValue(value);
                }
            }
        }
    }

    private void fillMvpAgil(Sheet sheet, List<MvpAgilDto> data, Workbook workbook) {

        int startRow = 3; // fila donde están los placeholders
        int rowIndex = startRow + 1;

        CellStyle borderStyle = buildBorderStyle(workbook);
        Map<String, CellStyle> statusStyles = buildStatusStyles(workbook);

        for (MvpAgilDto dto : data) {

            Row row = sheet.createRow(rowIndex++);

            // applyTextWithBorder(row.createCell(0),
            //     String.valueOf(dto.getCorrelativo()), borderStyle);
            row.createCell(0).setCellValue(dto.getCorrelativo());
            row.getCell(0).setCellStyle(borderStyle);

            applyTextWithBorder(row.createCell(1),
                    dto.getTool(), borderStyle);

            applyTextWithBorder(row.createCell(2),
                    dto.getCategory(), borderStyle);

            applyTextWithBorder(row.createCell(3),
                    dto.getRevision(), borderStyle);

            applyStatusWithBorder(row.createCell(4),
                    dto.getCumpleDev(), statusStyles, borderStyle);

            applyStatusWithBorder(row.createCell(5),
                    dto.getCumpleLt(), statusStyles, borderStyle);
        }

        sheet.removeRow(sheet.getRow(startRow));
        sheet.shiftRows(startRow + 1, sheet.getLastRowNum(), -1);
    }

    private Map<String, CellStyle> buildStatusStyles(Workbook workbook) {

        Map<String, CellStyle> styles = new HashMap<>();

        // VERDE - SI
        CellStyle green = buildBorderStyle(workbook);
        green.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        green.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        green.setAlignment(HorizontalAlignment.CENTER);
        styles.put("SI", green);

        // ROJO - NO
        CellStyle red = buildBorderStyle(workbook);
        red.setFillForegroundColor(IndexedColors.RED.getIndex());
        red.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        red.setAlignment(HorizontalAlignment.CENTER);
        styles.put("NO", red);

        // AMARILLO - NO APLICA
        CellStyle yellow = buildBorderStyle(workbook);
        yellow.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        yellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        yellow.setAlignment(HorizontalAlignment.CENTER);
        styles.put("NO APLICA", yellow);

        return styles;
    }

    private CellStyle buildBorderStyle(Workbook workbook) {

        CellStyle style = workbook.createCellStyle();

        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.LEFT);

        return style;
    }

    private void applyTextWithBorder(Cell cell, String value, CellStyle style) {
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    private void applyStatusWithBorder(
        Cell cell,
        String value,
        Map<String, CellStyle> statusStyles,
        CellStyle defaultStyle) {

        if (value == null) {
            cell.setCellStyle(defaultStyle);
            return;
        }

        String normalized = value.trim().toUpperCase();
        cell.setCellValue(value);

        CellStyle style = statusStyles.getOrDefault(normalized, defaultStyle);
        cell.setCellStyle(style);
    }
}

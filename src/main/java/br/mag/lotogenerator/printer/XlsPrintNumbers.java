package br.mag.lotogenerator.printer;

import br.mag.lotogenerator.loto.Sequencia;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class XlsPrintNumbers implements IPrintNumbers{


    @Override
    public byte[] print(Map<Long, Sequencia> lotoSeqs) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(" Loto Mega ");
        Map<String, Object[]> data =   prepareNumbersToPrint(lotoSeqs);

        int rowid = 0;
        XSSFRow row;
        Set<String> keyid = data.keySet();

        for (String key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = data.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        writeFile(workbook);
        return generateXlsBytes(workbook);
    }

    private void writeFile(XSSFWorkbook workbook) {

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(
                    new File("C:/LotoMega/LotoMega.xlsx"));
            workbook.write(out);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private byte[] generateXlsBytes(XSSFWorkbook workbook)  {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            workbook.write(bos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        byte[] bytes = bos.toByteArray();
        return bytes;
    }

    private Map<String, Object[]> prepareNumbersToPrint(Map<Long, Sequencia> lotoSeqs) {
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[] { "Dezenas Sorteadas"});
        Integer count = 2;

        for (Map.Entry e : lotoSeqs.entrySet()) {
            data.put(count.toString(), new Object[] {((Sequencia) e.getValue()).printFormattedNumber()});
            count++;
        }
        return data;
    }


}

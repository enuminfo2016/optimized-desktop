/**
 * 
 */
package com.enuminfo.optimized.backend.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.enuminfo.optimized.backend.model.Base;

/**
 * @author AKURATI
 */
public abstract class AbstractFileThread<T extends Base> implements Runnable {

	private String inputFile;
	private final Class<T> modelClass;
	protected List<String[]> list = new ArrayList<String[]>();

	private static final String XLSX_EXTENSION = "xlsx";
	private static final String XLS_EXTENSION = "xls";
	private static final String CSV_EXTENSION = "csv";

	public AbstractFileThread(Class<T> modelClass, String inputFile) {
		this.modelClass = modelClass;
		this.inputFile = inputFile;
	}

	public Class<T> getModelClass() {
		return modelClass;
	}

	public String getInputFile() {
		return inputFile;
	}

	@Override
	public void run() {
		if ((new File(getInputFile()).isFile()) && (getFileExtension(getInputFile()).equals(XLSX_EXTENSION) || getFileExtension(getInputFile()).equals(XLS_EXTENSION))) {
			readExcelFile();
		} else if ((new File(getInputFile()).isFile()) && getFileExtension(getInputFile()).equals(CSV_EXTENSION)) {
			readCsvFile();
		} else if (!new File(getInputFile()).isFile()) {
			File[] files = new File(getInputFile()).listFiles();
			for (File file : files) {
				inputFile = file.getAbsolutePath();
				if ((file.isFile()) && (getFileExtension(file.getName()).equals(XLSX_EXTENSION) || getFileExtension(file.getName()).equals(XLS_EXTENSION))) {
					readExcelFile();
				} else if ((file.isFile()) && getFileExtension(file.getName()).equals(CSV_EXTENSION)) {
					readCsvFile();
				}
			}
			convertArrayToSpecfic();
		}
	}
	
	private void readCsvFile() {
		BufferedReader bufferedReader = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
			bufferedReader = new BufferedReader(new FileReader(getInputFile()));
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line.split(cvsSplitBy));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        convertArrayToSpecfic();
	}

	protected abstract void convertArrayToSpecfic();

	private void readExcelFile() {
		HSSFWorkbook workbook = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(getInputFile()));
			workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheet("Sheet1");
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				String[] objects = new String[row.getLastCellNum()];
				int index = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case BLANK:
						break;
					case BOOLEAN:
						objects[index] = String.valueOf(cell.getBooleanCellValue());
						break;
					case ERROR:
						break;
					case FORMULA:
						break;
					case NUMERIC:
						objects[index] = String.valueOf((int) cell.getNumericCellValue());
						break;
					case STRING:
						objects[index] = cell.getStringCellValue();
						break;
					case _NONE:
						break;
					default:
						break;
					}
					index++;
				}
				list.add(objects);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String getFileExtension(String inputFile) {
		if (inputFile.lastIndexOf(".") != -1 && inputFile.lastIndexOf(".") != 0)
			return inputFile.substring(inputFile.lastIndexOf(".") + 1);
		else
			return "";
	}
}

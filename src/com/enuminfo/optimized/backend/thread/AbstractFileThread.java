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
import java.util.concurrent.Callable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.enuminfo.optimized.backend.model.Base;

/**
 * @author AKURATI
 */
public abstract class AbstractFileThread<T extends Base> implements Callable<Object> {

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
	public Object call() {
		if ((new File(getInputFile()).isFile()) && (getFileExtension(getInputFile()).equals(XLSX_EXTENSION) || getFileExtension(getInputFile()).equals(XLS_EXTENSION))) {
			return readExcelFile();
		} else if ((new File(getInputFile()).isFile()) && getFileExtension(getInputFile()).equals(CSV_EXTENSION)) {
			return readCsvFile();
		} else if (!new File(getInputFile()).isFile()) {
			File[] files = new File(getInputFile()).listFiles();
			for (File file : files) {
				inputFile = file.getAbsolutePath();
				if ((file.isFile()) && (getFileExtension(file.getName()).equals(XLSX_EXTENSION) || getFileExtension(file.getName()).equals(XLS_EXTENSION))) {
					return readExcelFile();
				} else if ((file.isFile()) && getFileExtension(file.getName()).equals(CSV_EXTENSION)) {
					return readCsvFile();
				}
			}
		}
		return getInputFile() + " : " + 0;
	}
	
	private Object readCsvFile() {
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
        return convertArrayToSpecfic();
	}

	protected abstract Object convertArrayToSpecfic();

	private Object readExcelFile() {
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(getInputFile()));
			workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case BLANK:
						break;
					case BOOLEAN:
						break;
					case ERROR:
						break;
					case FORMULA:
						break;
					case NUMERIC:
						break;
					case STRING:
						break;
					case _NONE:
						break;
					default:
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	protected String getFileExtension(String inputFile) {
		if (inputFile.lastIndexOf(".") != -1 && inputFile.lastIndexOf(".") != 0)
			return inputFile.substring(inputFile.lastIndexOf(".") + 1);
		else
			return "";
	}
}

package com.seiryo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.DataFormat;

public class ExcelCreate {

	private HSSFWorkbook wb = null;

	private HSSFSheet sheet = null;

	private HSSFDataFormat format = null;

	private HSSFRow hdRow = null;

	private int listlength = 0;

	/* 添加一行 */
	private int s = 1;

	/**
	 * 设置工作表的格式
	 * 
	 * @param sheetName
	 */
	public ExcelCreate() {
		wb = new HSSFWorkbook();
	}

	public void createSheet(String sheetName) {
		sheet = wb.createSheet(sheetName);
		format = wb.createDataFormat();
		hdRow = sheet.createRow(0);
		sheet.setDefaultRowHeightInPoints(120);
		sheet.setDefaultColumnWidth(12);
	}

	/* 设置各列单元格宽度 */
	public void setDefaultCellHighWidthInRange(short[] eachCellWidth, int high) {
		// 假定第一行和第一行所需的单元个已经建立好了，也就是说，在这之前已经调用了DesignXlsHeaderFooter.setXlsHeader
		sheet.setDefaultRowHeightInPoints(high);// 设置默认高
		/* 设置各列单元格宽度 */
		for (int i = 0; i < eachCellWidth.length; i++) {
			// System.out.print(""+i+"\t");
			sheet.setColumnWidth((short) i, (short) ((eachCellWidth[i]) * 256));
		}
	}

	/**
	 * 表头数据
	 * 
	 * @throws Exception
	 */
	public void addHeader(List rowvalues, boolean isFilter) throws Exception {
		listlength = rowvalues.size();
		// 设置字体
		HSSFFont workFont = wb.createFont();
		workFont.setFontName("微软雅黑");
		workFont.setFontHeightInPoints((short) 14);
		workFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 表头样式及背景色
		HSSFCellStyle hdStyle = wb.createCellStyle();
		hdStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		hdStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		hdStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		hdStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		hdStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		hdStyle.setRightBorderColor(HSSFColor.BLACK.index);
		hdStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		hdStyle.setTopBorderColor(HSSFColor.BLACK.index);
		hdStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		hdStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		hdStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		hdStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		hdStyle.setFont(workFont);

		String[] title = new String[rowvalues.size()];
		for (int i = 0; i < rowvalues.size(); i++) {
			title[i] = (String) rowvalues.get(i);
		}
		HSSFRow dtRow = sheet.createRow((1));
		if (isFilter == true) {
			for (int i = 0; i < title.length; i++) {
				HSSFCell cell1 = hdRow.createCell(i);
				HSSFRichTextString value = new HSSFRichTextString(title[i]);
				cell1.setCellValue(value);
				cell1.setCellStyle(hdStyle);
			}
		} else {
			for (int i = 0; i < title.length; i++) {
				HSSFCell cell2 = dtRow.createCell(i);
				HSSFRichTextString value2 = new HSSFRichTextString(title[i]);
				cell2.setCellValue(value2);
			}
		}
	}

	public void addRow(List rowvalues) {
		HSSFRow dtRow = sheet.createRow(s++);
		DataFormat format = wb.createDataFormat();

		HSSFCellStyle dtStyle = wb.createCellStyle();
		dtStyle.setDataFormat(format.getFormat("text"));
		dtStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dtStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		dtStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dtStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		dtStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dtStyle.setRightBorderColor(HSSFColor.BLACK.index);
		dtStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dtStyle.setTopBorderColor(HSSFColor.BLACK.index);
		dtStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);

		HSSFCellStyle dateStyle = wb.createCellStyle();
		dateStyle.setDataFormat(format.getFormat("yyyy-m-d"));
		dateStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dateStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		dateStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dateStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		dateStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dateStyle.setRightBorderColor(HSSFColor.BLACK.index);
		dateStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dateStyle.setTopBorderColor(HSSFColor.BLACK.index);
		dateStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);

		for (int j = 0; j < rowvalues.size(); j++) {
			String flag = "";
			Object cell_data = rowvalues.get(j);
			HSSFCell cell = dtRow.createCell(j);
			// 正文格式
			if (cell_data instanceof String) {
				flag = "string";
				cell.setCellValue((String) cell_data);
			} else if (cell_data instanceof Double) {
				cell.setCellValue((Double) cell_data);
			} else if (cell_data instanceof Integer) {
				cell.setCellValue(Double.valueOf(String.valueOf(cell_data)));
			} else if (cell_data instanceof Date) {
				flag = "date";
				cell.setCellValue((Date) cell_data);
			} else if (cell_data instanceof Boolean) {
				cell.setCellValue((Boolean) cell_data);
			} else if (cell_data instanceof Float) {
				cell.setCellValue((Float) cell_data);
			}

			// 背景颜色
			// if(s%2!=0)
			// dtStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			// dtStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			if (flag == "" || flag.equals("string")) {
				cell.setCellStyle(dtStyle);
			} else if (flag.equals("date")) {
				cell.setCellStyle(dateStyle);
			}

		}
		// }
	}

	/**
	 * 给指定的行追加一行数据
	 * 
	 * @param rowvalues
	 * @param row
	 */
	public void insertRow(List rowvalues, int row) {
		sheet.shiftRows(row, sheet.getLastRowNum(), 1);
		HSSFRow dtRow = sheet.createRow(row);
		HSSFCellStyle dtStyle = wb.createCellStyle();
		dtStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dtStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		dtStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dtStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		dtStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dtStyle.setRightBorderColor(HSSFColor.BLACK.index);
		dtStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dtStyle.setTopBorderColor(HSSFColor.BLACK.index);
		dtStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		DataFormat format = wb.createDataFormat();
		Short str = format.getFormat("text");
		Short date = format.getFormat("yyyy-m-d");
		for (int j = 0; j < rowvalues.size(); j++) {
			Object cell_data = rowvalues.get(j);
			HSSFCell cell = dtRow.createCell(j);
			if (cell_data instanceof String) {
				dtStyle.setDataFormat(str);
				cell.setCellValue((String) cell_data);
			} else if (cell_data instanceof Double) {
				cell.setCellValue((Double) cell_data);
			} else if (cell_data instanceof Integer) {
				cell.setCellValue(Double.valueOf(String.valueOf(cell_data)));
			} else if (cell_data instanceof Date) {
				dtStyle.setDataFormat(date);
				cell.setCellValue((Date) cell_data);
			} else if (cell_data instanceof Boolean) {
				cell.setCellValue((Boolean) cell_data);
			} else if (cell_data instanceof Float) {
				cell.setCellValue((Float) cell_data);
			}
			// 背景颜色
			// if(s%2!=0)
			// dtStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			// dtStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(dtStyle);
		}
	}

	/**
	 * 删除指定的行
	 * 
	 * @param row
	 */
	public void delRow(int row) {
		if (row > 0) {
			try {
				// HSSFRow dtRow = sheet.getRow(row);
				sheet.shiftRows(row, sheet.getLastRowNum(), -1);
				// sheet.removeRow(dtRow);
			} catch (RuntimeException e) {
				e.printStackTrace();
				System.out.println("error");
			}
		} else {
			System.out.println("错误的");
		}
	}

	/**
	 * 给指定的列给出下拉列表
	 * 
	 * @param row
	 * @param cells
	 * @param list
	 */
	public void setSelect(int row, int cells, List cellvalue) {
		String[] str = new String[cellvalue.size()];
		for (int i = 0; i < cellvalue.size(); i++) {
			str[i] = (String) cellvalue.get(i);
		}
		CellRangeAddressList regions = new CellRangeAddressList(row, 65535,
				cells, cells);
		DVConstraint constraint = DVConstraint
				.createExplicitListConstraint(str);
		HSSFDataValidation dataValidate = new HSSFDataValidation(regions,
				constraint);
		sheet.addValidationData(dataValidate); // 加入数据有效性到当前sheet对象
	}

	/**
	 * 合并单元格//左上角到右下角int col1,int row1,int col2,int row2
	 */
	// public void hebing(){
	// HSSFRow row = sheet.createRow(0);
	// HSSFCell cell = row.createCell(0);
	// cell.setCellValue(sheetName);
	// sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 5));
	// }

	/**
	 * 具体文件生成的路径
	 * 
	 * @param file
	 * @throws Exception
	 */
	public void exportExcel(String file) throws Exception {
		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();
	}

	/**
	 * 具体文件生成的文件
	 * 
	 * @param file
	 * @throws Exception
	 */
	public void exportExcel(File file) throws Exception {
		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();
	}

	/**
	 * 具体文件生成的文件
	 * 
	 * @param file
	 * @throws Exception
	 */
	public void exportExcel(OutputStream outputstream) throws Exception {
		BufferedOutputStream buffout = new BufferedOutputStream(outputstream);
		wb.write(buffout);
		buffout.flush();
		buffout.close();
	}

	/**
	 * 支持多类型下载
	 * @param filePath
	 * @param response
	 * @param fileName
	 * @param fileType
	 * @return
	 * @throws Exception
	 */
	public static boolean downLoadFile(String filePath,
			HttpServletResponse response, String fileName, String fileType)
			throws Exception {
		File file = new File(filePath); // 根据文件路径获得File文件
		// 设置文件类型(这样设置就不止是下Excel文件了，一举多得)
		if ("pdf".equals(fileType)) {
			response.setContentType("application/pdf;charset=GBK");
		} else if ("xls".equals(fileType)) {
			response.setContentType("application/msexcel;charset=GBK");
		} else if ("doc".equals(fileType)) {
			response.setContentType("application/msword;charset=GBK");
		}
		// 文件名
		response.setHeader("Content-Disposition", "attachment;filename=\""
				+ new String(fileName.getBytes(), "ISO8859-1") + "\"");
		response.setContentLength((int) file.length());
		byte[] buffer = new byte[4096];// 缓冲区
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		try {
			output = new BufferedOutputStream(response.getOutputStream());
			input = new BufferedInputStream(new FileInputStream(file));
			int n = -1;
			// 遍历，开始下载
			while ((n = input.read(buffer, 0, 4096)) > -1) {
				output.write(buffer, 0, n);
			}
			output.flush(); // 不可少
			response.flushBuffer();// 不可少
		} catch (Exception e) {
			// 异常自己捕捉
		} finally {
			// 关闭流，不可少
			if (input != null)
				input.close();
			if (output != null)
				output.close();
		}
		return true;
	}

	/**
	 * excel表格下载
	 * @param path
	 * @param response
	 */
	public void download(String path, HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(filename.getBytes("GB2312"),"ISO8859-1")); 
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/msexcel;charset=utf-8");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}

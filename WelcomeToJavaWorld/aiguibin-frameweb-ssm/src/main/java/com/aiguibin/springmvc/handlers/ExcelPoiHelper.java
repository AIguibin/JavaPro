package com.tansun.frame.ssm.comm;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author AIguibin
 *
 */
public class ExcelPoiHelper {
	/**
	 * 2003- 版本的excel
	 */
	private final static String XLS =".xls";
	/**
	 * 2007+ 版本的excel
	 */
    private final static String XLSX =".xlsx";

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     */
    public static  Workbook getWorkbookByExcelType(InputStream inStr,String fileName) throws Exception{
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if(XLS.equals(fileType)){
            //2003-
            wb = new HSSFWorkbook(inStr);
        }else if(XLSX.equals(fileType)){
            //2007+
            wb = new XSSFWorkbook(inStr);
        }else{
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 判断文件是否是excel
     * @throws Exception
     */
    public static void checkExcelVaild(File file) throws Exception{
        if(!file.exists()){
            throw new Exception("文件不存在");
        }
        if(!(file.isFile() && (file.getName().endsWith(XLS) || file.getName().endsWith(XLSX)))){
            throw new Exception("文件不是Excel");
        }
    }
}

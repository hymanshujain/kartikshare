package com.qa.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import cucumber.api.DataTable;
import cucumber.api.Transformer;
import cucumber.runtime.ParameterInfo;
import cucumber.runtime.table.TableConverter;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.formatter.model.Comment;
import gherkin.formatter.model.DataTableRow;

public class ExcelDataToDataTable extends Transformer<DataTable>
{

	@Override
	public DataTable transform(String filePath)
	{
		ExcelReader reader = new ExcelReader.ExcelReaderBuilder()
				.setFileLocation(filePath)
				.setSheet(0)
				.build();
		
		List<List<String>> excelData;
		DataTable table = null;
		try 
		{
			excelData = getExcelData(reader);
			List<DataTableRow> dataTableRows = getDataTableRows(excelData);
			
			table = getDataTable(dataTableRows);
			
		}
		catch (InvalidFormatException e) 
		{
			e.printStackTrace();
		}
		
		return table;
	}

	private DataTable getDataTable(List<DataTableRow> dataTableRows)
	{
		ParameterInfo parameterInfo = new ParameterInfo(null, null, null, null);
	    TableConverter tableConverter = new TableConverter(new LocalizedXStreams(Thread.currentThread().getContextClassLoader()).get(Locale.getDefault()), parameterInfo);
		
		DataTable table = new DataTable(dataTableRows, tableConverter);
		return table;
	}

	private List<DataTableRow> getDataTableRows(List<List<String>> excelData) {
		List<DataTableRow> dataTableRows = new LinkedList<DataTableRow>();
		int line = 1;
		
		for(List<String> list : excelData)
		{
			Comment commnet = new Comment("", line);
			DataTableRow tableRow = new DataTableRow(Arrays.asList(commnet), list, line++);
			dataTableRows.add(tableRow);
		}
		return dataTableRows;
	}

	private List<List<String>> getExcelData(ExcelReader reader) throws InvalidFormatException {
		List<List<String>> excelData = new LinkedList<List<String>>();
		
		try 
		{
			excelData = reader.getSheetDataAt();
		} 
		catch (  IOException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
		return excelData;
	}

}

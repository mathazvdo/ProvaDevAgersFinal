package br.com.soc.sistema.relatorio;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.soc.sistema.vo.ExameFuncionarioVo;

public class ExamesFuncionarioRelatorio {
	
	private static final String ARQUIVO_RELATORIO = "C:\\Users\\Cloudi\\Documents\\projeto\\relatorio xls\\relatorio.xls";
	
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Relatório de Exames Funcionarios");
	
	public void gerarRelatorioExames (List<ExameFuncionarioVo> examesFuncionarios) {
		int rownum = 0;
		
        Row headerRow = sheet.createRow(rownum++);
        int headerCellNum = 0;
        headerRow.createCell(headerCellNum++).setCellValue("ID do Funcionário");
        headerRow.createCell(headerCellNum++).setCellValue("Nome do Funcionário");
        headerRow.createCell(headerCellNum++).setCellValue("ID do Exame");
        headerRow.createCell(headerCellNum++).setCellValue("Nome do Exame");
        headerRow.createCell(headerCellNum++).setCellValue("Data do Exame");
		
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        HSSFDataFormat dateFormat = workbook.createDataFormat();
        dateCellStyle.setDataFormat(dateFormat.getFormat("dd/mm/yyyy"));
        
		for (ExameFuncionarioVo examesFuncionario : examesFuncionarios) {
			Row row = sheet.createRow(rownum++);
			int cellNum = 0;
			Cell cellIdFuncionario = row.createCell(cellNum++);
			cellIdFuncionario.setCellValue(examesFuncionario.getFuncionarioVo().getRowid());
			Cell cellNomeFuncionario = row.createCell(cellNum++);
			cellNomeFuncionario.setCellValue(examesFuncionario.getFuncionarioVo().getNome());
			Cell cellIdExame = row.createCell(cellNum++);
			cellIdExame.setCellValue(examesFuncionario.getExameVo().getRowid());
			Cell cellNomeExame = row.createCell(cellNum++);
			cellNomeExame.setCellValue(examesFuncionario.getExameVo().getNome());
            Cell cellDataExame = row.createCell(cellNum++);
            cellDataExame.setCellValue(examesFuncionario.getDataDoExame());
            cellDataExame.setCellStyle(dateCellStyle);
		}
		
		try {
			FileOutputStream out = new FileOutputStream(new File(ARQUIVO_RELATORIO));
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

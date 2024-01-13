package Dao;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

/**
 * 将数据库表导出为Excel文件的工具类。
 */
public class ExportToExcel {

    public static void main(String[] args) {
        // 数据库连接信息
        String jdbcUrl = "jdbc:mysql://192.168.207.136:3306/homework_test?";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // 分别导出各个表格到Excel文件
            exportTableToExcel(connection, "t_admin", "D:\\Java_project\\ClassHomework\\Homework_test\\Excel表\\管理员表.xlsx");
            exportTableToExcel(connection, "t_apply", "D:\\Java_project\\ClassHomework\\Homework_test\\Excel表\\奖学金申请表.xlsx");
            exportTableToExcel(connection, "t_scholarship", "D:\\Java_project\\ClassHomework\\Homework_test\\Excel表\\奖学金表.xlsx");
            exportTableToExcel(connection, "t_student", "D:\\Java_project\\ClassHomework\\Homework_test\\Excel表\\学生表.xlsx");
            exportTableToExcel(connection, "t_teacher", "D:\\Java_project\\ClassHomework\\Homework_test\\Excel表\\辅导员表.xlsx");

            System.out.println("文件创建成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将数据库表导出为Excel文件。
     *
     * @param connection 数据库连接
     * @param tableName  表名
     * @param outputPath 导出文件路径
     */
    private static void exportTableToExcel(Connection connection, String tableName, String outputPath) {
        String sql = "SELECT * FROM " + tableName;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(tableName);

            java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // 创建表头行
            Row headerRow = sheet.createRow(0);
            for (int i = 1; i <= columnCount; i++) {
                Cell cell = headerRow.createCell(i - 1);
                cell.setCellValue(metaData.getColumnName(i));
            }

            int rowNum = 1;
            // 填充数据行
            while (resultSet.next()) {
                Row dataRow = sheet.createRow(rowNum++);
                for (int i = 1; i <= columnCount; i++) {
                    Cell cell = dataRow.createCell(i - 1);
                    cell.setCellValue(resultSet.getString(i));
                }
            }

            // 写入Excel文件
            try (FileOutputStream fileOut = new FileOutputStream(outputPath)) {
                workbook.write(fileOut);
            }

            System.out.println("已经导出表 " + tableName + " 到Excel文件: " + outputPath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
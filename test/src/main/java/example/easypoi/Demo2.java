package example.easypoi;



import com.github.sd4324530.fastexcel.FastExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/31 21:12
 */
public class Demo2 {

    public static void main(String[] args) throws IOException, InvalidFormatException {

        File file = new File("H:\\check.xlsx");

        //List<Demo3> read = ExcelUtils.read(new FileInputStream(file),Demo3.class);
        FastExcel fastExcel = new FastExcel(new FileInputStream(file));
        fastExcel.setSheetName("Sheet2");
        List<Demo4> parse = fastExcel.parse(Demo4.class);
        System.out.println(parse.toString());


    }
}

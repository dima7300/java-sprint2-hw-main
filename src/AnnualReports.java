import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
public class AnnualReports {
    protected int[] month = new int[3];
    private int amount;
    private boolean is_expense;
     //трата
    protected Integer[] sumYearTrue = new Integer[3];
    //доход
    protected Integer[] sumYearFalse = new Integer[3];
    File dirWay = new File("src/recourses"); // создаем объект для вывода файлов
    List<File> lst2 = Arrays.asList(dirWay.listFiles());


    List<String> readFileContents(String path) { //считывание файла из ТЗ
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

    public void summYears (){
        int a =0;
        int b =0;
        for (int i = 1; i < readFileContents("src/recourses/y.2021.csv").size(); i++ ){
            String ioi = readFileContents("src/recourses/y.2021.csv").get(i);
            String[] lineContents = ioi.split(",");
//            month = parseInt(lineContents[0]);
            amount = parseInt(lineContents[1]);
            is_expense = parseBoolean(lineContents[2]);
            if (is_expense == true){ //трата
                sumYearTrue[a] = amount;
                month[a] = parseInt(lineContents[0]);
                a++;
            }else { //доход
                sumYearFalse[b] = amount;
                b++;
            }

        }
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class MonthlyReports {
    protected String item_name;
    protected String item_nameFalce;
    private boolean is_expense;
    private int quantity;
    private int sum_of_one;
    protected int sumMonthTrue = 0; //трата
    protected int sumMonthFalse = 0;// доход
    protected int monthTrueMonth = 0;
    protected int monthFalceMonth = 0;

    protected Integer[] monthTrue = new Integer[3]; // общая трата по каждому месяцу
    protected Integer[] monthFalce = new Integer[3]; // общая трата по каждому месяцу
    protected  int maxItem_name = 0;
    protected int minItem_name = 0;

    List<String> readFileContents(String path) { //считывание файла из ТЗ
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

    public void summMonthly() {  //Считать все меячные отчеты
        int monthMonth = 0;
        for (int i = 1; i <= 3; i++) {
            monthMonth++;
            int oneMonthTrue = 0;
            int oneMonthFalce = 0;


            for (int b = 1; b < readFileContents("src/recourses/m.20210" + i + ".csv").size(); b++) {
                //проходим циклом по файлу recourses (1 цикл)
                String ioi = readFileContents("src/recourses/m.20210" + i + ".csv").get(b);
                //залетаем в текстовый файл через цикл (2)
                // возвращаем через get и присваимаем переменной ioi данные по объекту
                String[] lineContents = ioi.split(","); // метод сплит (разделение)
//                System.out.println(lineContents[3]);// проверка
//                Arrays.stream(lineContents).forEach(System.out::println);
                sum_of_one = parseInt(lineContents[3]);
                quantity = parseInt(lineContents[2]);
                is_expense = parseBoolean(lineContents[1]);
//
                if (is_expense == true) { //трата
                    sumMonthTrue = sumMonthTrue + (sum_of_one * quantity); //сумма всех трат за месяцы
                    oneMonthTrue = oneMonthTrue + (sum_of_one * quantity); // сумма трат за 1 месяц
                    if(maxItem_name < sum_of_one*quantity){
                        maxItem_name = sum_of_one * quantity;
                        item_name = lineContents[0];
                        monthTrueMonth = monthMonth;
                    }
                } else { //доход
                    sumMonthFalse = sumMonthFalse + (sum_of_one * quantity);
                    oneMonthFalce = oneMonthFalce + (sum_of_one * quantity);
                    if (minItem_name < sum_of_one*quantity){
                        minItem_name = sum_of_one*quantity;
                        item_nameFalce = lineContents[0];
                        monthFalceMonth = monthMonth;
                    }
                }
            }
            monthTrue[i-1] = oneMonthTrue; //добавление в массив суммы трат за каждый месяц
            monthFalce[i-1] = oneMonthFalce;
        }
    }
}

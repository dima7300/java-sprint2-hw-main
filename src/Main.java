import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        MonthlyReports MonthlyReports = new MonthlyReports();
        AnnualReports AnnualReports = new AnnualReports();
        Scanner scanner = new Scanner(System.in);
        int command ;
        while (true) {
            try {
                System.out.println("Выберите действие  \n" +
                        "1 - Считать все месячные отчёты\n" +
                        "2 - Считать годовой отчёт\n" +
                        "3 - Сверить отчёты\n" +
                        "4 - Вывести информацию о всех месячных отчётах\n" +
                        "5 - Вывести информацию о годовом отчёте\n" +
                        "0 - ВЫХОД");

                command = scanner.nextInt();
                if (command == 1) {
                MonthlyReports.summMonthly();
                    System.out.println("        Месячные отчеты считаны \n");

                } else if (command == 2) {
                    AnnualReports.summYears();
                    System.out.println("        Годовой отчет считан \n");
                } else if (command == 3) {
                    for (int i = 0; i < AnnualReports.month.length; i++){
                        if (!Objects.equals(MonthlyReports.monthTrue[i], AnnualReports.sumYearTrue[i])){
                            System.out.println("Обнаружено несоответствие в тратах месяц " + AnnualReports.month[i]);
                            break;
                        } else if (!Objects.equals(MonthlyReports.monthFalce[i], AnnualReports.sumYearFalse[i])) {
                            System.out.println("Обнаружено несоответствие в прибыли месяц " + AnnualReports.month[i]);
                            break;
                        } else {
                            if (i == AnnualReports.month.length -1) {
                                System.out.println("Операция завершена успешно, ошибок нет ");
                            }
                        }
                    }

                } else if (command == 4) {
                    System.out.println("Максимальная прибыль за "+ MonthlyReports.monthFalceMonth + " месяц " +MonthlyReports.minItem_name+" "+MonthlyReports.item_nameFalce);
                    System.out.println("Максимальная трата за "+MonthlyReports.monthTrueMonth+ " месяц " +MonthlyReports.maxItem_name+" "+MonthlyReports.item_name);

                } else if (command == 5) {
                    System.out.println("Прибыль за 2021 год: файл "+ AnnualReports.lst2.get(0));
                    for (int i = 0; i < AnnualReports.month.length; i++){
                        System.out.println(AnnualReports.sumYearFalse[i] - AnnualReports.sumYearTrue[i] + "  месяц "+ AnnualReports.month[i]);
                    }
                    System.out.println("------------------------------\n" +
                            "Средние доходы и раcходы: \n");
                    int middleTrue = 0;
                    int middleFalce = 0;
                    for (int i = 0; i < AnnualReports.month.length; i++){
                        middleFalce = middleFalce + AnnualReports.sumYearFalse[i];
                        middleTrue = middleTrue + AnnualReports.sumYearTrue[i];
                    }
                    middleFalce = middleFalce/AnnualReports.sumYearFalse.length;
                    middleTrue = middleTrue/AnnualReports.sumYearTrue.length;
                    System.out.println("Средний доход за все месяцы = " + middleFalce);
                    System.out.println("Средний расход за все месяцы = " + middleTrue);


                } else if (command == 0) {
                    break;
                } else {
                    System.out.println("такой команды нет");
                }
            } catch (Exception e){
                System.out.println("такой команды нет, ошибка, введите число");
                scanner.next();
            }

        }
    }
}



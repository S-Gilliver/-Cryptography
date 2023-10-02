import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Code2 {
    public static void main(String[] args) {
        // Задаем две даты в формате "ГГГГ-ММ-ДД"
        String date1Str = "2023-10-02"; // Дата занятия
        String date2Str = "2005-02-22"; // Замените на свою дату рождения

        // Преобразуем строки в объекты LocalDate
        LocalDate date1 = LocalDate.parse(date1Str);
        LocalDate date2 = LocalDate.parse(date2Str);

        // Вычисляем разницу в днях между датами
        long daysDifference = ChronoUnit.DAYS.between(date1, date2);

        // Находим НОД с использованием алгоритма Евклида
        long gcd = findGCD(Math.abs(daysDifference), 365); // 365 - количество дней в году

        // Выводим результат
        System.out.println("Наибольший общий делитель (НОД) между " + date1Str + " и " + date2Str + " равен " + gcd);
    }

    // Реализация алгоритма Евклида для нахождения НОД
    public static long findGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}

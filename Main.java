package part_02.prakticheskoe_zadanie_2;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    private static String[][] strokoviiArray = new String[4][4];//двумерный строковый массив размером 4х4 - верный размер
    private static String[][] strokoviiArrayError = new String[5][5];//двумерный строковый массив размером 5х5 - НЕ верный размер, но большего размера
    private static String[][] strokoviiArrayError2 = new String[3][3];//двумерный строковый массив размером 3х3 - НЕ верный размер(меньшего размера, чем надо)

    public static void main(String[] args) throws InterruptedException {

        privetstvieProgrammi();

        viborDeistvya();

    }

    private static void punkt2() throws InterruptedException {
        //заполняем массив единицами
        for (int i = 0; i < strokoviiArray.length; i++) {
            for (int j = 0; j < strokoviiArray[3].length; j++) {
                strokoviiArray[i][j] = "1";
            }
        }
        vivodimMassivNaEkran(strokoviiArray, "Массив 4х4:");
        //складываем все элементы массива
        int summaElementovMassiva = 0;
        for (int i = 0; i < strokoviiArray.length; i++) {
            for (int j = 0; j < strokoviiArray[3].length; j++) {
                summaElementovMassiva += Integer.parseInt(strokoviiArray[i][j]);
            }
        }
        System.out.println("Сумма элементов массива 4х4: " + summaElementovMassiva);
        //Задаём один из элементов массива не целым числом, чтобы в последствии вызвать исключение MyArrayDataException
        strokoviiArray[2][3] = "поППа";
        //выводим массив на экран
        vivodimMassivNaEkran(strokoviiArray, "Массив 4х4:");
        summaElementovMassiva = 0;
        int row = 0;
        int column = 0;
        /*        try {*/
        try {
            for (int i = 0; i < strokoviiArray.length; i++) {
                for (int j = 0; j < strokoviiArray[3].length; j++) {
                    row = i;
                    column = j;
                    summaElementovMassiva += Integer.parseInt(strokoviiArray[i][j]);
                }
            }
        } catch (IllegalArgumentException e) {//здесь возникает исключение public class NumberFormatException extends IllegalArgumentException Exception
            String message = " Строка: " + String.valueOf(row + 1) + ", столбец: " + String.valueOf(column + 1);
//                System.out.println("Здесь");
            throw new MyArrayDataException(message);//я написал MyArrayDataException обработчик исключения, но программа прерывается и дальше не идёт. Почему-бы здесь просто не обработать исключение и всё
        } finally {
            System.out.println("Сумма успешно посчитанных элементов массива 4х4: " + summaElementovMassiva);
        }
/*        } catch (Exception e) {
        }*/
        ;
    }

    private static void punkt4() {
        System.out.println("\nМАССИВ НЕ ВЕРНОГО РАЗМЕРА, НО БОЛЬШЕГО РАЗМЕРА, РУГАЕМСЯ НА ЭТО, НО ДАЁМ ВЫПОЛНИТЬ ПРОГРАММУ");
        poschitatSummuElementovMassiva(strokoviiArrayError);//отправляем массив не верного размера, но большего размера, ругаемся на это, но даём выполнить программу
        System.out.println("\nМАССИВ НЕ ВЕРНОГО РАЗМЕРА(МЕНЬШЕГО РАЗМЕРА), РУГАЕМСЯ НА ЭТО И ВЫХОДИМ ИЗ ПРОГРАММЫ");
        poschitatSummuElementovMassiva(strokoviiArrayError2);//отправляем массив не верного размера(меньшего размера) ругаемся на это и выходим из программы
        System.out.println("\nМАССИВ ПРАВИЛЬНОГО РАЗМЕРА, ПРОСТО ОТРАБАТЫВАЕМ ИСКЛЮЧЕНИЕ, ГДЕ ВМЕСТО ЦЕЛОГО ЧИСЛА БУКВЫ");
        poschitatSummuElementovMassiva(strokoviiArray);//отправляем массив правильного размера
    }

    private static void poschitatSummuElementovMassiva(String[][] strokoviiArray) {
        if (strokoviiArray.length < 4) {
            System.out.println("Вы задали не верный размер массива, у Вас строк: " + strokoviiArray.length + ", а должно быть четыре строки");
            return;
        }
        if (strokoviiArray[3].length < 4) {
            System.out.println("Вы задали не верный размер массива, у Вас столбцов: " + strokoviiArray[3].length + ", а должно быть четыре столбца");
            return;
        }
        if (strokoviiArray.length > 4) {
            System.out.println("Вы задали не верный размер массива, у Вас строк: " + strokoviiArray.length + ", а должно быть четыре строки, это не верный размер массива, но он больше, чем 4х4 и мы с ним будем сейчас работать.");
            System.out.println("Все вычисления будут выполнены для массива размером 4х4.");
        } else {
            if (strokoviiArray[3].length > 4) {
                System.out.println("Вы задали не верный размер массива, у Вас столбцов: " + strokoviiArray.length + ", а должно быть четыре столбца, это не верный размер массива, но он больше, чем 4х4 и мы с ним будем сейчас работать.");
                System.out.println("Все вычисления будут выполнены для массива размером 4х4.");
            }
        }
        //заполняем массив единицами
        for (int i = 0; i < strokoviiArray.length; i++) {
            for (int j = 0; j < strokoviiArray[3].length; j++) {
                strokoviiArray[i][j] = "1";
            }
        }
        vivodimMassivNaEkran(strokoviiArray, "Массив " + strokoviiArray.length + "х" + strokoviiArray[strokoviiArray.length - 1].length + ":");
        //складываем все элементы массива
        int summaElementovMassiva = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                summaElementovMassiva += Integer.parseInt(strokoviiArray[i][j]);
            }
        }
        System.out.println("Сумма элементов массива 4х4: " + summaElementovMassiva);
        //Задаём один из элементов массива не целым числом, чтобы в последствии вызвать исключение MyArrayDataException
        strokoviiArray[2][3] = "поППа";
        //выводим массив на экран
        vivodimMassivNaEkran(strokoviiArray, "Массив " + strokoviiArray.length + "х" + strokoviiArray[strokoviiArray.length - 1].length + ":");
        summaElementovMassiva = 0;
        int vsegoPoschitano = 0;
        int row = 0;
        int column = 0;
        try {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    row = i;
                    column = j;
                    summaElementovMassiva += Integer.parseInt(strokoviiArray[i][j]);
                    vsegoPoschitano++;
                }
            }
        } catch (IllegalArgumentException e) {//здесь возникает исключение public class NumberFormatException extends IllegalArgumentException Exception
            String message = "НЕ верное число в массиве!" + " Строка: " + String.valueOf(row + 1) + ", столбец: " + String.valueOf(column + 1);
            System.out.println(message);
        } finally {
            System.out.println("Сумма успешно посчитанных элементов массива 4х4: " + summaElementovMassiva + ", всего было посчитано: " + vsegoPoschitano + " шт. элементов.");
        }
    }

    private static void vivodimMassivNaEkran(String[][] strokoviiArray, String message) {
        //выводим массив на экран
        System.out.println(message);
        for (int i = 0; i < strokoviiArray.length; i++) {
            for (int j = 0; j < strokoviiArray[3].length; j++) {
                System.out.print(strokoviiArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Последовательно отправляем два строковых массива, один размером 4х4 - верный, другой не верный
    private static void punkt1(String[][] strokoviiArray) {
        try {
            prinStrokoviiMassiv(strokoviiArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            prinStrokoviiMassiv(strokoviiArrayError);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }

    //метод, на вход которого подается двумерный строковый массив размером 4х4
    private static void prinStrokoviiMassiv(String[][] array) throws MyArraySizeException {
        if (array.length != 4 || array[3].length != 4) {
            System.out.print(array.length + " х " + array[3].length + " ");
            throw new MyArraySizeException();
        } else {
            System.out.print(array.length + " х " + array[3].length + " - верный размер массива.");//Можно ещё отдельно писать, какой именно размер не верный, по горизонтали или по вертикали, но это не цель данного домашнего задания, т.к. улучшать здесь можно достаточно много и долго
        }

    }

    //создаём исключение MyArraySizeException - будем его вызывать, в случае не верного размера массива
    public static class MyArraySizeException extends RuntimeException {
        public MyArraySizeException() {
            super("НЕ верный размер массива!");
        }
    }

    //создаём исключение MyArrayDataException - будем его вызывать, в случае, если в элементе массива не число
    public static class MyArrayDataException extends RuntimeException {
        public MyArrayDataException(String message) {
            super("НЕ верное число в массиве!" + message);
        }
    }

    private static void viborDeistvya() throws InterruptedException {
        int vibordeistviya;
        do {
            vibordeistviya = vvodTselogoCHhisla(1, 4, "Выберите какую информацию вывести в консоль");
            if (vibordeistviya != -100) {
            } else {
                System.out.print("Вы ошиблись. ");
            }
            if (vibordeistviya == 1) {
                System.out.println();
                System.out.println("Выполнение задания, пункт 1:");
                punkt1(strokoviiArray);
            }
            if (vibordeistviya == 2) {
                System.out.println();
                System.out.println("Выполнение задания, пункт 2:");
                punkt2();
            }
            if (vibordeistviya == 3) {
                System.out.println();
                System.out.println("Выполнение задания, пункт 3:");
                System.out.println("Пункт 3 это пункт 1+2, не стал усложнять и без того теперь запутанный код. Посмотрите, моё решение, выбрав 4.");
                System.out.println("Возможно с точки зрения работы с исключениями это и не очень хорошо, но работает и суть исключений я уловил :-).");
            }
            if (vibordeistviya == 4) {
                System.out.println();
                System.out.println("Чтобы обработать возможные исключения, я-бы сделал так:");
                punkt4();
            }
        }
        while (vibordeistviya == -100);
        if (!vixodIzProgrammi()) {//надо будет привыкнуть к такому написанию
            privetstvieProgrammi();
            viborDeistvya();
        }
    }

    private static void privetstvieProgrammi() {
        System.out.println("\n---=== Практическое задание к уроку № 2 Исключения ===---");
        System.out.println("                     Сделал Иван Булкин");
        System.out.println("1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.");
        System.out.println("2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.");
        System.out.println("   Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.");
        System.out.println("3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.");
        System.out.println();
        System.out.println("1. Выполнение задания, пункт 1;");
        System.out.println("2. Выполнение задания, пункт 2;");
        System.out.println("3. Выполнение задания, пункт 3;");
        System.out.println("4. Чтобы обработать возможные исключения, я-бы сделал так;");
    }

    //Универсальная процедура ввода целого числа, буду её использовать в других программах
    //На вход процедуры передаём от какого до какого числа пользовательо должен ввести число
    //min_znachenie - меньше этого числа вводить нельзя
    //max_znachenie - больше этого числа вводить нельзя
    //возвращает -100, если число введено не верно и возвращает целое число, если число введено верно и в нужном интервале
    //message - сообщение пользователю о том, что именно надо вводить
    private static int vvodTselogoCHhisla(int minZnachenie, int maxZnachenie, String message) {
        System.out.print(message + ", введите число от " + minZnachenie + " до " + maxZnachenie + ": ");
        int vvedennoechislo = -100;
        if (in.hasNextInt()) {
            vvedennoechislo = in.nextInt();
            if (vvedennoechislo < minZnachenie || vvedennoechislo > maxZnachenie) {
                vvedennoechislo = -100;
            }
        } else {
            in.next();
        }
        return vvedennoechislo;
    }

    //Универсальная процедура выхода из программы, буду её использовать в других программах
    //Выходит из программы, если пользователь выбирает "y", "yes", "д", "да", "+", "торжественно подтверждаю"
    //Возвращает false, если пользователь выбирает "n", "н", "-", "играть, так играть, продолжаем"
    //продолжает спрашивать о выходе, если пользователь ввёл любое другое значение
    private static boolean vixodIzProgrammi() {
        System.out.println("\nВыходим из программы, Вы уверены? y/n (д/н)");
        String n = in.next();
        switch (n) {
            case "y", "yes", "д", "да", "+", "торжественно подтверждаю" -> {
                System.out.println("\nДо новых встреч, ждём Вас снова.");
                in.close();//Необходимо закрыть объект in
                System.exit(0);
            }
            case "n", "н", "-", "играть, так играть, продолжаем" -> {
                System.out.println();
                return false;
            }
            default -> {
                System.out.printf("Вы ввели: " + n + ", такого значения нет в списке%n" + "Выберите y/n или д/н и попробуйте ещё разик.");
                vixodIzProgrammi();
            }
        }
        return false;
    }
}

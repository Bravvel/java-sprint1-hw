import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 1){
                System.out.println("Введите месяц: ");
                int month;
                while(true) { // проверка на корректный ввод месяца
                    month = scanner.nextInt();//ввод месяца начинается с 1
                    if(month < 1 || month > 12){
                        System.out.println("Номер месяца не может быть меньше 1 и больше 12, введите корректный месяц");
                    }else{
                        break;
                    }
                }
                System.out.println("Введите день: ");
                int day;
                while(true) { // проверка на корректный ввод дня
                    day = scanner.nextInt();//ввод дня начинается с 1
                    if(day < 1 || day > 30){
                        System.out.println("Номер дня не может быть меньше 1 и больше 30, введите корректный день");
                    }else{
                        break;
                    }
                }
                while(true) {
                    System.out.println("Сколько шагов вы прошли в этот день?");
                    double stepsPerDay = scanner.nextDouble();
                    if (stepsPerDay < 0) {
                        System.out.println("Количество шагов не должно быть отрицательным, введите корректное число шагов");
                    }else{
                        stepTracker.newSteps(month, day, stepsPerDay);
                        break;
                    }
                }

            }else if (command == 2){
                System.out.println("За какой месяц вы бы хотели увидеть статистику ?");
                int month = scanner.nextInt(); //ввод месяца начинается с 1
                stepTracker.printStatistics(month);
            }else if (command == 3){
                System.out.println("Введите новое значение целевого количества шагов: ");
                while(true) {
                    double goalSteps = scanner.nextDouble();
                    if(goalSteps < 0){
                        System.out.println("Количество шагов не должно быть отрицательным, введите корректное число шагов");
                    }else{
                        stepTracker.changeGoalSteps(goalSteps);
                        break;
                    }
                }
            }else if (command == 4){
                System.out.println("Выход");
                break;
            }else{
                System.out.println("Извините, такой команды пока что не существует");
            }
        }
    }

    public static void printMenu(){
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}
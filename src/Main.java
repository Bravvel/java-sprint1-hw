import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 1){
                System.out.println("Введите месяц: ");
                int month = scanner.nextInt();//ввод месяца начинается с 1
                System.out.println("Введите день: ");
                int day = scanner.nextInt();//ввод дня начинается с 1
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
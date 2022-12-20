public class StepTracker {
    double[][] monthToData;
    private Converter converter;
    double goalSteps = 10000;
    void changeGoalSteps(double steps){ // изменение значения целевого кол-ва шагов
        goalSteps = steps;
    }
    void newSteps(int month, int day, double steps){ // добавление в массив нового значения пройденных шагов за день
        monthToData[month-1][day-1] = steps;
    }
    void stepsPerDayToScreen(int month){ // вывод кол-ва пройденных шагов за каждый день в определенном месяце
        for(int i = 0; i < 29; i++){
            System.out.print((i+1) + " день: " + monthToData[month-1][i] + ", ");
        }
        System.out.println(30 + " день: " + monthToData[month-1][29]);
    }
     double allStepsPerMonth(int month){ // подсчёт суммарного кол-ва пройденных шагов за месяц
        double sum = 0;
        for(int i = 0; i < 30; i++)
            sum += monthToData[month - 1][i];
        return sum;
    }
    void maxStepsInMonth(int month){ // нахождение максимального значения пройденных шагов за день в определённом месяце
        double maxSteps = -1;
        for(int i = 0; i < 30; i++){
            if(maxSteps < monthToData[month-1][i]){
                maxSteps = monthToData[month-1][i];
            }
        }
        System.out.println("За этот месяц максимально вы прошли " + maxSteps + " шагов");
    }
    void averageStepsPerMonth(int month){ // среднее кол-во пройденных шагов в день за месяц
        double sum = 0;
        for(int i = 0; i < 30; i++)
            sum += monthToData[month - 1][i];
        double averageSteps = sum/30;
        System.out.println("В среднем в этом месяце за день вы проходили " + averageSteps + " шагов");
    }
    void bestSeriesPerMonth(int month){
        int bestSeries = 0;
        int prevBestSeries = 0;
        for(int i = 0; i < 30; i++){
            if(monthToData[month-1][i] >= goalSteps){
                bestSeries++;
            }else{
                if(prevBestSeries < bestSeries) {
                    prevBestSeries = bestSeries;
                }
                bestSeries = 0;
            }
        }
        if(bestSeries < prevBestSeries) bestSeries = prevBestSeries;
        System.out.println("Максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого " + bestSeries);
    }
    void printStatistics(int month){ // вывод статистики
        stepsPerDayToScreen(month);
        System.out.println("За этот месяц вы прошли " + allStepsPerMonth(month) + " шагов");
        maxStepsInMonth(month);
        averageStepsPerMonth(month);
        System.out.println("За этот месяц вы прошли " + converter.allDistance(allStepsPerMonth(month)) + " метров");
        System.out.println("За этот месяц с помощью ходьбы вы сожгли " + converter.countCalories(allStepsPerMonth(month)) + " ккал");
        bestSeriesPerMonth(month);
    }
    public StepTracker(){
        monthToData = new double[12][30];
        converter = new Converter();
    }

}

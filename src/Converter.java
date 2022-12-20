public class Converter{
    double allDistance(double steps){ // перевод шагов в метры
        double distance = steps * 0.75;
        return distance;
    }
    double countCalories(double steps){ // перевод шагов в калории
        double kiloCalories = steps * 0.05;
        return kiloCalories;
    }

}

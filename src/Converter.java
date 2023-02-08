public class Converter{
    double kilo = 0.001;
    double allDistance(double steps){ // перевод шагов в метры
        return steps * 0.75 * kilo;
    }
    double countCalories(double steps){ // перевод шагов в калории
        return steps * 50 * kilo;
    }

}

public class Converter{
    double allDistance(double steps){ // перевод шагов в метры
        return steps * 0.75 * 0.001;
    }
    double countCalories(double steps){ // перевод шагов в калории
        return steps * 0.05;
    }

}

public class Converter{
    private StepTracker stepTracker;
    double allDistance(int month){
        double steps = stepTracker.allStepsPerMonth(month);
        double distance = steps * 0.75;
        return distance;
    }
    double countCalories(int month){
        double steps = stepTracker.allStepsPerMonth(month);
        double kiloCalories = steps * 0.05;
        return kiloCalories;
    }
    public Converter(){
        stepTracker = new StepTracker();
    }
}

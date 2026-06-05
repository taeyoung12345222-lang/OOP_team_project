public class FemaleUser extends User {

    public FemaleUser(String name, int age, double height, double weight, double skeletalmuscle,
                      double bodyfat, int exercisecount, int exercisetime, String balance) {
        super(name, "여성", age, height, weight, skeletalmuscle, bodyfat, exercisecount, exercisetime, balance);
    }

    @Override
    public void targetplan() {
        double fatPercent = this.BodyFatpercent();
        double smi = this.SMI();
        boolean highFat   = fatPercent >= 30.0;
        boolean lowFat    = fatPercent < 20.0;
        boolean lowMuscle = smi < 5.7;

        if (highFat && !lowMuscle) {
            this.setTargetCalories(this.getTDEE() - 500);
            setCarbProteinFat(0.4, 0.4, 0.2);
        } else if (highFat && lowMuscle) {
            this.setTargetCalories(this.getTDEE());
            setCarbProteinFat(0.45, 0.35, 0.2);
        } else if (!highFat && !lowFat && lowMuscle) {
            this.setTargetCalories(this.getTDEE() + 300);
            setCarbProteinFat(0.5, 0.3, 0.2);
        } else if (!highFat && !lowFat && !lowMuscle) {
            this.setTargetCalories(this.getTDEE());
            setCarbProteinFat(0.45, 0.35, 0.2);
        } else {
            this.setTargetCalories(this.getTDEE() + 300);
            setCarbProteinFat(0.5, 0.3, 0.2);
        }
    }

    @Override
    public void showDiet() {
        System.out.println("=========================================");
        System.out.println("            여성 식단 추천                 ");
        System.out.println("=========================================");
        System.out.println("체지방률: " + String.format("%.1f", this.BodyFatpercent()) + "%");
        System.out.println("목표 칼로리: " + String.format("%.0f", this.getTargetCalories()) + " kcal");
        System.out.println("탄수화물: " + String.format("%.1f", this.getCarbG()) + "g");
        System.out.println("단백질: " + String.format("%.1f", this.getProteinG()) + "g");
        System.out.println("지방: " + String.format("%.1f", this.getFatG()) + "g");
        printFoodGuide();
    }

    @Override
    public void showRoutine() {
        System.out.println("=========================================");
        System.out.println("            여성 운동 루틴 추천              ");
        System.out.println("=========================================");

        ExerciseRoutine routine;
        if (this.getExercisecount() == 2)       routine = new Female2DayRoutine(this);
        else if (this.getExercisecount() == 3)  routine = new Female3DayRoutine(this);
        else                                    routine = new Female4DayRoutine(this);

        routine.buildBaseRoutine();
    }
}

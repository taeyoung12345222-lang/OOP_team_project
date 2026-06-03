public class MaleUser extends User {

    public MaleUser(String name, int age, double height, double weight, double skeletalmuscle,
                    double bodyfat, int exercisecount, int exercisetime, String balance) {
        super(name, "남성", age, height, weight, skeletalmuscle, bodyfat, exercisecount, exercisetime, balance);
    }

    @Override
    public void targetplan() {
        double fatPercent = this.BodyFatpercent();

        if (fatPercent >= 20.0) {
            this.setTargetCalories(this.getTDEE() - 500);
        } else if (fatPercent < 10.0) {
            this.setTargetCalories(this.getTDEE() + 300);
        } else {
            this.setTargetCalories(this.getTDEE());
        }

        this.setCarbG((this.getTargetCalories() * 0.4) / 4);
        this.setProteinG((this.getTargetCalories() * 0.4) / 4);
        this.setFatG((this.getTargetCalories() * 0.2) / 9);
    }

    @Override
    public void finalreport() {
        showDiet();
        System.out.println();
        showRoutine();
    }

    @Override
    public void showDiet() {
        System.out.println("=========================================");
        System.out.println("            남성 식단 추천                 ");
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
        System.out.println("            남성 운동 루틴 추천              ");
        System.out.println("=========================================");

        ExerciseRoutine routine;
        if (this.getExercisecount() == 2)       routine = new Male2DayRoutine(this);
        else if (this.getExercisecount() == 3)  routine = new Male3DayRoutine(this);
        else                                    routine = new Male4DayRoutine(this);

        routine.buildBaseRoutine();
    }
}

public abstract class User implements InputOutputService {

    private String name;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private double skeletalmuscle;
    private double bodyfat;
    private int exercisecount;
    private int exercisetime;
    private String balance;

    private double BMR;
    private double TDEE;
    private double targetCalories;
    private double carbG;
    private double proteinG;
    private double fatG;

    public User(String name, String gender, int age, double height, double weight,
                double skeletalmuscle, double bodyfat, int exercisecount, int exercisetime, String balance) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.skeletalmuscle = skeletalmuscle;
        this.bodyfat = bodyfat;
        this.exercisecount = exercisecount;
        this.exercisetime = exercisetime;
        this.balance = balance;
    }

//BMR 계산
    public void calculateBMR() {
        if (this.gender.equals("남성")) {
            this.BMR = 88.4 + (13.4 * this.weight) + (4.8 * this.height) - (5.7 * this.age);
        } 
        else if (this.gender.equals("여성")) {
            this.BMR = 447.6 + (9.2 * this.weight) + (3.1 * this.height) - (4.3 * this.age);
        }
    }

//TDEE 계산
    public void calculateTDEE() {
        double exercisefactor = 1.375;
        if (this.exercisecount == 4) {
            exercisefactor = 1.55;
        } 
        else if (this.exercisecount == 3 && this.exercisetime == 60) {
            exercisefactor = 1.55;
        }
        this.TDEE = this.BMR * exercisefactor;
    }

    public double BodyFatpercent() {
        return (this.bodyfat / this.weight) * 100;
    }

    public double SMI() {
        double heightM = this.height / 100.0;
        return this.skeletalmuscle / (heightM * heightM);
    }

    protected void setCarbProteinFat(double carbR, double proteinR, double fatR) {
        this.setCarbG((this.targetCalories * carbR) / 4);
        this.setProteinG((this.targetCalories * proteinR) / 4);
        this.setFatG((this.targetCalories * fatR) / 9);
    }

//Getter and Setter 부분
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public double getSkeletalmuscle() { return skeletalmuscle; }
    public double getBodyfat() { return bodyfat; }
    public int getExercisecount() { return exercisecount; }
    public int getExercisetime() { return exercisetime; }
    public String getBalance() { return balance; }
    public double getTDEE() { return TDEE; }
    
    public double getTargetCalories() { return targetCalories; }
    public void setTargetCalories(double targetCalories) { this.targetCalories = targetCalories; }
    
    public double getCarbG() { return carbG; }
    public void setCarbG(double carbG) { this.carbG = carbG; }
    
    public double getProteinG() { return proteinG; }
    public void setProteinG(double proteinG) { this.proteinG = proteinG; }
    
    public double getFatG() { return fatG; }
    public void setFatG(double fatG) { this.fatG = fatG; }

    protected void printFoodGuide() {
        System.out.println("\n=== 식품 환산 예시 ===");
        System.out.printf("공기밥          약 %.1f공기 분량의 탄수화물%n", getCarbG() / 70.0);
        System.out.printf("편의점 닭가슴살  약 %.1f개 분량의 단백질%n",    getProteinG() / 20.0);
    }

    @Override
    public abstract void targetplan();

    @Override
    public abstract void showDiet();

    @Override
    public abstract void showRoutine();
}
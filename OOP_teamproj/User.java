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


    public void setUserData(String name, String gender, int age, double height, double weight, 
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

//Getter and Setter 부분
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public int getExercisecount() { return exercisecount; }
    public double getTDEE() { return TDEE; }
    
    public double getTargetCalories() { return targetCalories; }
    public void setTargetCalories(double targetCalories) { this.targetCalories = targetCalories; }
    
    public double getCarbG() { return carbG; }
    public void setCarbG(double carbG) { this.carbG = carbG; }
    
    public double getProteinG() { return proteinG; }
    public void setProteinG(double proteinG) { this.proteinG = proteinG; }
    
    public double getFatG() { return fatG; }
    public void setFatG(double fatG) { this.fatG = fatG; }

    @Override
    public abstract void targetplan();
    
    @Override
    public abstract void finalreport();
}
public class FemaleUser extends User {

    public FemaleUser(String name, int age, double height, double weight, double skeletalmuscle, 
                      double bodyfat, int exercisecount, int exercisetime, String balance) {
        this.name = name;
        this.gender = "여성";
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.skeletalmuscle = skeletalmuscle;
        this.bodyfat = bodyfat;
        this.exercisecount = exercisecount;
        this.exercisetime = exercisetime;
        this.balance = balance;
    }

    @Override
    public void targetplan() { //여기 수식 내가 임의대로 만든거라 확인해보고 잘못됐으면 노션에서 확인 부탁드립니다~
        double fatPercent = this.BodyFatpercent();

        if (fatPercent >= 30.0) { // 뚱뚱
            this.targetCalories = this.TDEE - 400;
        } 
        else if (fatPercent < 20.0) { // 마름
            this.targetCalories = this.TDEE + 200;
        } 
        else { // 보통
            this.targetCalories = this.TDEE;
        }

        this.carbG = (this.targetCalories * 0.4) / 4;
        this.proteinG = (this.targetCalories * 0.4) / 4;
        this.fatG = (this.targetCalories * 0.2) / 9;
    }

    @Override
    public void finalreport() {
        System.out.println("=== 여성 결과 리포트 ===");
        System.out.println("체지방률: " + this.BodyFatpercent() + "%");
        System.out.println("목표 칼로리: " + this.targetCalories + " kcal");
        
        // 서코, 예은이 루틴 복붙
        if (this.exercisecount == 2) {
            System.out.println("여성 주 2회 베이스 루틴 복붙");
        } else if (this.exercisecount == 3) {
            System.out.println("여성 주 3회 베이스 루틴 복붙");
        } else if (this.exercisecount == 4) {
            System.out.println("여성 주 4회 베이스 루틴 복붙");
        }

        // 여기 추가 사항 잘 채워주세요~ 예시입니다
        if (this.BodyFatpercent() >= 30.0) {
            System.out.println("+ ex[유산소 추가] 사이클 25분");
        } else if (this.BodyFatpercent() < 20.0) {
            System.out.println("+ ex[웨이트 추가] 하체 탄력 중심 스쿼트 배치");
        }
    }
}
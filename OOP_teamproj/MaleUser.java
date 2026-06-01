public class MaleUser extends User {

    public MaleUser(String name, int age, double height, double weight, double skeletalmuscle, 
                    double bodyfat, int exercisecount, int exercisetime, String balance) {
        this.name = name;
        this.gender = "남성";
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
    public void targetplan() { //여기 수식 맞는지 꼭 확인 해보고 틀리면 노션보고 수정 부탁드려요~
        double fatPercent = this.BodyFatpercent();

        if (fatPercent >= 20.0) { // 뚱뚱
            this.targetCalories = this.TDEE - 500;
        } 
        else if (fatPercent < 10.0) { // 마름
            this.targetCalories = this.TDEE + 300;
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
        System.out.println("=== 남성 결과 리포트 ===");
        System.out.println("체지방률: " + this.BodyFatpercent() + "%");
        System.out.println("목표 칼로리: " + this.targetCalories + " kcal");
        
        // 동규, 중빈 루틴 복붙
        if (this.exercisecount == 2) {
            System.out.println("남성 주 2회 베이스 루틴 복붙");
        } else if (this.exercisecount == 3) {
            System.out.println("남성 주 3회 베이스 루틴 복붙");
        } else if (this.exercisecount == 4) {
            System.out.println("남성 주 4회 베이스 루틴 복붙");
        }

        // 이건 조사 한 내용 채워주세요~
        if (this.BodyFatpercent() >= 20.0) {
            System.out.println("+ [유산소 추가] 인터벌 러닝 20분");
        } else if (this.BodyFatpercent() < 10.0) {
            System.out.println("+ [웨이트 추가] 프리웨이트 중심 고중량 세팅");
        }
    }
    
}

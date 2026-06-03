import java.util.Scanner;

public class Input {
    private Scanner sc;

    public Input(Scanner sc) {
        this.sc = sc;
    }

    public User getUserInput() {
        System.out.println("=========================================");
        System.out.println("          신체 정보 및 운동 성향 입력          ");
        System.out.println("=========================================");

        System.out.print("이름을 입력하세요: ");
        String name = sc.next();

        System.out.print("성별을 입력하세요 (남성 / 여성): ");
        String gender = sc.next();

        System.out.print("만 나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.print("키(cm)를 입력하세요: ");
        double height = sc.nextDouble();

        System.out.print("몸무게(kg)를 입력하세요: ");
        double weight = sc.nextDouble();

        System.out.print("골격근량(kg)을 입력하세요: ");
        double skeletalmuscle = sc.nextDouble();

        System.out.print("체지방량(kg)을 입력하세요: ");
        double bodyfat = sc.nextDouble();

        System.out.print("주 운동 횟수를 입력하세요 (2 / 3 / 4): ");
        int exercisecount = sc.nextInt();

        System.out.print("1회 운동 시간을 입력하세요 (30 / 60): ");
        int exercisetime = sc.nextInt();

        sc.nextLine(); // exercisetime 입력 후 남은 개행 제거
        System.out.print("상/하체 밸런스를 입력하세요 (상체 우세 / 하체 우세 / 균형): ");
        String balance = sc.nextLine().trim();

        System.out.println("=========================================");
        System.out.println("         모든 정보 입력이 완료되었습니다!        ");
        System.out.println("=========================================");

        return Userfactory.createUser(name, gender, age, height, weight, skeletalmuscle, bodyfat, exercisecount, exercisetime, balance);
    }
}
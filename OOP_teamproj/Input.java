import java.util.InputMismatchException;
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

        int age = -1;
        while (age < 1 || age > 120) {
            try {
                System.out.print("만 나이를 입력하세요: ");
                age = sc.nextInt();
                if (age < 1 || age > 120) System.out.println("[오류] 나이는 1~120 사이의 값을 입력하세요.");
            } catch (InputMismatchException e) {
                System.out.println("[오류] 숫자를 입력하세요.");
                sc.next();
            }
        }

        double height = -1;
        while (height < 50 || height > 300) {
            try {
                System.out.print("키(cm)를 입력하세요: ");
                height = sc.nextDouble();
                if (height < 50 || height > 300) System.out.println("[오류] 키는 50~300(cm) 사이의 값을 입력하세요.");
            } catch (InputMismatchException e) {
                System.out.println("[오류] 숫자를 입력하세요.");
                sc.next();
            }
        }

        double weight = -1;
        while (weight < 20 || weight > 300) {
            try {
                System.out.print("몸무게(kg)를 입력하세요: ");
                weight = sc.nextDouble();
                if (weight < 20 || weight > 300) System.out.println("[오류] 몸무게는 20~300(kg) 사이의 값을 입력하세요.");
            } catch (InputMismatchException e) {
                System.out.println("[오류] 숫자를 입력하세요.");
                sc.next();
            }
        }

        double skeletalmuscle = -1;
        while (skeletalmuscle <= 0 || skeletalmuscle >= weight) {
            try {
                System.out.print("골격근량(kg)을 입력하세요: ");
                skeletalmuscle = sc.nextDouble();
                if (skeletalmuscle <= 0 || skeletalmuscle >= weight)
                    System.out.println("[오류] 골격근량은 0보다 크고 몸무게(" + weight + "kg)보다 작아야 합니다.");
            } catch (InputMismatchException e) {
                System.out.println("[오류] 숫자를 입력하세요.");
                sc.next();
            }
        }

        double bodyfat = -1;
        while (bodyfat <= 0 || bodyfat >= weight) {
            try {
                System.out.print("체지방량(kg)을 입력하세요: ");
                bodyfat = sc.nextDouble();
                if (bodyfat <= 0 || bodyfat >= weight)
                    System.out.println("[오류] 체지방량은 0보다 크고 몸무게(" + weight + "kg)보다 작아야 합니다.");
            } catch (InputMismatchException e) {
                System.out.println("[오류] 숫자를 입력하세요.");
                sc.next();
            }
        }

        System.out.print("주 운동 횟수를 입력하세요 (2 / 3 / 4): ");
        int exercisecount = sc.nextInt();

        System.out.print("1회 운동 시간을 입력하세요 (30 / 60): ");
        int exercisetime = sc.nextInt();

        sc.nextLine();
        System.out.print("상/하체 밸런스를 입력하세요 (상체 우세 / 하체 우세 / 균형): ");
        String balance = sc.nextLine().trim();

        System.out.println("=========================================");
        System.out.println("         모든 정보 입력이 완료되었습니다!        ");
        System.out.println("=========================================");

        return Userfactory.createUser(name, gender, age, height, weight, skeletalmuscle, bodyfat, exercisecount, exercisetime, balance);
    }
}

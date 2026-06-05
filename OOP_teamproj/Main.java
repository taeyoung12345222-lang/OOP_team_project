import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "MS949");
        Input input = new Input(sc);
        User user = null;

        while (true) {
            System.out.println();
            System.out.println("=========================================");
            System.out.println("           헬스 관리 프로그램              ");
            System.out.println("=========================================");
            System.out.println("1. 운동 루틴 추천");
            System.out.println("2. 식단 추천");
            System.out.println("3. 회원 정보 입력");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice == 1) {
                try {
                    if (user == null) throw new MemberInfoRequiredException();
                    user.showRoutine();
                } catch (MemberInfoRequiredException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 2) {
                try {
                    if (user == null) throw new MemberInfoRequiredException();
                    user.showDiet();
                } catch (MemberInfoRequiredException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 3) {
                user = input.getUserInput();
                if (user != null) {
                    user.calculateBMR();
                    user.calculateTDEE();
                    user.targetplan();
                    System.out.println("회원 정보가 저장되었습니다. (" + user.getName() + " / " + user.getGender() + " / " + user.getAge() + "세)");
                } else {
                    System.out.println("[오류] 유저 생성 실패");
                }
            } else {
                System.out.println("올바른 번호(0~3)를 입력해주세요.");
            }
        }

        sc.close();
    }
}

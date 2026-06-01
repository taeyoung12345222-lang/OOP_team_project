public class Main {
    public static void main(String[] args) {
        Input input = new Input();

        User user = input.getUserInput();

        if (user == null) {
            System.out.println("유저를 생성할 수 없습니다. 프로그램을 종료합니다.");
            return;
        }

        user.calculateBMR();
        user.calculateTDEE();

        user.targetplan();

        user.finalreport();
    }
    
}

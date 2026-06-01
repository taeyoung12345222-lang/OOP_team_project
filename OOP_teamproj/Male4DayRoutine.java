public class Male4DayRoutine extends MaleRoutine {

    public Male4DayRoutine(User user) {
        super(user);
    }

    @Override
    public void buildBaseRoutine() {
        int time = user.getExercisetime();
        String balance = user.getBalance();
        // 팀원 루틴 내용 채워주세요
        System.out.println("[남성 주 4회 루틴] time=" + time + ", balance=" + balance + ", highFat=" + highFat + ", lowFat=" + lowFat);
    }
}

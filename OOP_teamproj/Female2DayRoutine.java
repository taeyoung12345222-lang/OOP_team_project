public class Female2DayRoutine extends FemaleRoutine {

    public Female2DayRoutine(User user) {
        super(user);
    }

    @Override
    public void buildBaseRoutine() {
        int time = user.getExercisetime();
        String balance = user.getBalance();

        if (time == 60) {
            if (highFat) {
                if (balance.equals("상체 우세"))
                    System.out.println("벤치프레스(4세트), 어시스트 풀업(4세트), 케이블 로우(4세트), 스쿼트(4세트), 레그컬(3세트), 사이드 레터럴 레이즈(3세트), 유산소 15분");
                else if (balance.equals("하체 우세"))
                    System.out.println("벤치프레스(4세트), 어시스트 풀업(4세트), 유산소 15분, 파워 레그프레스(4세트), 레그컬(4세트), 사이드 레터럴 레이즈(3세트), 힙 쓰러스트(4세트)");
                else
                    System.out.println("벤치프레스(4세트), 어시스트 풀업(4세트), 케이블 로우(4세트), 파워 레그프레스(4세트), 레그컬(3세트), 사이드 레터럴 레이즈(3세트), 유산소 15분");
            } else if (lowFat) {
                if (balance.equals("상체 우세"))
                    System.out.println("벤치프레스(5세트), 어시스트 풀업(5세트), 케이블 로우(5세트), 사이드 레터럴 레이즈(5세트), 파워 레그프레스(3세트), 힙 쓰러스트(3세트), 레그컬(3세트)");
                else if (balance.equals("하체 우세"))
                    System.out.println("파워 레그프레스(5세트), 힙 쓰러스트(5세트), 레그컬(5세트), 벤치프레스(3세트), 어시스트 풀업(3세트), 케이블 로우(3세트), 사이드 레터럴 레이즈(3세트)");
                else
                    System.out.println("체스트프레스(4세트), 어시스트 풀업(4세트), 케이블 로우(4세트), 파워 레그프레스(4세트), 레그컬(3세트), 사이드 레터럴 레이즈(3세트), 힙 쓰러스트(3세트)");
            } else {
                if (balance.equals("상체 우세"))
                    System.out.println("벤치프레스(4세트), 어시스트 풀업(4세트), 케이블 로우(4세트), 체스트프레스(4세트), 레그컬(3세트), 사이드 레터럴 레이즈(3세트), 힙 쓰러스트(3세트)");
                else if (balance.equals("하체 우세"))
                    System.out.println("벤치프레스(4세트), 어시스트 풀업(4세트), 파워 레그프레스(4세트), 레그 익스텐션(4세트), 레그컬(4세트), 힙 쓰러스트(4세트), 힙 어브덕션(3세트)");
                else
                    System.out.println("벤치프레스(4세트), 어시스트 풀업(4세트), 케이블 로우(4세트), 파워 레그프레스(4세트), 레그컬(3세트), 사이드 레터럴 레이즈(3세트), 힙 쓰러스트(4세트)");
            }
        } else {
            if (highFat) {
                if (balance.equals("상체 우세"))
                    System.out.println("벤치프레스(3세트), 어시스트 풀업(3세트), 케이블 로우(3세트), 스쿼트(3세트), 사이드 레터럴 레이즈(2세트)");
                else if (balance.equals("하체 우세"))
                    System.out.println("벤치프레스(3세트), 어시스트 풀업(3세트), 파워 레그프레스(3세트), 레그컬(3세트), 힙 쓰러스트(3세트)");
                else
                    System.out.println("벤치프레스(3세트), 어시스트 풀업(3세트), 케이블 로우(3세트), 파워 레그프레스(3세트), 사이드 레터럴 레이즈(2세트)");
            } else if (lowFat) {
                if (balance.equals("상체 우세"))
                    System.out.println("벤치프레스(4세트), 어시스트 풀업(4세트), 케이블 로우(4세트), 사이드 레터럴 레이즈(3세트), 파워 레그프레스(2세트)");
                else if (balance.equals("하체 우세"))
                    System.out.println("파워 레그프레스(4세트), 힙 쓰러스트(4세트), 레그컬(4세트), 벤치프레스(2세트), 어시스트 풀업(2세트)");
                else
                    System.out.println("체스트프레스(3세트), 어시스트 풀업(3세트), 케이블 로우(3세트), 파워 레그프레스(3세트), 힙 쓰러스트(2세트)");
            } else {
                if (balance.equals("상체 우세"))
                    System.out.println("벤치프레스(3세트), 어시스트 풀업(3세트), 케이블 로우(3세트), 체스트프레스(3세트), 사이드 레터럴 레이즈(2세트)");
                else if (balance.equals("하체 우세"))
                    System.out.println("벤치프레스(3세트), 어시스트 풀업(3세트), 파워 레그프레스(3세트), 레그컬(3세트), 힙 쓰러스트(3세트)");
                else
                    System.out.println("벤치프레스(3세트), 어시스트 풀업(3세트), 케이블 로우(3세트), 파워 레그프레스(3세트), 힙 쓰러스트(3세트)");
            }
        }
    }
}

public class Userfactory {
    public static User createUser(String name, String gender, int age, double height, double weight,
                                  double skeletalmuscle, double bodyfat, int exercisecount, int exercisetime, String balance) {
        if (gender.equals("남성")) {
            return new MaleUser(name, age, height, weight, skeletalmuscle, bodyfat, exercisecount, exercisetime, balance);
        } else if (gender.equals("여성")) {
            return new FemaleUser(name, age, height, weight, skeletalmuscle, bodyfat, exercisecount, exercisetime, balance);
        }
        return null;
    }
}

// 업캐스팅 & 다향성 사용 목적으로 만들었고 마찬가지로 정리해서 공유해줄게용
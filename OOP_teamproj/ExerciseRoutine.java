public abstract class ExerciseRoutine {

    protected User user;

    public ExerciseRoutine(User user) {
        this.user = user;
    }

    public abstract void buildBaseRoutine();
}

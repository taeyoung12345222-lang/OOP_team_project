public abstract class MaleRoutine extends ExerciseRoutine {

    protected boolean highFat;
    protected boolean lowFat;

    public MaleRoutine(User user) {
        super(user);
        double fatPercent = user.BodyFatpercent();
        this.highFat = fatPercent >= 20.0;
        this.lowFat  = fatPercent < 10.0;
    }

    @Override
    public abstract void buildBaseRoutine();
}

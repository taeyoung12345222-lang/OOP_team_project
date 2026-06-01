public abstract class FemaleRoutine extends ExerciseRoutine {

    protected boolean highFat;
    protected boolean lowFat;

    public FemaleRoutine(User user) {
        super(user);
        double fatPercent = user.BodyFatpercent();
        this.highFat = fatPercent >= 30.0;
        this.lowFat  = fatPercent < 20.0;
    }

    @Override
    public abstract void buildBaseRoutine();
}

package modernJavaInAction.chapter2;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean select(Apple apple) {
        return apple.getWeight() > 150;
    }
}

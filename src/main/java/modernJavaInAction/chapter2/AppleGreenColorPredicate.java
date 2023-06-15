package modernJavaInAction.chapter2;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean select(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}

package Discussions.Discussion4.regular;

public class CatBus implements Vehicle, Honker{
    @Override
    public void honk() {

    }

    @Override
    public void revEngine() {

    }

    public void conversation(Honker target) {
        honk();
        target.honk();
    }

    public static void main(String[] args) {
    }
}

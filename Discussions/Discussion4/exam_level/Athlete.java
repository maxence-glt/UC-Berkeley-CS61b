package Discussions.Discussion4.exam_level;

public class Athlete implements Person {
    @Override
    public void speakTo(Person other) {
        System.out.println("i love sports");
    }
    @Override
    public void watch(Athlete other) {
        System.out.println("ball is life");
    }
}

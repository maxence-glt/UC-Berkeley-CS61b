package Discussions.Discussion4.exam_level;

interface Person {
    void speakTo(Person other);
    default void watch(Athlete other) {
        System.out.println("wow");
    }
}

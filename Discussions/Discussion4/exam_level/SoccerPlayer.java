package Discussions.Discussion4.exam_level;

public class SoccerPlayer extends Athlete {
    @Override
    public void speakTo(Person other) {
        System.out.println("join 61ballers");
    }

    /*

                                                Line    Compile time (static)       Runtime (dynamic)       Output
    Person ayati = new Person();                1       Compiler Error              N/A                     Error
    Athlete aniruth = new SoccerPlayer();       3       Athlete                     SoccerPlayer
    SoccerPlayer vanessa = aniruth;             5       Compiler Error              N/A                     Error
    Person eric = new Athlete();                7       Person                      Athlete
    Athlete shreyas = new Athlete();            9       Athlete                     Athlete
    SoccerPlayer yaofu = new SoccerPlayer();    11      SoccerPlayer                SoccerPlayer
    eric.watch(aniruth);                        13      Person.watch                Athlete.watch           ball is life
    shreyas.speakTo(yaofu);                     15      Athlete.speakTo             Athlete.speakTo         i love sports
    yaofu.speakTo(eric);                        17      SoccerPlayer.speakTo        SoccerPlayer.speakTo    join 61ballers
    ((Athlete) yaofu).speakTo(eric);            19      Athlete.speakTo             SoccerPlayer.speakTo    join 61ballers
    ((Person) yaofu).speakTo(eric);             21      Person.speakTo              SoccerPlayer.speakTo    join 61ballers
    ((Athlete) eric).speakTo(shreyas)           23      Athlete.speakTo             Athlete.speakTo         i love sports
    ((SoccerPlayer) eric).watch(yaofu)          25      SoccerPlayer.watch          Runtime Error

    */

    public static void main(String[] args) {
        Person eric = new Athlete();
        SoccerPlayer yaofu = new SoccerPlayer();
        ((SoccerPlayer) eric).watch(yaofu);
    }
}

package ru.erdyneev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Music music = context.getBean("musicBean", Music.class);

        //MusicPlayer musicPlayer = new MusicPlayer(music);
        //musicPlayer.playMusic();
        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        boolean compare = firstMusicPlayer == secondMusicPlayer;

        firstMusicPlayer.setName("Singleton name");
        System.out.println(compare);
        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);
        System.out.println("check Second name:" + secondMusicPlayer.getName());

        context.close();
    }
}

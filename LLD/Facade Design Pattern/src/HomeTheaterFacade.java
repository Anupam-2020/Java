public class HomeTheaterFacade {
    private final DVDPlayer dvdPlayer;
    private final Projector projector;
    private final SoundSystem sound;
    private final Lights lights;

    public HomeTheaterFacade() {
        dvdPlayer = new DVDPlayer();
        projector = new Projector();
        sound = new SoundSystem();
        lights = new Lights();
    }

    public void watchMovie() {
        lights.dim();
        projector.on();
        sound.on();
        sound.setVolume(20);
        dvdPlayer.on();
        dvdPlayer.play();
    }
}

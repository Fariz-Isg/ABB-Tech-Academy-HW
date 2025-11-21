package HW12.FacadeMethod;

public class MovieNightFacade {
    private Lights lights;
    private TV tv;
    private SoundSystem sound;
    private Curtains curtains;
    private Heater heater;

    public MovieNightFacade() {
        this.lights = new Lights();
        this.tv = new TV();
        this.sound = new SoundSystem();
        this.curtains = new Curtains();
        this.heater = new Heater();
    }

    public void startMovieNight() {
        System.out.println("Starting Movie Night Mode\n");
        lights.Brightness(10);
        curtains.close();
        heater.setTemperature(21);
        tv.on();
        tv.setInput("Netflix");
        sound.on();
        sound.setVolume(30);
        System.out.println("Movie night ready");
    }
}

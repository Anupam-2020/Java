class DVDPlayer {
    public void on() {
        System.out.println("DVD ON");
    }

    public void play() {
        System.out.println("Playing movie");
    }
}


class Projector {
    public void on() {
        System.out.println("Projector ON");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound System ON");
    }

    public void setVolume(int volume) {
        System.out.println("Volume: " + volume);
    }
}

class Lights {

    public void dim() {
        System.out.println("Lights Dimmed");
    }
}
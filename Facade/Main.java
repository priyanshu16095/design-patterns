package Facade;

public class Main {
    public static class TV {
        public void turnOn() {
            System.out.println("TV: turning on");
        }
    }
    public static class AudioSystem {
        public void adjustVolume() {
            System.out.println("Audio System: adjuting volume");
        }
    }
    public static class StreamingDevice {
        public void startStreaming() {
            System.out.println("Streaming device: started streaming");
        }
    }
    public static class EntertainmentSystemFacade {
        private TV tv;
        private AudioSystem audioSystem;
        private StreamingDevice streamingDevice;

        public EntertainmentSystemFacade() {
            this.tv = new TV();
            this.audioSystem = new AudioSystem();
            this.streamingDevice = new StreamingDevice();
        }

        public void watchMovie() {
            System.out.println("Facade: Initiating movie watching sequence");
            tv.turnOn();
            audioSystem.adjustVolume();
            streamingDevice.startStreaming();
        }
    }
    public static void main(String[] args) {
        EntertainmentSystemFacade facade = new EntertainmentSystemFacade();
        facade.watchMovie();
    }
}

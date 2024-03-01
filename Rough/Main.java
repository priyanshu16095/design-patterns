public class Main {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.performAction();

        light.setState(new GreenLight());
        light.performAction();
    }
}

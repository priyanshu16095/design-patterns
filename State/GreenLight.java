public class GreenLight implements TrafficLightState {
    @Override
    public void handle() {
        System.out.println("GREEN LIGHT");
    }
}

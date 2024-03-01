public class RedLight implements TrafficLightState {
    @Override
    public void handle() {
        System.out.println("RED LIGHT");
    }
}

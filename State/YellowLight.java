public class YellowLight implements TrafficLightState {
    @Override
    public void handle() {
        System.out.println("YELLOW LIGHT");
    }
}

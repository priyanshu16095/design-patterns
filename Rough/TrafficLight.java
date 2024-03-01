public class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        this.state = new RedLight();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void performAction() {
        state.handle();
    }
}

package Prototype;

public class PrototypeObject implements Cloneable {
    String data;
    
    public PrototypeObject(String data) {
        this.data = data;
    }

    @Override
    public PrototypeObject clone() throws CloneNotSupportedException {
        return (PrototypeObject) super.clone();
    }
}

package Prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeObject originalObject = new PrototypeObject("Original data");
        PrototypeObject clonedObject = originalObject.clone();
        clonedObject.data = "Modified data";   

        System.out.println(originalObject.data);
        System.out.println(clonedObject.data);
    }
}

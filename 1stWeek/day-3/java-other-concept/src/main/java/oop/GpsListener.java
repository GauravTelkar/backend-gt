package oop;

public interface GpsListener {
    float[] locate();
    default boolean checkLocation(){
        return locate().length == 2;
    }
}

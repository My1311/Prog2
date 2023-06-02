package Ubung4.A3;

public class Temperatursensor {
    Ringpuffer<Float> tSensor = new Ringpuffer<>(24);

    public void neueMessung(float wert){
        tSensor.addLast(wert);
        // if der Speicher ist voll
        if(tSensor.size() == tSensor.capacity()){
            int newSize = 0;
            int pos = (tSensor.capacity() + newSize) % tSensor.capacity();
            tSensor.set(pos,wert);
            newSize++;
        }
    }
    public float aktuelleTemperatur(){
        // Wir nehmen den aktuellsten Wert (den letzten Wert)
        float ret = tSensor.get(tSensor.size()-1);
        if(tSensor.get(tSensor.size()-1) != null) {
            return ret;
        }
        return Float.NaN;
        }
    public float durchschnittsTemperatur() {
        float sum = 0;
        for (int i = 0; i < tSensor.size() ; i++) {
            sum += tSensor.get(i);
        }
        return sum/ tSensor.size();
    }

    public void reset(){
        for (int i = 0; i < tSensor.size() ; i++) {
          tSensor.removeLast();
        }
    }
}

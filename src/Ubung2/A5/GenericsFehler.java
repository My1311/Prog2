package Ubung2.A5;

public class GenericsFehler{
	public static void main(String[] args){
		MyObject mo = new MyObject();
		MyGeneric<String> mg = new MyGeneric<>(); 

		String s1 = "Hallo";
		Integer i1 = 42;

		mo.set(i1);
		mo.set(s1);
		String s2 = (String) mo.get();
		// Fehler: In mo ist ein String da gespeichert, daher konnen wir nicht zu ein Integer casten
		// Was in mo gespeichert ist nicht eindeutig
	    Integer i2 = (Integer) mo.get(); // i2 ist nicht initialisiert.
/**		System.out.println(s1);  -> Hallo
		System.out.println(s2);     Hallo
		System.out.println(i1);     42
 **/
		
		// Fehler bei i1, weil i1 Integer ist und MyGeneric Klasse speichert String
//		mg.set(s1);
//		mg.set(i1);
//		String s3 = mg.get();
//		Integer i3 = (Integer)mg.get();
	}
}
/**
 * Die Unterschiede zwischen MyObject und MyGeneric:
 * Object kann alle Typen speichern
 * Generic kann nur die generic Typ speichern und ist daher genauer!
 */

/** This class is a simplified 'container' for objects of type Object
    thus all subtypes of Object can be stored
    so in Java every kind of type   */
class MyObject{
	private Object o;
	public void set(Object o){
		this.o = o;
	}
	public Object get(){
		return o;
	}
}

/** This is a simple container for storing an object of a generic type
    so any given type (and it's subclasses) */
class MyGeneric<T>{
	private T o;
	public void set(T o){
		this.o = o;
	}
	public T get(){
		return o;
	}
}

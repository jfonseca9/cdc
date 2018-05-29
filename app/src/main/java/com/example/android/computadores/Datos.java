package com.example.android.computadores;

import java.util.ArrayList;
import java.util.Random;

public class Datos {
    private static String db = "Computadores";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Computador> computador = new ArrayList();

    /*public static void guardar(Persona p){
        personas.add(p);
    }*/

    public static void guardar(Computador p) {
        databaseReference.child(db).child(p.getId()).setValue(p);
    }

    public static ArrayList<Computador> obtener() {
        return computador;
    }

    public static int fotoAleatoria(ArrayList<Integer> fotos) {
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public static String getId() {
        return databaseReference.push().getKey();
    }

    public static void setPersonas(ArrayList<Computador> personas) {
        Datos.computador = personas;
    }

    public static void eliminarPersona(Computador p) {
        databaseReference.child(db).child(p.getId()).removeValue();
    }

    public static void modificarPersona(Computador p) {
        databaseReference.child(db).child(p.getId()).setValue(p);
    }
}


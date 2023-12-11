package presentacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Articulo;
import dominio.Catedratico;
import dominio.Profesor;
import dominio.ProfesorTitular;
import dominio.Proyecto;

public class Interfaz{

    private ArrayList<Profesor> profesores;
    private Scanner sc = new Scanner(System.in);

    public Interfaz(){
      leer();        
    }

    private void leer(){
        ObjectInputStream obj;
    File file = new File("meritos.txt");
    try{
        obj = new ObjectInputStream(new FileInputStream(file));
        try{profesores = (ArrayList<Profesor>)obj.readObject();
        }catch(Exception e){System.out.println(e);}
        obj.close();
        System.out.println("leido");
    } catch(Exception e){
        System.out.println("no leido");
        profesores = new ArrayList<Profesor>();
    }
}

    private void grabar(){

    ObjectOutputStream obj;
                File file = new File("meritos.txt");
                try{
                    obj = new ObjectOutputStream(new FileOutputStream(file));
                    obj.writeObject(profesores);
                    obj.close();
                    System.out.println("Guardado");
                } catch(Exception e){
                System.out.println("Error al guardar");
                System.out.println(e);
                };

    }

    private void annadirProfesorTitular(){
        System.out.println("Introduzca el nombre del profesor: ");
        String nombre = sc.nextLine();
        profesores.add(new ProfesorTitular(nombre));
        
    }

    private void annadirCatedratico(){
     System.out.println("Introduzca el nombre del catedratico: ");
    String nombre = sc.nextLine();
    profesores.add(new Catedratico(nombre));
    
    }

    private void annadirMerito(){
        System.out.println("introduce el nombre del profesor: ");
        String nombre = sc.nextLine();
        int n = profesores.indexOf(new ProfesorTitular(nombre));
        if(n== -1){
            System.out.println("Profesor no encontrado");

        }else{
        System.out.println("Titulo del merito: ");
        String titulo = sc.nextLine();
        System.out.println("Escoja el tipo de Merito: ");
        System.out.println("1) Articulo");
        System.out.println("2) Proyecto");
        int opcion = sc.nextInt();
        sc.nextLine();
        if (opcion==1){
            System.out.println("Introduzca impacto del articulo: ");
            double impacto = sc.nextDouble();
            sc.nextLine();
            profesores.get(n).annadirMerito(new Articulo(titulo, impacto));
        }else if(opcion==2){
            System.out.println("Introduzca la financioacion del proyecto: ");
            double financiacion = sc.nextDouble();
            sc.nextLine();
            profesores.get(n).annadirMerito(new Proyecto(titulo, financiacion));

        }else{
            System.out.println("Opcion no disponible");
        }
    }

    }

    private void borrarProfesor(){
        System.out.print("Nombre del profesor a borrar: ");
        String n = sc.nextLine();
        ProfesorTitular p = new ProfesorTitular(n);
        int posicion = profesores.indexOf(p); //devuelve posicion 
        if(posicion == -1){
            System.out.println("Profesor no se encuentra");
        }else{
            profesores.remove(posicion);
            System.out.println("Profesor borrado");
            System.out.println("pulse <ENTER> para continuar");
            sc.nextLine();
        }
    }

    private String menu(){ 
        System.out.println("\033[H\033[2J");
        System.out.println("\n----------Menu---------");
        System.out.println("1. Agregar Profesor titular");
        System.out.println("2. Agregar catedratico");
        System.out.println("3. añadir merito ");
        System.out.println("4. borrar profesor");
        System.out.println("5. mostrar profesor");
        System.out.println("6. Salir");
        System.out.print("Ingrese su opción: ");
       
        String opcion = sc.nextLine();
        return opcion;
    }


    public void ejecutar(){
        String opcion;
        do{
             opcion = menu();
        switch (opcion) {
            case "1":
                annadirProfesorTitular();
                break;
            
            case "2":
                annadirCatedratico();
                break;
            case "3":
                annadirMerito();
                break;
            case "4":
                borrarProfesor();
                break;
            case "5":
                mostrar();
                break;
            case "6":
                grabar();
                break;
            default:
            System.out.println("opcion incorrecta :( ");
                break;
        } 
        }while (! opcion.equals("6") );

    }

    public void mostrar(){
        System.out.println("Profesores "+ profesores); 
        System.out.println("pulse <ENTER> para continuar");
        sc.nextLine();
      

    }
    




}
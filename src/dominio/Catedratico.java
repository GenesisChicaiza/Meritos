package dominio;

public class Catedratico extends Profesor{

    public Catedratico(String nombre){
        super(nombre);
        
    }
//raiz cuadrada
    public double calcularValoracion(){
        float suma = 0;
        for(Merito m: meritos){
            //m = m+ lo q sea
            suma += Math.pow(m.valorar(),2); //eleveada a cuadrado
        }
        return Math.pow(suma/4, 0.5);

    }



}
package dominio;

public class ProfesorTitular extends Profesor{

    public ProfesorTitular(String nombre){
        super(nombre);
    }

    public double calcularValoracion(){
        double suma = 0;
        if(meritos.size() ==0){
            return 0.0;
        }
        else{
        for(Merito m: meritos){
            //m = m+ lo q sea
            suma += m.valorar(); //eleveada a cuadrado
        }
        return suma/meritos.size();
    }
    }

}
package dominio;

public class Articulo extends Merito {

    protected float impacto;
    protected double d;

    public Articulo(String titulo, double d){
        super(titulo);
        this.d = d;
    }

    public double valorar(){
        return impacto;
    }

}
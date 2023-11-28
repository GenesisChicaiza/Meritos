package dominio;

public abstract class Merito{

    protected String titulo;

    public Merito(String titulo){
        this.titulo = titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(String titulo){
        return titulo;
    }

    public abstract double valorar();

}

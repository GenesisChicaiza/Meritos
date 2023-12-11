package dominio;

import java.io.Serializable;

public abstract class Merito implements Serializable{               

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

        public String toString(){
            return "Merito: " + titulo +"\nValoracion: " + valorar();
        }
}

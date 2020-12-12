package Models;

public class Promociones {

    private String nombre;
    private int precio;

    public Promociones(){}

    public Promociones(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

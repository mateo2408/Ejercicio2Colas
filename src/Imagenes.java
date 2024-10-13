import java.util.LinkedList;
import java.util.Queue;

public class Imagenes {
    private Queue<String> imagenes;
    private int Index;
    private LinkedList<String> imagenesLista;

    public Imagenes(){
        imagenes = new LinkedList<>();
        imagenesLista = new LinkedList<>();
        Index = -1;
    }

    public void agregarImagen(String imagen){
        imagenes.add(imagen);
        imagenesLista.add(imagen);
        if (Index == -1){
            Index = 0;
        }
    }

    public void eliminarPrimeraImagen(){
        if(!imagenes.isEmpty()){
            imagenes.poll();
            imagenesLista.removeFirst();
            if (Index >= imagenesLista.size()){
                Index = imagenesLista.size() - 1;
            }
        }
    }

    public void eliminarUltimaImagen(){
        if (!imagenes.isEmpty()){
            imagenes.poll();
            imagenesLista.removeLast();
            if (Index >= imagenesLista.size()){
                Index = imagenesLista.size() - 1;
            }
        }
    }

    public String presentarImagen(){
        if (imagenesLista.isEmpty()){
            return "No hay imagenes para mostrar";
        }
        return imagenesLista.get(Index);
    }

    public String siguienteImagen(){
        if (imagenesLista.isEmpty()){
            return "No hay imagenes";
        }
        Index = (Index + 1) % imagenesLista.size();
        return imagenesLista.get(Index);
    }

    public String anteriorImagen(){
        if (imagenesLista.isEmpty()){
            return "No hay imagenes";
        }
        Index = (Index - 1 + imagenesLista.size()) % imagenesLista.size();
        return imagenesLista.get(Index);
    }
}
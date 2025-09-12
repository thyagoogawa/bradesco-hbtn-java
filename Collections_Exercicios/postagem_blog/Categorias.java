import java.util.ArrayList;
import java.util.List;

public enum Categorias {

    DEVOPS, DESENVOLVIMENTO, DATA_SCIENCE;


    public static List<Categorias> getCategorias() {
        List<Categorias> categorias = new ArrayList<>();
        
        for (Categorias categoria : Categorias.values()) {
            categorias.add(categoria);
        }

        return categorias;
    }

}

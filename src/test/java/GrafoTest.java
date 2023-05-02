import Grafo.Grafo;
import Grafo.Puerto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GrafoTest {

    Grafo grafo = new Grafo();
    Puerto puerto1 = new Puerto("Madero");
    Puerto puerto2 = new Puerto("Rodas");
    Puerto puerto3 = new Puerto("Valparaiso");

    @Test

    public void grafoTest() {

        grafo.agregarPuerto(puerto1);
        grafo.agregarPuerto(puerto2);
        grafo.agregarPuerto(puerto3);

        grafo.agregarArista(puerto1, puerto2, 10);
        grafo.agregarArista(puerto2, puerto3, 15);


        grafo.buscarPuertoConMasAristas();
        Assertions.assertFalse(grafo.puertos.contains(puerto2));
    }

    public void testBarridoProfundidad() {

        grafo.agregarPuerto(puerto1);
        grafo.agregarPuerto(puerto2);
        grafo.agregarPuerto(puerto3);

        grafo.agregarArista(puerto1, puerto2, 10);
        grafo.agregarArista(puerto2, puerto3, 15);

        Set<Puerto> visitados = grafo.barridoProfundidad(puerto1);

        Assertions.assertTrue(visitados.contains(puerto1));
        Assertions.assertTrue(visitados.contains(puerto2));
        Assertions.assertTrue(visitados.contains(puerto3));

        Assertions.assertEquals(3, visitados.size());
    }

    public void testCaminoMasCorto(){

        grafo.agregarPuerto(puerto1);
        grafo.agregarPuerto(puerto2);
        grafo.agregarPuerto(puerto3);

        grafo.agregarArista(puerto1, puerto2, 10);
        grafo.agregarArista(puerto2, puerto3, 15);

        List<Puerto> camino = grafo.caminoMasCorto(puerto1, puerto3);
        Assertions.assertEquals(Arrays.asList(puerto1, puerto2, puerto3), camino);

        //Añadir una nueva arista
        grafo.agregarArista(puerto1, puerto3, 5);

        camino = grafo.caminoMasCorto(puerto1, puerto3);
        Assertions.assertEquals(Arrays.asList(puerto1, puerto3), camino);

    }
}

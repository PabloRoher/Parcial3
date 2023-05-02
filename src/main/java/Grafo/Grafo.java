package Grafo;

import java.util.*;

public class Grafo {
    public List<Puerto> puertos;
    public Map<Puerto, List<Arista>> adyacencias;

    public Grafo() {
        puertos = new ArrayList<>();
        adyacencias = new HashMap<>();
    }

    public void agregarPuerto(Puerto puerto) {
        puertos.add(puerto);
        adyacencias.put(puerto, new ArrayList<>());
    }

    public void agregarArista(Puerto origen, Puerto destino, int distancia) {
        Arista arista = new Arista(origen, destino, distancia);
        adyacencias.get(origen).add(arista);
        Arista aristaInversa = new Arista(destino, origen, distancia);
        adyacencias.get(destino).add(aristaInversa);
    }

    public Set<Puerto> barridoProfundidad(Puerto origen) {
        Set<Puerto> visitados = new HashSet<Puerto>();
        barridoProfundidadRecursivo(origen, visitados);
        return visitados;
    }

    public void barridoProfundidadRecursivo(Puerto actual, Set<Puerto> visitado){
        visitado.add(actual);
        System.out.println("Puerto: " + actual.nombre + "visitado") ;

        for (Arista arista : adyacencias.get(actual)) {
            if(!visitado.contains(arista.destino)){
                barridoProfundidadRecursivo(arista.destino, visitado);
            }
        }
    }

    public List<Puerto> caminoMasCorto(Puerto origen, Puerto destino){
        Map<Puerto, Puerto> predecesores = new HashMap<>();
        Map<Puerto, Integer> distancias = new HashMap<>();
        Queue<Puerto> cola = new LinkedList<>();

        for(Puerto puerto : puertos){
            distancias.put(puerto, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        cola.add(origen);

        while (!cola.isEmpty()) {
            Puerto actual = cola.poll();

            if (actual.equals(destino)) {
                break;
            }

            for (Arista arista : adyacencias.get(actual)) {
                int nuevaDistancia = distancias.get(actual) + arista.distancia;

                if (nuevaDistancia < distancias.get(arista.destino)) {
                    distancias.put(arista.destino, nuevaDistancia);
                    predecesores.put(arista.destino, actual);
                    cola.add(arista.destino);
                }
            }

        }
        if (!predecesores.containsKey(destino)) {
            return Collections.emptyList();
        }

        List<Puerto> camino = new ArrayList<>();
        Puerto actual = destino;

        while (actual != null) {
            camino.add(actual);
            actual = predecesores.get(actual);
        }

        Collections.reverse(camino);
        return camino;
    }

    public void buscarPuertoConMasAristas(){
        int maxAristas = 0;
        Puerto puertoConMasAristas = null;
        for (Puerto puerto : puertos){
            if (adyacencias.get(puerto).size() > maxAristas){
                maxAristas = adyacencias.get(puerto).size();
                puertoConMasAristas = puerto;
            }
        }
        adyacencias.remove(puertoConMasAristas);
        puertos.remove(puertoConMasAristas);
    }

}

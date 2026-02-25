package service;

import model.Route;
import java.util.*;

public class RouteService {

    private List<Route> routes = new ArrayList<>();

    public RouteService() {
        routes.add(new Route(1, "Chennai", "Tambaram"));
        routes.add(new Route(2, "Chennai", "Velachery"));
        routes.add(new Route(3, "Chennai", "Airport"));
    }

    public Route getById(int id) {
        for (Route r : routes) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    public void listAll() {
        for (Route r : routes) {
            System.out.println(r);
        }
    }
}
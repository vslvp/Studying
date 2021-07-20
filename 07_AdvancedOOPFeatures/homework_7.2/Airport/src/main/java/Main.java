import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Terminal> terminals = airport.getTerminals();
        double timer = 7.2e+6;
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i < terminals.size(); i++) {
            flights.addAll(terminals.get(i).getFlights().stream().filter(t -> t.getType().equals(Flight.Type.DEPARTURE))
                    .filter(d -> d.getDate().getTime() <= (new Date()).getTime() + timer)
                    .collect(Collectors.toList()));
        }
        return flights;
    }
}
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import net.sf.saxon.functions.DynamicContextAccessor;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Flight> flights = new ArrayList<>();
        flights.addAll(flights.stream().filter(Flight ::getDate = new Date()));
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        return flights;
    }

}
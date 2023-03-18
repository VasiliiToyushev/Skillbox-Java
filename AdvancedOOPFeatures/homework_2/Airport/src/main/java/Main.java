import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.System.currentTimeMillis;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport);
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Date time = new Date(currentTimeMillis() + 3_600_000 * 2);
        return airport.getTerminals().stream().flatMap(t -> t.getFlights().stream()
                        .filter(f -> f.getType().equals(Flight.Type.DEPARTURE) &&
                                f.getDate().before(time) && f.getDate().after(new Date())))
                .collect(Collectors.toList());
    }

}
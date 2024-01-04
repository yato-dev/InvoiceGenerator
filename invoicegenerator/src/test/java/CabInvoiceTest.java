import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.example.CabInvoice;
import com.example.Invoice;
import com.example.InvoiceService;
import com.example.Ride;
import com.example.RideService;
import com.example.RiderType;

public class CabInvoiceTest {
    static CabInvoice cabInvoice;

    @BeforeAll
    public static void init() {
        cabInvoice = new CabInvoice();
    }

    @Test
    public void NormalRideTest() {
        Ride ride = new Ride(2.0, 5, RiderType.NORMAL);
        cabInvoice.calculateFare(ride);
        double fare = ride.getFare();
        assertEquals(25, fare, 0.0);
    }

    @Test
    public void premiumRideTest() {
        Ride ride = new Ride(2.0, 5, RiderType.PREMIUM);
        cabInvoice.calculateFare(ride);
        double fare = ride.getFare();
        assertEquals(40, fare, 0.0);
    }

    @ParameterizedTest
    @MethodSource("distanceAndTime")
    public void calculateFareTest(Ride ride, double expected) {
        cabInvoice.calculateFare(ride);
        assertEquals(expected, ride.getFare());
    }

    private static Stream<Arguments> distanceAndTime() {
        return Stream.of(
                arguments(new Ride(0.2, 1, RiderType.NORMAL), 5.0),
                arguments(new Ride(20, 50, RiderType.NORMAL), 250.0),
                arguments(new Ride(0.1, 1, RiderType.NORMAL), 5.0),
                arguments(new Ride(10.0, 20.0, RiderType.PREMIUM), 190.0),
                arguments(new Ride(2.0, 10.0, RiderType.PREMIUM), 50.0),
                arguments(new Ride(0.1, 1, RiderType.PREMIUM), 20.0));
    }

    @Test
    public void calculateFareForMultiplareRidesTest() {
        Invoice invoice = getInvoiceForTestCase();

        assertNotNull(invoice);
        assertEquals(6, invoice.getTotalRides());
        assertEquals(520.0, invoice.getTotalFare());
        assertEquals(86.66666666666667, invoice.getAveraFare());

    }

    private Invoice getInvoiceForTestCase() {
        List<Ride> rides = Arrays.asList(
                new Ride(0.2, 1.0, RiderType.NORMAL),
                new Ride(20, 50, RiderType.NORMAL),
                new Ride(0.1, 1, RiderType.NORMAL),
                new Ride(10.0, 20.0, RiderType.PREMIUM),
                new Ride(2.0, 10.0, RiderType.PREMIUM),
                new Ride(0.1, 1, RiderType.PREMIUM));

        RideService rideService = new RideService();
        InvoiceService invoiceService = new InvoiceService(rideService);
        String userId = "User1";
        rideService.addRides(userId, rides);
        return invoiceService.getUserInvoice(userId);
    }

    @Test
    public void invalidUserIdTest() {
        RideService rideService = new RideService();
        InvoiceService invoiceService = new InvoiceService(rideService);
        Invoice invoice = invoiceService.getUserInvoice("invalidUser");
        assertNull(invoice);
    }

}

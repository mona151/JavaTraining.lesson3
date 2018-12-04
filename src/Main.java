/*
 * Main class
 * EPAM Java training for automation QA
 * Author: Kirill Kuzin
 * Lesson 1 Task 3
 * */
import exceptions.NegativePriceException;
import exceptions.ZeroFCException;
import park.Park;
import transport.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Transport> transport = new ArrayList<Transport>();
        Scanner in = new Scanner(System.in);
        Bus busMercedes = new Bus(180f, "Travego 15 RH", 4800000, Manufacturers.MERCEDES.toString());
        Bus busToyota = new Bus(150f, "Coaster", 800000, Manufacturers.TOYOTA.toString());
        Bus busMan = new Bus(178.7f, "MAGNIT", 1800000, Manufacturers.MAN.toString());
        Bus busIsuzu = new Bus(80f, "Novoultra 4HK1E", 4800000, Manufacturers.ISUZU.toString());
        System.out.println("Enter fuel consmption value for Huyndai Solaris Cab:");
        try{
            float solarisFC = in.nextInt();
            Auto cabSolaris = new Auto(solarisFC, "Solaris", 630000, Manufacturers.HUYNDAI.toString());
            transport.add(cabSolaris);
        } catch (ZeroFCException | InputMismatchException e) {
            System.out.println("You have entered invalid fuel consumption for Solaris");
            return;
        }

        int fuelConsumptionMin = 0, fuelConsumptionMax = 0, priceMin = 0, priceMax =0;


        transport.add(busMercedes);
        transport.add(busIsuzu);
        transport.add(busMan);
        transport.add(busToyota);
        park.Park park = new Park(transport);

        park.getParkInfo();
        System.out.println("Park total price is " + park.getParkTotalPrice());
        park.sortParkByFuelConsumption();
        System.out.println("Enter desired min and max fuel consumption + min and max price:");
            try {
                fuelConsumptionMin = in.nextInt();
                fuelConsumptionMax = in.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Fuel consumption values should be numeric");
                return;
        }

        try {
            System.out.println("Enter minimum price: ");
            priceMin = Integer.parseInt(in.next());
            System.out.println("Enter maximum price: ");
            priceMax = in.nextInt();
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("You have entered invalid minimum price");
            return;
        }

        try{
            park.getTransportByParameters(fuelConsumptionMin, fuelConsumptionMax, priceMin, priceMax);
        } catch (NegativePriceException e) {
            e.printStackTrace();
            return;
        }
    }
}
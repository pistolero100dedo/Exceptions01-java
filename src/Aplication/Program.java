package Aplication;

import model.Entities.Reservation;
import model.Exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        try {
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            System.out.print("Check in: (dd/MM/yyyy) ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check out: (dd/MM/yyyy) ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println();
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter the data to update reservation: ");
            System.out.print("Check in: (dd/MM/yyyy) ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check out: (dd/MM/yyyy) ");
            checkOut = sdf.parse(sc.next());


            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        sc.close();

    }
}
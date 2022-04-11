package Aplication;

import model.Entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check in: (dd/MM/yyyy) ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check out: (dd/MM/yyyy) ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println();
            System.out.println(reservation);


            System.out.println();
            System.out.println("Enter the data to update reservation: ");


            System.out.print("Check in: (dd/MM/yyyy) ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check out: (dd/MM/yyyy) ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error: Reservation dates for update must be future dates");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Error: Check-out date must be after check-in date");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }


            sc.close();
        }
    }
}
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;

public class Theatre {
    private static int[] row_1 ={0,0,0,0,0,0,0,0,0,0,0,0};
    private static int[] row_2 ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static int[] row_3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static Scanner myscanner;

    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre!!");
        for (int i = 0; i < 40; i++) {
            ;
            System.out.println("_");
        }

        Scanner input = new Scanner(System.in);
        System.out.println("*MENU*");
        System.out.println("Please select an option:");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area");
        System.out.println("3) Cancel ticket");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load fro file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("0) Quit");

        int option = 0;
        while (option < 9) {
            ;
            try {
                System.out.println("Enter option:");
                option = myscanner.nextInt();

                switch (option) {
                    case 1:
                        buy_ticket();
                        break;
                    case 2:
                        print_seating_area();
                        break;
                    case 3:
                        cancel_ticket();
                        break;
                    case 4:
                        show_available_();
                        break;
                    case 5:
                        save();
                        break;
                    case 6:
                        //load();
                        break;
                    case 7:
                        break;
                        //case 8:
                        //continue;
                        //case 0:
                        //continue;
                    default:
                        System.out.println("Option selected is incorrect");
                        break;
                }

            } catch (Exception e) {
                //System.out.println("_Please enter an integer_");
            }
        }

    }


    public static void buy_ticket() {
        Scanner myscanner=new Scanner(System.in);

        System.out.println("Enter the preferred row number");
        int rowNo = myscanner.nextInt();
        System.out.println("Enter the preferred seat number");
        int seatNo = myscanner.nextInt();
        seatNo --;
        switch (seatNo) {
            case 1 -> {
                if (rowNo == 1) {
                    if (row_1[seatNo] == 1) {
                        System.out.println("Sorry,the seat is already occupied.");
                    } else {
                        System.out.println("your seat has been reserved . Thank you!!");
                        row_1[seatNo] = 1; //updating the array
                    }
                    for (int i : row_1) {
                        System.out.print(i);  //printing the reserved seat
                    }
                }
            }
            case 2 -> {
                if (rowNo == 2) {

                    if (row_2[seatNo] == 1) {
                        System.out.println("Sorry,the seat is already occupied.");
                    } else {
                        System.out.println("your seat has been reserved . Thank you!!");
                        row_2[seatNo] = 1; //updating the array
                    }
                    for (int i : row_2) {
                        System.out.print(i);  //printing the reserved seat
                    }
                }
            }
            case 3 -> {
                if (rowNo == 3) {

                    if (row_3[seatNo] == 1) {
                        System.out.println("Sorry,the seat is already occupied.");
                    } else {
                        System.out.println("your seat has been reserved . Thank you!!");
                        row_3[seatNo] = 1;  //updating the array
                    }
                    for (int i : row_3) {
                        System.out.print(i);  //printing the reserved seat
                    }
                }
            }
        }


        }

    public static void print_seating_area() {
        for (int i : row_1)
            if (i == 1) {

            System.out.println("X");
        }
            else{
            System.out.println("O");
        }

        for (int i : row_2)
            if (i == 1) {

            System.out.println("X");
        }
            else{
            System.out.println("O");
        }

        for (int i : row_3)
            if (i == 1) {
            System.out.println("X");
        }
            else{
            System.out.println("O");
        }

    }

    public static void cancel_ticket() {
        System.out.println("Enter the seat number you wish to cancel");
        int seatNo2 = myscanner.nextInt();
        seatNo2--;
        System.out.println("Enter the row number of the seat you wish to cancel");
        int rowNo2 = myscanner.nextInt();

        switch (seatNo2) {
            case 1:
                if (rowNo2 == 1) {
                    if (row_1[seatNo2] == 1) {
                        ;
                        System.out.println("Your seat will be cancelled");
                        row_1[seatNo2] = 0;
                    } else {
                        ;
                        System.out.println("enter the correct seat and the row number");
                        cancel_ticket();
                    }
                }
            case 2:
                if (rowNo2 == 2) {
                    if (row_2[seatNo2] == 1) {
                        ;
                        System.out.println("Your seat will be cancelled");
                        row_2[seatNo2] = 0;
                    } else {
                        ;
                        System.out.println("enter the correct seat and the row number");
                        cancel_ticket();
                    }
                }
            case 3:
                if (rowNo2 == 3) {
                    if (row_3[seatNo2] == 1) {
                        ;
                        System.out.println("Your seat will be cancelled");
                        row_3[seatNo2] = 0;
                    } else {
                        ;
                        System.out.println("enter the correct seat and the row number");
                        cancel_ticket();
                    }
                }
        }}

    public static void show_available_() {
        for (int i:row_1) {
            System.out.print("Seats available in row 1:");
            System.out.println(i);
        }

        for (int i:row_2) {
            System.out.print("Seats available in row 2:");
            System.out.println(i);
        }

        for (int i:row_2) {
            System.out.print("Seats available in row 1:");
            System.out.println(i);
        }


    }

    public static void save() {
        try{
            FileWriter myWriter = new FileWriter("available_seats.txt");
            for (int i=0; i<row_1.length; i++) {
                myWriter.write("Available seats in row 1:" );
                myWriter.write(row_1[i]);
            }
            for (int i=0; i<row_2.length; i++) {
                myWriter.write("Available seats in row 2:" );
                myWriter.write(row_2[i]);
            }
            for (int i=0; i<row_3.length; i++) {
                myWriter.write("Available seats in row 3:" );
                myWriter.write(row_3[i]);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }



    //public static void load() {
        //try{

        } //catch (Exception e) {
            //throw new RuntimeException(e);
        //}

    //}




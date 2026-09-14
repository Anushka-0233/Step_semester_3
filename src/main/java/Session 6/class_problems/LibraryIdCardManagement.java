class IdCard {

    String name;
    int booksIssued;


    // Constructor
    IdCard(
            String name,
            int booksIssued) {

        this.name = name;
        this.booksIssued = booksIssued;
    }
}


public class LibraryIdCardManagement {

    public static void main(String[] args) {


        // Create first object
        IdCard ravi =
                new IdCard(
                    "Ravi",
                    0
                );


        // Both variables point to same object
        IdCard duplicate = ravi;


        // Change using second variable
        duplicate.booksIssued = 3;


        // Create separate object
        IdCard separate =
                new IdCard(
                    "Ravi",
                    3
                );


        System.out.println(
            "Ravi's booksIssued (via first variable): "
            + ravi.booksIssued
        );


        System.out.println(
            "duplicate == ravi: " +
            (duplicate == ravi)
        );


        System.out.println(
            "separate == ravi: " +
            (separate == ravi)
        );
    }
}
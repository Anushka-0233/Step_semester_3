import java.time.LocalDate;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getDueDays();
}

class Book extends LibraryItem {

    Book(String title) {
        super(title);
    }

    int getDueDays() {
        return 14;
    }
}

class DVD extends LibraryItem {

    DVD(String title) {
        super(title);
    }

    int getDueDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {

    Magazine(String title) {
        super(title);
    }

    int getDueDays() {
        return 3;
    }
}

public class LibraryDueDateCalculator {

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        LibraryItem[] items = {
            new Book("Java Programming"),
            new DVD("Inception"),
            new Magazine("Science Today")
        };

        for (LibraryItem item : items) {

            LocalDate dueDate =
                currentDate.plusDays(item.getDueDays());

            System.out.println(item.title + " -> Due Date: " + dueDate);
        }
    }
}
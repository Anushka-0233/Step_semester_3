abstract class Question {
    double marks;

    Question(double marks) {
        this.marks = marks;
    }

    abstract double grade(String answer);
}

class MCQQuestion extends Question {

    String correctAnswer;

    MCQQuestion(double marks, String correctAnswer) {
        super(marks);
        this.correctAnswer = correctAnswer;
    }

    double grade(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return marks;
        }

        return 0;
    }
}

class TrueFalseQuestion extends Question {

    String correctAnswer;

    TrueFalseQuestion(double marks, String correctAnswer) {
        super(marks);
        this.correctAnswer = correctAnswer;
    }

    double grade(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return marks;
        }

        return 0;
    }
}

class EssayQuestion extends Question {

    String keyword1;
    String keyword2;

    EssayQuestion(double marks, String keyword1, String keyword2) {
        super(marks);
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
    }

    double grade(String answer) {

        String text = answer.toLowerCase();

        boolean found1 = text.contains(keyword1.toLowerCase());
        boolean found2 = text.contains(keyword2.toLowerCase());

        if (found1 && found2) {
            return marks * 0.75;
        } else if (found1 || found2) {
            return marks * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Question[] questions = {
            new MCQQuestion(10, "A"),
            new TrueFalseQuestion(10, "true"),
            new EssayQuestion(20, "inheritance", "polymorphism")
        };

        String[] answers = {
            "A",
            "true",
            "Inheritance and polymorphism are important concepts."
        };

        for (int i = 0; i < questions.length; i++) {
            System.out.println(
                "Marks: " + questions[i].grade(answers[i])
            );
        }
    }
}
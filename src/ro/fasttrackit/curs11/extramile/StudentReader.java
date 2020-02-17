package ro.fasttrackit.curs11.extramile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReader {
    public List<StudentGrade> readFile(String fileLocation) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(fileLocation));
        List<StudentGrade> students = new ArrayList<>();
        while (scanner.hasNextLine()) {
            StudentGrade studentGrade = fetchStudentGrades(scanner.nextLine());
            students.add(studentGrade);
        }

        return students;
    }

    private StudentGrade fetchStudentGrades(String line) {
        String[] tokens = line.split("[|]");

        return new StudentGrade(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
    }
}

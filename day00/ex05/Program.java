import java.util.Scanner;

public class Program {
    private static final int max_students = 10;
    private static final int max_length = 10;
    private static final int max_lessons = 10;

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] students = new String[max_students];
    private static final int[] lessons = new int[max_lessons];
    private static final String[] lessonsName = new String[max_lessons];

    private static void initStudents(){
        System.out.println("Enter students (max = 10):");
        for (int i = 0; i < max_students; i++) {
            System.out.print("[" + (i + 1) + "]: ");
            String input = scanner.nextLine();
            if (input.equals(".")) {
                break;
            }
            students[i] = input;
            char[] name = students[i].toCharArray();
            for (char c : name) {
                if (c == ' ' || name.length > max_length) {
                    System.err.println("Illegal argument");
                    System.exit(-1);
                }
            }
        }
    }

    private static void initAndValidateLessons() {
        System.out.println("Enter lessons: <time (1pm - 6pm)> <name>");
        for (int i = 0; i < max_lessons; i++) {
            System.out.print("[" + (i + 1) + "]: ");
            if (!scanner.hasNextInt()) {
                if (scanner.next().equals(".")) {
                    break;
                }
                System.err.println("Illegal argument");
                System.exit(-1);
            }
            int time = scanner.nextInt();
            if (time < 1 || time > 6) {
                System.err.println("Illegal argument");
                System.exit(-1);
            }
            String name = scanner.next();
            if (name.equals(".")) {
                break;
            }
            lessons [i] = time;
            lessonsName[i] = name;
        }
    }
    public static Boolean isStudentNotExists(String name) {
        for(String student: students) {
            if(name.equals(student))
                return false;
        }
        return true;
    }
    public static Boolean isLessonNotExists(String name) {
        for(String lesson: lessonsName) {
            if(name.equals(lesson))
                return false;
        }
        return true;
    }

    private static int initAttendanceAndCountRecords() {
        int recordsNumber = 0;
        System.out.println("Enter attendance <student> <lesson> <date> <HERE/NOT_HERE>: ");
        while (!scanner.next().equals(".")) {
            String student = scanner.next();
            String lesson = scanner.next();
            if (isStudentNotExists(student) || isLessonNotExists(lesson) || !scanner.hasNextInt()) {
                System.err.println("Illegal argument");
                System.exit(-1);
            }
            int date = scanner.nextInt();
            String presence = scanner.next();
            if (date < 1 || date > 31 || !(presence.equals("HERE") || presence.equals("HERE/NOT_HERE"))) {
                System.err.println("Illegal argument");
                System.exit(-1);
            }
            recordsNumber++;
        }
        return recordsNumber;
    }
    private static void displayLessons() {
        System.out.print("Lessons: ");
        for (int i = 0; i < max_lessons; i++) {
            if (lessonsName[i] != null && lessons[i] > 0) {
                System.out.print(lessons[i] + " " + lessonsName[i] + "; ");
            }
        }
        System.out.println();
    }
    private static void displayStudents() {
        System.out.print("Students: ");
        for (String student : students) {
            if (student != null) {
                System.out.print(student + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        initStudents();
        displayStudents();
        initAndValidateLessons();
        displayLessons();
        int attendanceRecords = initAttendanceAndCountRecords();
    }
}

package datastructure;

/**
 * @author: huhao
 * @time: 2020/2/1 16:34
 * @desc:
 */
public class Student {
    private String name;
    private int score;

    public Student(String studentName, int studentScore) {
        this.name = studentName;
        this.score = studentScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 66));
        arr.addLast(new Student("Charlie", 88));

        System.out.println(arr);
    }
}

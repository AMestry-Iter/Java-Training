package Day_3_OOPSnCollectionsContinue;

import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Jim",101,8.4,"IT"));
        studentList.add(new Student("Pam", 102, 7.2, "CS"));
        studentList.add(new Student("Roy", 103, 1.8, "ME"));
        studentList.add(new Student("Sam", 104, 6.5, "EE"));
        studentList.add(new Student("Leo", 105, 1.5, "CE"));

        System.out.println("Students List: ");
        for(Student s: studentList){
            System.out.println(s);
        }

        //remove all students with GPA below 2.0
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()){
            Student s = iterator.next();
            if(s.getGpa()<2.0){
                iterator.remove();
            }
        }

        //HashMap<Integer, Student> mapping student IDs to Student objects
        Map<Integer, Student> studentMap = new HashMap<>();
        for (Student s: studentList){
            studentMap.put(s.getId(), s);
        }

        //TreeMap<Double, String> to store students sorted by GPA (GPA -> name)
        Map<Double, String> gpaMap = new TreeMap<>();
        for (Student s: studentList){
            gpaMap.put(s.getGpa(), s.getName());
        }

        //TreeMap<Double, String> to store students sorted by GPA (GPA -> name)
        Set<String> departmentsSet = new HashSet<>();
        for (Student s: studentList){
            departmentsSet.add(s.getDepartment());
        }

        //Printing all collections using for each

        System.out.println("\nStudents after removing GPA < 2.0");
        for(Student s: studentList){
            System.out.println(s);
        }

        System.out.println("\n HashMap<ID,Student> :");
        for(Map.Entry<Integer,Student> entry : studentMap.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        System.out.println("\n TreeMap<GPA,Name> (sorted by GPA) :");
        for(Map.Entry<Double,String> entry : gpaMap.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        System.out.println("\nUnique Departments(Set): ");
        for(String dept: departmentsSet){
            System.out.println(dept);
        }

        System.out.println();

        //Bonus Tasks
        List<Integer> arrayList = new ArrayList<>();
        long startArray = System.nanoTime();
        for(int i=0;i<100000;i++){
            arrayList.add(i);
        }
        long endArray = System.nanoTime();
        System.out.println("ArryaList Add time: " +(endArray-startArray)/1_000_000+ " ms");

        List<Integer> linkedList = new LinkedList<>();
        long startLL = System.nanoTime();
        for(int i=0;i<100000;i++){
            linkedList.add(i);
        }
        long endLL = System.nanoTime();
        System.out.println("LinkedList Add time: " +(endLL-startLL)/1_000_000+ " ms");
        System.out.println();

        //Custom Comparator reverse alphabetical
        List<Student> sortByDesc = new ArrayList<>(studentList);
        sortByDesc.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        for(Student s: sortByDesc){
            System.out.println(s);
        }

    }
}

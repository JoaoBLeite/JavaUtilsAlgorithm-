import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectListSort {

    private static List<User> users = new ArrayList<>();
    
    public static void main(String[] args) {
        
        users.add(new User("Johny", 21));
        users.add(new User("Nina", 11));
        users.add(new User("Barbosa", 26));
        users.add(new User("Cath", 7));
        users.add(new User("Glennis", 21));

        System.out.println("Initial list: " + users);

        // Option 1: Collections.sort() with Comparable
        Collections.sort(users); // Sort by age ascending
        System.out.println("Op1: " + users);

        // Option 2: Collections.sort() with Comparator
        Collections.sort(users, new Comparator<User>() {
            // Sort by name ascending
            @Override
            public int compare(User u1, User u2) {
                return u1.getName().compareTo(u2.getName());
            }
        });
        System.out.println("Op2: " + users);

        // Option 3: List interface sort() [Java 8]
        users.sort(Comparator.comparing(User::getAge)); // Sort by age ascending
        users.sort(Comparator.comparing(User::getAge).reversed()); // Sort by age descending
        System.out.println("Op3: " + users);

        // Option 4: Stream interface sorted() [Java 8]
        List<User> sortedUsers = users.stream()
            .sorted(Comparator.comparing(User::getName))
            .collect(Collectors.toList()); // Sort by name ascending
        System.out.println("Op4: " + sortedUsers);

        // Option 4 Plus: Sorting a Stream by Multiple Fields
        Comparator<User> userComparator = Comparator
            .comparing(User::getAge)
            .thenComparing(User::getName);
        List<User> sortedUsersAgain = users.stream()
            .sorted(userComparator)
            .collect(Collectors.toList());
        System.out.println("Op4 plus: " + sortedUsersAgain);
    }

}

class User implements Comparable<User> {

    private String name;
    private Integer age;

    public User (String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "[" +  name + ", " + age + "]";
    }

    // Option 1: Collections.sort() with Comparable
    @Override
    public int compareTo(User o) {
        if (Objects.isNull(this.getAge()) || Objects.isNull(o.getAge()))
            return 0;
        return this.getAge().compareTo(o.getAge());
    }
}

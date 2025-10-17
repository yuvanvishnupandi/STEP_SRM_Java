class Address implements Cloneable {
    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow Copy
    public Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    // Deep Copy
    public Person deepClone() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone();
        clonedPerson.address = (Address) this.address.clone();
        return clonedPerson;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address originalAddress = new Address("New York");
        Person originalPerson = new Person("John", originalAddress);

        Person shallowClonedPerson = originalPerson.shallowClone();
        Person deepClonedPerson = originalPerson.deepClone();

        System.out.println("--- Initial State ---");
        System.out.println("Original: " + originalPerson.name + ", " + originalPerson.address.city);
        System.out.println("Shallow Clone: " + shallowClonedPerson.name + ", " + shallowClonedPerson.address.city);
        System.out.println("Deep Clone: " + deepClonedPerson.name + ", " + deepClonedPerson.address.city);

        // Modify the city in the shallow clone's address
        shallowClonedPerson.address.city = "Los Angeles";

        System.out.println("\n--- After Modifying Shallow Clone's Address ---");
        System.out.println("Original: " + originalPerson.name + ", " + originalPerson.address.city);
        System.out.println("Shallow Clone: " + shallowClonedPerson.name + ", " + shallowClonedPerson.address.city);
        System.out.println("Deep Clone: " + deepClonedPerson.name + ", " + deepClonedPerson.address.city);
    }
}
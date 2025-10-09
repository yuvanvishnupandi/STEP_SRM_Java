// File: Registration.java
class ContactInfo implements Cloneable {
    public String email;
    public String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "ContactInfo{email='" + email + "', phone='" + phone + "'}";
    }
}

class Student implements Cloneable {
    public String id;
    public String name;
    public ContactInfo contact;

    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public Object shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public Object deepClone() throws CloneNotSupportedException {
        Student clonedStudent = (Student) super.clone();
        clonedStudent.contact = (ContactInfo) this.contact.clone();
        return clonedStudent;
    }
    
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', contact=" + contact + "}";
    }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo contact = new ContactInfo("john.doe@email.com", "1234567890");
        Student s1 = new Student("S101", "John Doe", contact);

        Student s2_shallow = (Student) s1.shallowClone();
        Student s3_deep = (Student) s1.deepClone();
        
        System.out.println("Original: " + s1);
        System.out.println("Shallow Clone: " + s2_shallow);
        System.out.println("Deep Clone: " + s3_deep);
        
        System.out.println("\n--- Modifying contact email ---\n");
        s1.contact.email = "john.new@email.com";
        
        System.out.println("Original: " + s1);
        System.out.println("Shallow Clone: " + s2_shallow);
        System.out.println("Deep Clone: " + s3_deep);
    }
}
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

//შევქმნათ კლასი დეპარტამენტი
public class Department {

    //განვუსაზღვროთ დეპარტამენტის კლასს პარამეტრები
    private final String name;
    private final int id;
    private  final String location;


    // შევქმნათ კლასის კონსტრუქტორი და დავაინიციალიზოთ პარამეტრები
    public Department(String name, int id, String location) {
        this.name = name;
        this.id = id;
        this.location = location;
    }

    //გადავფაროთ toString მეთოდი და დავაბეჭდინოთ დეპარტამენტის ობიექტი
    @Override
    public String toString() {
        return "name=" + name + ' ' + ", id=" + id + ", location='" + location;
    }

    //გადავფაროთ toEquals მეთოდი
    @Override
    public boolean equals(Object obj) {
        //შევამოწმოთ თუ არ უდროს ამ კლასის ობიექტი მიღებული კლასის ობიექტს
        if (getClass() != obj.getClass())
            return false;
        //დავკასტოთ მიღებული ობიექტი როგორც დეპარტმანეტის კლასი რატა წვდომა მივიღოთ მის პარამეტრებზე
        Department that = (Department) obj;
        // შევამოწმოთ თითოეული პარამეტრი უდრის თუ არა ეს ობიექტები ერთმანეთს
        return id == that.id &&
                name.equals(that.name) &&
                location.equals(that.location);
    }

    public static void main(String[] args) {
        // შევქმნათ ამ კლასის ობიექტები
        Department dept1 = new Department("HR", 101, "New York");
        Department dept2 = new Department("IT", 102, "San Francisco");
        Department dept3 = new Department("HR", 101, "New York");

        //დავბეჭდოთ მიღებული ინსტანსები
        System.out.println("Department 1: " + dept1);
        System.out.println("Department 2: " + dept2);
        System.out.println("Department 3: " + dept3);

        //დავბეჭდოთ შედარებული ობიექტები უდრის თუ არა ერთმანეთს
        System.out.println("Department 1 == Department 2: " + dept1.equals(dept2));
        System.out.println("Department 1 == Department 3: " + dept1.equals(dept3));
    }
}

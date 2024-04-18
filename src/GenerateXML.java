import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class GenerateXML {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            //შევქმნათ მშობელი ელემენტი
            Element rootElement = document.createElement("employees");
            document.appendChild(rootElement);

            // შევმქნათ შვილობილი ელემენტები
            createEmployee(document, rootElement, "Kanistrate");
            createEmployee(document, rootElement, "Gaiozi");

            // ჩავწეროთ დაგენერირებული XML ფაილში
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("employee.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void createEmployee(Document document, Element rootElement, String name) {

        //შევქმნათ employees შვილობილი ელემენტი
        Element employeeElement = document.createElement("employee");
        rootElement.appendChild(employeeElement);

        // დავამატოთ სახელი ამ ელემენტს
        Element nameElement = document.createElement("name");
        nameElement.appendChild(document.createTextNode(name));
        employeeElement.appendChild(nameElement);

        // დავამატოთ მეილი ამ ელემენტს
        Element emailElement = document.createElement("email");
        emailElement.appendChild(document.createTextNode(name + "@btu.com"));
        employeeElement.appendChild(emailElement);
    }
}
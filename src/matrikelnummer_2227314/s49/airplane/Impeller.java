package matrikelnummer_2227314.s49.airplane;

import matrikelnummer_2227314.s49.Application;
import matrikelnummer_2227314.s49.airplane.elements.Element;
import matrikelnummer_2227314.s49.airplane.elements.MainElement;
import matrikelnummer_2227314.s49.airplane.elements.SubElement;

import java.util.ArrayList;
import java.util.List;

public class Impeller {

    private List<MainElement> mainElements;

    public Impeller() {
        this.mainElements = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            MainElement mainElement = new MainElement("MainElement-" + i);
            mainElement.addIdTag("MainElement-" + i);
            for(int j = 0; j < 10; j++) {
                SubElement subElement = new SubElement("SubElement-" + i + "-" + j);
                subElement.addIdTag("SubElement-" + i + "-" + j);
                mainElement.addElement(subElement);
                for(int k = 0; k < 5; k++) {
                    Element element = new Element("Element-" + i + "-" + j + "-" + k);
                    element.addIdTag("Element-" + i + "-" + j + "-" + k);
                    subElement.addElement(element);
                }
            }
            mainElements.add(mainElement);
        }

        if(Application.debugMessages) {
            for(MainElement elements : mainElements) {
                elements.printStructure();
                System.out.println();
                elements.printElementInformation();
            }
        }
    }
}

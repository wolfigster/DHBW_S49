package matrikelnummer_2227314.s49.airplane.elements;

public class SubElement extends RootElement {

    public SubElement(String elementName) {
        super(elementName);
    }

    @Override
    public void printElementInformation() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Element name: ").append(this.elementName).append("\n");
        stringBuilder.append("Superior element: ").append(this.getSuperiorElement());

        for(RootElement rootElement : elements) {
            rootElement.printElementInformation();
        }
        System.out.println(stringBuilder.toString());
    }
}
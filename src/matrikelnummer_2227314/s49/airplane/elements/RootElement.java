package matrikelnummer_2227314.s49.airplane.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class RootElement {

    protected int indentDepth = 0;
    protected String elementName;
    protected RootElement parentElement;
    protected List<RootElement> elements;
    protected List<String> idTags;

    public RootElement(String elementName) {
        this.elementName = elementName;
        this.elements = new ArrayList<>();
        this.idTags = new ArrayList<>();
    }

    public abstract void printElementInformation();

    public void addElement(RootElement rootElement) {
        elements.add(rootElement);
    }

    public final boolean isComposite() {
        return !elements.isEmpty();
    }

    public final ListIterator<RootElement> listElements() {
        return elements.listIterator();
    }

    protected String indent(int depth) {
        StringBuilder stringBuilder = new StringBuilder();

        do {
            stringBuilder.append("+ ");
        } while (depth-- > 0);

        return stringBuilder.toString();
    }

    public final void printStructure() {
        System.out.println(indent(indentDepth) + elementName + (isComposite() ? " (node)" : " (leaf)"));
        for(RootElement area : elements) {
            area.indentDepth = indentDepth + 1;
            area.printStructure();
        }
    }

    public String getSuperiorElement() {
        String parent;

        if(parentElement == null) {
            parent = "--- top level element";
        } else {
            parent = this.parentElement.elementName;
        }
        return parent;
    }

    public void addIdTag(String idTag) {
        idTags.add(idTag);
    }

    public void printTags() {
        System.out.println("[" + idTags + "]");
        if(parentElement != null) {
            parentElement.printTags();
        }
    }
}

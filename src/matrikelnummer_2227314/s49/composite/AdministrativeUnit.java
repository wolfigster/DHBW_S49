package matrikelnummer_2227314.s49.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class AdministrativeUnit {

    protected int indentDepth = 0;
    protected String unitName;
    protected AdministrativeUnit parentUnit;
    protected List<AdministrativeUnit> units;
    protected List<String> idTags;

    public AdministrativeUnit(String unitName) {
        this.unitName = unitName;
        this.units = new ArrayList<>();
        this.idTags = new ArrayList<>();
    }

    public abstract void printStaffingInformation();

    public void addUnit(AdministrativeUnit administrativeUnit) {
        units.add(administrativeUnit);
    }

    public final boolean isComposite() {
        return !units.isEmpty();
    }

    public final ListIterator<AdministrativeUnit> listUnits() {
        return units.listIterator();
    }

    protected String indent(int depth) {
        StringBuilder stringBuilder = new StringBuilder();

        do {
            stringBuilder.append("+ ");
        } while (depth-- > 0);

        return stringBuilder.toString();
    }

    public final void printStructure() {
        System.out.println(indent(indentDepth) + unitName + (isComposite() ? " (node)" : " (leaf)"));
        for(AdministrativeUnit area : units) {
            area.indentDepth = indentDepth + 1;
            area.printStructure();
        }
    }

    public String getSuperiorUnit() {
        String parent;

        if(parentUnit == null) {
            parent = "--- top level unit";
        } else {
            parent = this.parentUnit.unitName;
        }
        return parent;
    }

    public void addIdTag(String idTag) {
        idTags.add(idTag);
    }

    public void printTags() {
        System.out.println("[" + idTags + "]");
        if(parentUnit != null) {
            parentUnit.printTags();
        }
    }
}

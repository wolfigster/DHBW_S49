package matrikelnummer_2227314.s49.composite;

public class _CompositeApplet {
    public static void main(String... args) {
        AdministrativeUnit a1 = new AdministrativeArea("a1");
        a1.addIdTag("a1");

        AdministrativeUnit a1b1 = new AdministrativeArea("a1b1");
        a1b1.addIdTag("a1b1");

        AdministrativeUnit a1b1c1 = new AdministrativeArea("a1b1c1");
        a1b1c1.addIdTag("a1b1c1");

        AdministrativeUnit o1 = new Office("o1");

        AdministrativeUnit a1b1c1d1 = new AdministrativeArea("a1b1c1d1");
        a1b1c1d1.addIdTag("a1b1c1d1");

        AdministrativeUnit o2 = new Office("o2");
        AdministrativeUnit o3 = new Office("o3");

        a1b1c1d1.addUnit(o2);
        a1b1c1d1.addUnit(o3);
        a1b1c1.addUnit(a1b1c1d1);
        a1b1c1.addUnit(o1);
        a1b1.addUnit(a1b1c1);
        a1.addUnit(a1b1);

        a1.printStructure();
        System.out.println();
        a1.printStaffingInformation();
    }
}

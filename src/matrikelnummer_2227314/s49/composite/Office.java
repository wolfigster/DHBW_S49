package matrikelnummer_2227314.s49.composite;

public class Office extends AdministrativeUnit {

    public Office(String areaName) {
        super(areaName);
    }

    @Override
    public void printStaffingInformation() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Unit name: ").append(this.unitName).append("\n");
        stringBuilder.append("Superior unit: ").append(getSuperiorUnit());

        for(AdministrativeUnit administrativeUnit : units) {
            administrativeUnit.printStaffingInformation();
        }
        System.out.println(stringBuilder.toString());
    }
}

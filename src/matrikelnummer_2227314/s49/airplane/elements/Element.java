package matrikelnummer_2227314.s49.airplane.elements;

import java.util.Random;

public class Element extends RootElement {

    private String[][] matrix;

    public Element(String elementName) {
        super(elementName);
        this.matrix = createMatrix();
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

    public String[][] getMatrix() {
        return matrix;
    }

    public String getRow(int row) {
        StringBuilder r = new StringBuilder();
        for(int i = 0; i < 20; i++) {
            r.append(matrix[row][i]);
        }
        return r.toString();
    }

    private String[][] createMatrix() {
        String[] symbols = {"+", "*", ":", "-", "/"};
        String[][] matrix = new String[5][20];
        Random random = new Random();

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 20; j++) {
                matrix[i][j] = symbols[random.nextInt(5)];
            }
        }
        return matrix;
    }
}
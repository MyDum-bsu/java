package lab2.kndr.codecheck;

public class Prices {
    /**
     * A method to determine and return the average price
     */
    public static double averagePrice(double[] priceData) {

        double sum = 0;
        for (double data : priceData) {
            sum += data;
        }
        return priceData.length == 0 ? 0 : sum / priceData.length;

    }
}

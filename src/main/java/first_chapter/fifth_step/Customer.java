package first_chapter.fifth_step;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Description：第五步优化:给第49—第53行的代码换个新家,提炼"常客积分计算"代码
 *              原因：与第四步优化相同，把积分计算责任放在Rental上比较合适
 * Author:TengLu
 * Date:2019/7/27
 */
public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        // 总金额
        double totalAmount = 0;
        // 常客积分
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            // determine amounts for each line
            // 计算金额
            thisAmount = each.getCharge();

            frequentRenterPoints += each.getFrequentRenterPoints();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                "frequent renter points";
        return result;
    }

}

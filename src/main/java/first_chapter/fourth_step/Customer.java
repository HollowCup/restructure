package first_chapter.fourth_step;

import first_chapter.init.Movie;
import first_chapter.third_step.Rental;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Description：第四步优化:去掉临时变量thisAmount
 *              原因：在statement方法中，thisAmount变得多余起来
 *                    并且可能导致大量参数被传来传去
 *              修改代码为41行while{}里的代码
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
            Rental each = (Rental) rentals.nextElement();

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                "frequent renter points";
        return result;
    }

}

package first_chapter.seventh_step;

/**
 * Description：第七步优化:将getCharge()和getFrequentRenterPoints（）移到Moive类里去
 *              原因：系统有可能因为电影类型发生变化，如果变化一旦发生，这样的做法可以保证造成的影响降到最低
 *              代码修改：添加getCharge（int daysRented）和getFrequentRenterPoints(int daysRented)方法
 * Author:TengLu
 * Date:2019/7/27
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case first_chapter.init.Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case first_chapter.init.Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case first_chapter.init.Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == first_chapter.init.Movie.NEW_RELEASE) && daysRented > 1)
            return 2;
        else
            return 1;
    }
}

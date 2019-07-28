package first_chapter.seventh_step;

/**
 * Description：第七步优化:将getCharge()和getFrequentRenterPoints（）移到Moive类里去
 *              原因：系统有可能因为电影类型发生变化，如果变化一旦发生，这样的做法可以保证造成的影响降到最低
 *              代码修改：修改getCharge()和getFrequentRenterPoints()的实现
 * Author:TengLu
 * Date:2019/7/27
 */
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public void setMovie(Movie _movie) {
        this._movie = _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public void setDaysRented(int _daysRented) {
        this._daysRented = _daysRented;
    }

    public double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}

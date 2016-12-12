package mybox.com.mybox.utils.logger;

/**
 * Created by Sergbek on 28.06.2016.
 */
public interface LogAdapter {
    void d(String tag, String message);

    void e(String tag, String message);

    void w(String tag, String message);

    void i(String tag, String message);

    void v(String tag, String message);

    void wtf(String tag, String message);
}

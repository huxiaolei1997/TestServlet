import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xiaolei hu
 * @date 2018/6/22 15:03
 **/
//
//@WebServlet(urlPatterns = "/time") 或
@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    public TimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取当前时间
        Date nowDate = new Date();
        // 获取日历实例
        Calendar calendar = Calendar.getInstance();
        // 设置星期一为开始的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(nowDate);
        // 获取当前是第几周
        int numOfWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        // 格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒");
        String nowTime = sdf.format(new Date());
        // 获取年份
        int year = calendar.get(Calendar.YEAR);
        System.out.println("nowTime = " + nowTime + "year = " + year);
        req.setAttribute("nowTime", nowTime);
        req.setAttribute("numOfWeek", numOfWeek);
        req.setAttribute("year", year);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

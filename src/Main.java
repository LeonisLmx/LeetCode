import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        int ans = 365 / 5;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022,Calendar.DECEMBER,31,0,0,0);
        SimpleDateFormat format = new SimpleDateFormat();
        for (int i = 1;i <= 5;i++){
            calendar.add(Calendar.DAY_OF_YEAR, ans);
            System.out.println(format.format(calendar.getTime()));
        }
    }
}
    /*
     * @Author:2017110342_吴谭波
     * @Description:创建一个Date类
     * @Date: 2019/10/18
     * @Modified By:2017110342_吴谭波
     */


    package tanbo.wu.data.menue;

    import java.util.Calendar;
    import java.util.Scanner;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Date {
        private int year = Calendar.getInstance().get(Calendar.YEAR);
        private int month = Calendar.getInstance().get(Calendar.MONDAY + 1);
        private int day = Calendar.getInstance().get(Calendar.DATE);
        private String date;


        public Date(){
            this.date = this.year + "" + this.month + "" + this.day + "";
        }


        public void setDate(String date) {
            this.date = date;
        }


        public String getDate() {
            return date;
        }



        //Date
        public static boolean isDateRight(String date) {
            String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
            Pattern pat = Pattern.compile(rexp);
            Matcher mat = pat.matcher(date);
            boolean dateType = mat.matches();
            return dateType;
        }
    }


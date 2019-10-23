    /*
     * @Author:2017110342_吴谭波
     * @Description:实现用户登录注册等功能
     * @Date: 2019/10/18
     * @Modified By:2017110342_吴谭波
     */


    package tanbo.wu.data.menue;

import java.lang.invoke.SwitchPoint;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Log {
        static int index;
        static boolean logIn = false;
        static User[] users = new User[100];
        /*private static String[] userNameArray = new String[100] ;
        private static String[] screenNameArray = new String[100];
        private static String[] passwordArray = new String[100];
        private static String[] emailAddressArray = new String[100];
        private static String[] answerArray = new String[100];*/
        private static int userCount = 0;
        static String[] testAnswers = {"","1.Q1","2.Q2","3.Q3","4.Q4","5.Q5"};
        public static void main(String[] args){
            mainMenu();
        }
        private static void mainMenu() {
            Scanner input = new Scanner(System.in);
            System.out.println("1.系统登陆");
            System.out.println("2.系统设置");
            System.out.println("3.写日记");
            System.out.println("4.查找日记");
            System.out.println("5.退出系统");
            System.out.println("请选择：");
            int option = input.nextInt();
            while (!(option >= 1 && option <= 5)) {
                System.out.println("Input Error,input again");
                option = input.nextInt();
            }
            switch (option) {
                case 1:
                    loginMenu();
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("用户未登录,请先登录");
                    loginMenu();
                    break;
                case 5:
                    System.out.println("谢谢使用,再见!");
                    System.exit(0);
                    break;
            }
        }

        private static void loginMenu(){
            User testUser = new User();
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("3.找回密码");
            System.out.println("4.返回上一级菜单");
            System.out.println("请选择:");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            switch(option) {
                case 1:
                    System.out.println("请输入用户名:");
                    String username = input.next();
                    while (!testUser.usernameIsRight(username)) {
                        System.out.println("请重新输入用户名:");
                        username = input.next();
                    }
                    //userNameArray[userCount] = username;
                    System.out.println("请输入显示名:");
                    String screenName = input.next();
                    while (!testUser.screenNameIsRight(screenName)){
                        System.out.println("请重新输入显示名:");
                        screenName = input.next();
                    }
                    //screenNameArray[userCount] = screenName;
                    System.out.println("请输入密码:");
                    String password = input.next();
                    while (!testUser.passwordIsRight(password)){
                        System.out.println("请重新输入密码:");
                        password = input.next();
                    }
                    //passwordArray[userCount] = password;
                    System.out.println("请确认密码:");
                    String confirmPassword = input.next();
                    while (!testUser.confirmPasswordIsRight(password,confirmPassword)){
                        System.out.println("请重新输入确认密码:");
                        confirmPassword = input.next();
                    }
                    System.out.println("请输入邮箱:");
                    String mailAddress = input.next();
                    while (!testUser.mailAddressIsRight(mailAddress)){
                        System.out.println("请重新输入邮箱:");
                        mailAddress = input.next();
                    }
                    //emailAddressArray[userCount] = mailAddress;
                    System.out.println("请选择密码提示问题:");
                    System.out.println("1.Q1");
                    System.out.println("2.Q2");
                    System.out.println("3.Q3");
                    System.out.println("4.Q4");
                    System.out.println("5.Q5");
                    int choice = input.nextInt();
                    System.out.println("请回答密码提示问题:");
                    String answer = input.next();
                    while (!testUser.answerIsRight(answer)){
                        System.out.println("请重新回答密码提示问题:");
                        answer = input.next();
                    }
                    //answerArray[userCount] = answer;
                    System.out.println("请作答:5*3-6=");
                    int result = input.nextInt();
                    if(result == 9) {
                        System.out.println("注册成功!");
                        User user = new User(username,screenName,password,mailAddress,choice,answer);
                        users[userCount] = user;
                        userCount++;
                    }
                    else{
                        System.out.println("请作答:5*4-6=");
                        result = input.nextInt();
                        if(result == 14) {
                            System.out.println("注册成功!");
                            User user = new User(username,screenName,password,mailAddress,choice,answer);
                            users[userCount] = user;
                            userCount++;
                        }
                        else{
                            System.out.println("请作答:1*4+2=");
                            result = input.nextInt();
                            if(result ==6) {
                                System.out.println("注册成功!");
                                User user = new User(username,screenName,password,mailAddress,choice,answer);
                                users[userCount] = user;
                                userCount++;
                            }
                            else{
                                System.out.println("请作答:8/4+3=");
                                result = input.nextInt();
                                if(result == 5) {
                                    System.out.println("注册成功!");
                                    User user = new User(username,screenName,password,mailAddress,choice,answer);
                                    users[userCount] = user;
                                    userCount++;
                                }
                                else {
                                    System.out.println("请作答:9/3-6=");
                                    result = input.nextInt();
                                    if(result == -3) {
                                        System.out.println("注册成功!");
                                        User user = new User(username,screenName,password,mailAddress,choice,answer);
                                        users[userCount] = user;
                                        userCount++;
                                    }
                                    else{
                                        System.out.println("注册失败!");
                                    }
                                }
                            }
                        }
                    }
                    userCount++;
                    loginMenu();
                    break;
                case 2:
                    String inputUsername = null;
                    String inputPassword = null;
                    System.out.println("请输入用户名：");
                    inputUsername = input.next();
                    while (!testUser.usernameIsRight(inputUsername)) {
                        System.out.println("请重新输入用户名:");
                        inputUsername = input.next();
                    }
                    System.out.println("请输入密码:");
                    inputPassword = input.next();
                    while (!testUser.passwordIsRight(inputPassword)){
                        System.out.println("请重新输入密码:");
                        inputPassword = input.next();
                    }
                    if(checkInformation(inputUsername,inputPassword)){
                        logoutMenu(inputUsername);
                    }
                    break;
                case  3:
                    System.out.println("请输入用户名:");
                    String forgetName = input.next();
                    int item = 0;
                    for(int i = 0; i < users.length;i++){
                        if(forgetName.equals(users[i].getUserName())){
                            item = i;
                            break;
                        }
                    }
                    User forgetUser = users[item];
                    System.out.println("注册时的验证问题:" + testAnswers[forgetUser.getChoice()]);
                    System.out.println("答案是:");
                    String testAnswer = input.next();
                    String newPassword = null;
                    if(testAnswer.equals(forgetUser.getAnswer())){
                        System.out.println("请输入新密码:");
                        newPassword = input.next();
                        while (!testUser.passwordIsRight(newPassword)){
                            System.out.println("请重新输入新密码:");
                            newPassword = input.next();
                        }
                        System.out.println("请确认密码:");
                        confirmPassword = input.next();
                        while (!testUser.confirmPasswordIsRight(newPassword,confirmPassword)){
                            System.out.println("请重新输入确认密码:");
                            confirmPassword = input.next();
                        }
                    }
                    forgetUser.setPassword(newPassword);
                    loginMenu();
                    break;
            }
        }

        private static void logoutMenu(String username){
            Scanner input = new Scanner(System.in);
            int option;
           /* for(int i = 0;i < userCount;i++){
                if(users[i].getUserName().equals(username))
                    System.out.println("1.[" + users[i].getScreenName() + "]" + "退出登录" );
            }*/
            System.out.println("1.[" + users[index].getScreenName() + "]" + "退出登录");
            System.out.println("2.系统设置");
            System.out.println("3.写日记");
            System.out.println("4.查找日记");
            System.out.println("5.退出系统");
            System.out.println("请选择：");
            option = input.nextInt();
            switch (option){
                case 1:
                    loginMenu();
                    break;
                case 2:
                    System.out.println("正在执行系统设置功能");
                    logoutMenu(username);
                    break;
                case 3:
                    writeDairy();
                    logoutMenu(username);
                    break;
                case 4:
                    System.out.println("正在执行查找日记功能");
                    logoutMenu(username);
                    break;
                case 5:
                    System.out.println("正在退出系统功能");
                    logoutMenu(username);
                    break;
            }

        }
        public static void writeDairy(){
            Scanner input = new Scanner(System.in);
            Weather weather = null;
            Mood mood = null;
/*            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("EEEE/MM/dd");
            Date defaultDate = new Date();*/
            tanbo.wu.data.menue.Date date = new tanbo.wu.data.menue.Date();
            String diaryDate = null;
            String year;
            String month;
            String day;
            System.out.println("请选择天气:");
            System.out.println("1.sunny" + "\n" +
                                "2.cloudy" + "\n" +
                                "3.windy" + "\n" +
                                "4.rainy" + "\n" +
                                "5.snowy");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    weather = Weather.sunny;
                    break;
                case 2:
                    weather = Weather.cloudy;
                    break;
                case 3:
                    weather = Weather.windy;
                    break;
                case 4:
                    weather = Weather.rainy;
                    break;
                case 5:
                    weather = Weather.snowy;
                    break;
            }
            System.out.println("请选择心情");
            System.out.println("1.happy" + "\n" +
                                "1.sad" + "\n" +
                                "3.normal");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    mood = Mood.happy;
                    break;
                case 2:
                    mood = Mood.sad;
                    break;
                case 3:
                    mood = Mood.normal;
                    break;
            }
            System.out.println("请输入日期(格式为xxxx-xx-xx):");
            diaryDate = input.next();
            /*diaryDate = new tanbo.wu.data.menue.Date(date);*/
            while(!tanbo.wu.data.menue.Date.isDateRight(diaryDate)){
                System.out.println("日期错误！请重新输入：");
                diaryDate = input.next();
            }
            date.setDate(diaryDate);
            System.out.println("请输入标题(不能超过12个字):");
            String diaryTitle = input.next();
            while(!(diaryTitle.length() >= 0 && diaryTitle.length() <= 12)){
                System.out.println("请重新输入标题(不能超过12个字):");
                diaryTitle = input.next();
            }
            String ch = input.nextLine();
            System.out.println("请输入日记内容:");
            String diaryContents = input.nextLine();
            System.out.println("请选择是否保存日记：1.保存 2.不保存");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    Diary diary = new Diary(date,weather,mood,diaryTitle,diaryContents);
                    System.out.println(diary.toString());
                    break;
                default:
                    break;
            }
        }


    public static void secondMenue () {
            System.out.println("1.按标题查找");
            System.out.println("2.按内容查找");
            System.out.println("3.按日期查找");
            System.out.println("4.按心情查找");
            System.out.println("5.按天气查找");
            System.out.println("6.返回上一层菜单");
            System.out.println("请选择：");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            while (!(option >= 1 && option <= 6)) {
                System.out.println("Input Error,input again");
                option = input.nextInt();
            }
            switch (option) {
                case 1:
                    System.out.println("正在执行按标题查找功能");
                    break;
                case 2:
                    System.out.println("正在执行按内容查找功能");
                    break;
                case 3:
                    System.out.println("正在执行按日期查找功能");
                    break;
                case 4:
                    System.out.println("正在执行按心情查找功能");
                    break;
                case 5:
                    System.out.println("正在执行按天气查找功能");
                    break;
                case 6:
                    mainMenu();
                    break;
            }
        }

        /*private boolean usernameIsRight(String username){
            if(!(username.charAt(0) >= 'A' && username.charAt(0) <= 'z')){
                return false;
            }
            if(!(username.length() >=6 && username.length() <= 20)){
                return false;
            }
            for(int i = 0;i < username.length();i++){
                if(!((username.charAt(i) >= '0' && username.charAt(i) <= '9') || (username.charAt(i) >= 'A' && username.charAt(i) <= 'z') || username.charAt(i) == '_')){
                    return false;
                }
            }
            return true;
        }

        private boolean screenNameIsRight(String screenName){
            return screenName.length() >= 3 && screenName.length() <= 20;
        }*/

        private boolean passwordIsRight(String password){
            boolean hasFigure = false;
            boolean hasLetter = false;
            boolean hasFix = false;
            if(!(password.length() >= 8 && password.length() <= 30)){
                return false;
            }
            for (int i = 0;i < password.length();i++){
                if(password.charAt(i) <= '9' && password.charAt(i) >= '0') hasFigure = true;
                if(password.charAt(i) <= 'z' && password.charAt(i) >= 'A') hasLetter = true;
                if(password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#' || password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '*' || password.charAt(i) == '^' ){
                    hasFix = true;
                }
                if (hasFigure && hasFix && hasLetter){
                    return true;
                }
            }
            return false;
        }

        private boolean confirmPasswordIsRight(String password, String confirmPassword){
            return password.equals(confirmPassword);
        }

        /*private boolean mailAddressIsRight(String mailAddress){
            if (mailAddress == null)
                return false;
            if(!(mailAddress.length() <= 50)){
                return false;
            }
            String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern p;
            Matcher m;
            p = Pattern.compile(regEx1);
            m = p.matcher(mailAddress);
            if (m.matches())
                return true;
            else
                return false;
        }*/

        private boolean answerIsRight(String answer){
            if (answer == null){
                return false;
            }
            else{
                return true;
            }
        }


        private static boolean checkInformation(String username, String password){

            for(int i = 0;i < userCount;i++){
                if(users[i].getUserName().equals(username)){
                    if(users[i].getPassword().equals(password)){
                        index = i;
                        return true;
                    }
                }
            }
            return false;
        }
    }


    /*
     * @Author:2017110342_吴谭波
     * @Description:实现用户功能
     * @Date: 2019/10/18
     * @Modified By:2017110342_吴谭波
     */

package tanbo.wu.data.menue;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class User {
        private String userName = null;
        private String screenName = null;
        private String password = null;
        private String mailAddress = null;
        private int choice = 0;
        private String answer = null;


    public String getUserName() {
        return userName;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getPassword() {
        return password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public int getChoice() {
        return choice;
    }

    public String getAnswer() {
        return answer;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User(String userName, String screenName, String password, String mailAddress, int choice, String answer) {
        this.userName = userName;
        this.screenName = screenName;
        this.password = password;
        this.mailAddress = mailAddress;
        this.choice = choice;
        this.answer = answer;
    }
    public User(){

    }

    public boolean isSuccess() {
        return false;
    }

        public boolean usernameIsRight(String username){
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

        public boolean screenNameIsRight(String screenName){
            return screenName.length() >= 3 && screenName.length() <= 20;
        }

        public boolean passwordIsRight(String password){
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

        public boolean confirmPasswordIsRight(String password, String confirmPassword){
            return password.equals(confirmPassword);
        }

        public boolean mailAddressIsRight(String mailAddress){
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
            return m.matches();
        }

        public boolean answerIsRight(String answer){
            return answer != null;
        }

}

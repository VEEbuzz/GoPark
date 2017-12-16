package vaibhav.vaibhavmain;

/**
 * Created by simpl on 15-04-2017.
 */

public class UserInformation {
    private String Username;
    private String Email;
    private static Integer Count;

    public UserInformation()
{

}

    public UserInformation(String Username, String Email, Integer Count) {
        this.Username = Username;
        this.Email = Email;
        this.Count = Count;

    }

    public String getusername() {
        return Username;
    }

    public String getemail() {
        return Email;
    }

    public Integer getcount() {
return Count;
    }

}
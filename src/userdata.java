public class userdata {
    private String Username;
    private String Userid;
    private String UserPwd;
    private String UserImgPath;
    public userdata(String id,String name,String Pwd,String path)
    {
        this.Username=name;
        this.Userid=id;
        this.UserPwd=Pwd;
        this.UserImgPath=path;
    }

}

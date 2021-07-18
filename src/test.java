import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        database D=new database("root","123456");
        D.insert("123","123","123","abcde");
        D.show();
//        D.insert("1004","方","123456","123456");
//        D.delete("1001","123456");
//        userdata user_1=D.getuser("1002");
//        D.delete("1002","123456");
//        userdata user_2=D.getuser("1002");
//        D.insert("1002","方","123456","123456");
//        System.out.println(user_1);
//        System.out.println(user_2);
        System.out.println(D.getalluser() );
    }
}
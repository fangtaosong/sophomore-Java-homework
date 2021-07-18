
import java.sql.*;
import java.util.*;

import java.sql.SQLException;

public class database {
    Connection connection = null;
    public database(String name,String password)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cippus_sys",name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    void show()
    {
        System.out.println(this.connection);
    }
    void insert(String id,String name,String password,String userImagepath) throws SQLException {
        PreparedStatement prep=connection.prepareStatement("insert into user_stu values(?,?,?,?,?)");
        prep.setString(1,id);
        prep.setString(2,name);
        prep.setString(3,password);
        prep.setString(4,"student");
        prep.setString(5,userImagepath);
        prep.execute();
    }
    public void delete(String id,String password) throws SQLException {
        PreparedStatement prep =connection.prepareStatement("delete  from user_stu where user_id=?");
        prep.setString(1,id);
        prep.execute();
    }
    public userdata getuser(String tid) throws SQLException {
        PreparedStatement prep =connection.prepareStatement("select * from user_stu where user_id=?");
        prep.setString(1,tid);
        prep.executeQuery();
        ResultSet resultSet =prep.getResultSet();
        if(resultSet.next())
        {
            String name=resultSet.getString("user_name");
            String id =resultSet.getString("user_id");
            String password = resultSet.getString("password");
            String path =resultSet.getString("userImgPath");
            return new userdata(id,name,password,path);
        }
        else
        {
            return null;
        }
    }
    public ArrayList<userdata> getalluser() throws SQLException {
        ArrayList<userdata> temp=new ArrayList<userdata>();
        PreparedStatement prep =connection.prepareStatement("select * from user_stu ");
        prep.executeQuery();
        ResultSet resultSet =prep.getResultSet();
        while (resultSet.next())
        {
            String name=resultSet.getString("user_name");
            String id =resultSet.getString("user_id");
            String password = resultSet.getString("password");
            String path =resultSet.getString("userImgPath");
            temp.add(new userdata(id,name,password,path));
        }
        return temp;
    }
    public void close()throws SQLException
    {
        connection.close();
    }
    public boolean check(String userid,String pwd) throws SQLException {
        PreparedStatement prep =connection.prepareStatement("select * from user_stu where user_id=? and password=?");
        prep.setString(1,userid);
        prep.setString(2,pwd);
        prep.executeQuery();
        ResultSet resultSet =prep.getResultSet();
        if(resultSet.next())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public project_item search(String userid) throws SQLException {
        PreparedStatement prep =connection.prepareStatement("select * from project_list where member_1=? or member_2=? or member_3=? or member_4=? or member_5=?");
        prep.setString(1,userid);
        prep.setString(2,userid);
        prep.setString(3,userid);
        prep.setString(4,userid);
        prep.setString(5,userid);
        prep.executeQuery();
        ResultSet resultSet =prep.getResultSet();
        if(resultSet.next())
        {
            int id=resultSet.getInt("id");
            String name=resultSet.getString("name");
            String member_1=resultSet.getString("member_1");
            String member_2=resultSet.getString("member_2");
            String member_3=resultSet.getString("member_3");
            String member_4=resultSet.getString("member_4");
            String member_5=resultSet.getString("member_5");
            String stage=resultSet.getString("stage");
            String projectlevel=resultSet.getString("projectlevel");
            String fileid=resultSet.getString("fileid");
            return new project_item(id,name,member_1,member_2,member_3,member_4,member_5,stage,projectlevel,fileid);
        }
        else
        {
            return new project_item("error");
        }
    }
}

import java.sql.*;

public class ProjectUtil {
    public static Connection connection;

    public static boolean getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cippus_sys","root", "123456");
            System.out.println("连接成功");
            return true;
        }catch (Exception e){
            System.out.println("连接失败");
            e.printStackTrace();
            return false;
        }
    }
    public static boolean change(String member1,String member2,String member3,String member4,String member5)
    {
        ProjectUtil.getConnect();
        int numofMember = 0;
        ResultSet rs;
        try{

            PreparedStatement prep = connection.prepareStatement("" +
                    "update project_list " +
                    "set member_1 = ? " +
                    ", member_2 = ? " +
                    ", member_3 = ? " +
                    ", member_4 = ? " +
                    ", member_5 = ? " +
                    "where member_1 = ?");
            prep.setString(1,member1);
            prep.setString(2,member2);
            prep.setString(3,member3);
            prep.setString(4,member4);
            prep.setString(5,member5);
            prep.setString(6,member1);
            prep.executeUpdate();

            prep.close();
            connection.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    public static boolean createProject(String projectname,String teamLeader){
        ProjectUtil.getConnect();
        try {
            PreparedStatement prep = connection.prepareStatement("insert into project_list(name,member_1) values(?,?)");
            prep.setString(1,projectname);
            prep.setString(2,teamLeader);
            prep.executeUpdate();
            prep.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean addMember(String projectname,String memberName){
        ProjectUtil.getConnect();
        int numofMember = 0;
        ResultSet rs;
        try{
            PreparedStatement prep = connection.prepareStatement
                    ("select (5-(isnull(member_1)+ isnull(member_2)+isnull(member_3)+isnull(member_4)+isnull(member_5))) " +
                            "as '成员数' from project_list where name = ?");
            prep.setString(1,projectname);
            rs = prep.executeQuery();
            rs.next();
            numofMember = rs.getInt(1);
            if(numofMember == 5){
                System.out.println("队伍已满员");
                return false;
            }
            prep = connection.prepareStatement("update project_list set member_" + (numofMember+1) +"=? ,stage='5',projectlevel='1'   where name = ?");
            prep.setString(1,memberName);
            prep.setString(2,projectname);
            prep.execute();
            rs.close();
            prep.close();
            connection.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean deleteMember(String projectname,String member){
        ProjectUtil.getConnect();
        int numofMember = 0;
        ResultSet rs;
        String swap = member;
        String lastString;
        try{
            PreparedStatement prep = connection.prepareStatement
                    ("select (5-(isnull(member_1)+ isnull(member_2)+isnull(member_3)+isnull(member_4)+isnull(member_5))) " +
                            "as '成员数' from project_list where name = ?");
            prep.setString(1,projectname);
            rs = prep.executeQuery();
            rs.next();
            numofMember = rs.getInt(1);
            prep = connection.prepareStatement("select * from project_list where name = ?");
            prep.setString(1,projectname);
            rs = prep.executeQuery();
            rs.next();
            lastString = rs.getString(2+numofMember);
            for(int i = 3;i<= 2 + numofMember;i++){
                if (swap.equals(rs.getString(i))){
                    prep = connection.prepareStatement("update project_list set member_" + (i-2) +"=? where name = ?" );
                    prep.setString(1,lastString);
                    prep.setString(2,projectname);
                    prep.execute();
                    prep = connection.prepareStatement("update project_list set member_" + numofMember +"=null where name = ?");
                    prep.setString(1,projectname);
                    prep.execute();
                    rs.close();
                    prep.close();
                    connection.close();
                    return true;
                }
            }
            System.out.println("删除失败");
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    public static void main(String[] args){
        ProjectUtil.deleteMember("1111","3333");
    }

    public static boolean change_name(String pro_name, String member_1) {
        ProjectUtil.getConnect();
        int numofMember = 0;
        ResultSet rs;
        try{

            PreparedStatement prep = connection.prepareStatement("" +
                    "update project_list " +
                    "set name = ? " +
                    "where member_1 = ?");
            prep.setString(1,pro_name);
            prep.setString(2,member_1);

            prep.executeUpdate();

            prep.close();
            connection.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    public static boolean admin_change(String id, String name, String member_1, String stage, String projectlevel)
    {
        ProjectUtil.getConnect();
        int numofMember = 0;
        ResultSet rs;
        try{

            PreparedStatement prep = connection.prepareStatement("" +
                    "update project_list " +
                    "set id = ? " +
                    ", name = ? " +
                    ", member_1 = ? " +
                    ", stage = ? " +
                    ", projectlevel = ? " +
                    "where id = ?");
            prep.setString(1,id);
            prep.setString(2,name);
            prep.setString(3,member_1);
            prep.setString(4,stage);
            prep.setString(5,projectlevel);
            prep.setString(6,id);
            prep.executeUpdate();
            prep.close();
            connection.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
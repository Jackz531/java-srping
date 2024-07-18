import java.sql.*;
public class DemoJdbc {
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String password = "1234";
        Connection con=DriverManager.getConnection(url,user,password);
        System.out.println("Connected to database");
//        Statement st=con.createStatement();
//        String sql="select * from student";
//        ResultSet rs=st.executeQuery(sql);
////        System.out.println(rs.next());//rs.next is requires so the pointer is moved  to the 1st record else error might come here print is there with next() so its fine
////        String name=rs.getString("sname");
//        while(rs.next())//used to print multiple rows rs.next also handles the pointer to next
//        {
////            System.out.print(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3));
//
//            System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3));
//
//
//        }line 12-22 for reading R in CRUD
//        System.out.println(name);

        //INSERT
//        String sql="insert into student values(6,'sayuj',97)";
//        boolean status=st.execute(sql);//returns diff types of rersult if insert reutrns count so it will be false in those cases
//        System.out.println(status);

//   //UPDATE
//
//        String sql="update student set sname='Raj' where sname='RajRaj'";
//        boolean status=st.execute(sql);//returns diff types of rersult if insert reutrns count so it will be false in those cases
//        System.out.println(status);

// now we have prepared statements to prevent sql injection and to handle user given values more conveniently
        int sid=7;
        String sname="aswin";
        int marks=101;
        String sql="Insert into student values(?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);

        st.setInt(1,sid);
        st.setString(2,sname);
        st.setInt(3,marks);
        st.execute();

        con.close();
        System.out.println("connection closed");
    }
}

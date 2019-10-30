import java.sql.*;
public class DB {
    Connection con;
    Statement stmt;
    ResultSet rs;
    DB() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost/dblibrary";
        con=DriverManager.getConnection(url,"root","root");
        stmt=con.createStatement();
    }
    void update(String qry) throws Exception
    {
        stmt.executeUpdate(qry);
    }
    public ResultSet execute(String qry)throws Exception
    {
        rs=stmt.executeQuery(qry);
        return rs;
    }
    public int getBookCatId()throws Exception
    {
        String qry="select ifnull(max(bookcatid),0)max from tbbookcat";
        rs=stmt.executeQuery(qry);
        rs.next();
        int n=rs.getInt("max");
        n++;
        return n;
    }
    public int getBookId()throws Exception
    {
        String qry="select ifnull(max(bookid),0)max from tbbook";
        rs=stmt.executeQuery(qry);
        rs.next();
        int n=rs.getInt("max");
        n++;
        return n;
    }
    public int getIssueId()throws Exception
    {
        String qry="select ifnull(max(issueid),0)max from tbissue";
        rs=stmt.executeQuery(qry);
        rs.next();
        int n=rs.getInt("max");
        n++;
        return n;
    }
    public int getFineId()throws Exception
    {
        String qry="select ifnull(max(fineid),0)max from tbfine";
        rs=stmt.executeQuery(qry);
        rs.next();
        int n=rs.getInt("max");
        n++;
        return n;
    }
    public int getStudentId()throws Exception
    {
        String qry="select ifnull(max(stuid),0)max from tbStudent";
        rs=stmt.executeQuery(qry);
        rs.next();
        int n=rs.getInt("max");
        n++;
        return n;
    }   
}

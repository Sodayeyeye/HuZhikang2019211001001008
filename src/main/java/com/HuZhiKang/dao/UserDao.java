package com.HuZhiKang.dao;

import com.HuZhiKang.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert ..into usertable --- do it yourself
        String sql ="insert into usertable(id,username,password,email,gender,birthdate) values(?,?,?,?,?,?)";
        PreparedStatement p=con.prepareStatement(sql);
        p = con.prepareStatement(sql);
        p.setInt(1,user.getId());
        p.setString(1, user.getUsername());
        p.setString(2, user.getPassword());
        p.setString(3, user.getEmail());
        p.setString(4, user.getGender());
        p.setDate(5,(java.sql.Date)user.getBirthDate());
        p.executeUpdate();
        if(p.executeUpdate()>0)
            return true;
        else
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete ...... where id=
        String  sql="delete from usertable where id=?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setInt(1,user.getId());
        int i =p.executeUpdate();
        if (i > 0) {
            return 1;
        }else
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update ...... where id=? do yourself
        //TODO 5.1 - write update sql where id = ?
        //TODO 5.2 - create prepared statement
        //TODO 5.3 - executeUpdate()
        //TODO 5.4 - return int
        String sql="update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setString(1,user.getUsername());
        p.setString(2,user.getPassword());
        p.setString(3,user.getEmail());
        p.setString(4,user.getGender());
        p.setDate(5, (java.sql.Date) user.getBirthDate());
      //  System.out.println( user.getBirthDate());
        p.setInt(6,user.getId());
        int i =p.executeUpdate();
        if (i > 0) {
            return 1;
        }else
            return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select --- where id=?--- write jdbc code yourself
        String sql="select * from usertable where id=?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setInt(1,id);
        ResultSet rs=p.executeQuery();
        User user=null;
            if(rs.next()){
                //get from rs and set into user model
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthDate(rs.getDate("birthdate"));

                //done
            }

        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //use for login
        //selete --- where username=? and password=?--- i will show you now
        String sql="Select * from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            //get from rs and set into user model
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));

            //done
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //select --- where username=?--- write jdbc code yoursele
        String sql="select * from usertable where username=?";
        List<User> userList = new ArrayList<>();
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            //Put the user object into the list
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //select --- where password=?--- write jdbc code yoursele
        String sql="select * from usertable where password = ?";
        List<User> userList = new ArrayList<>();
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            //Put the user object into the list
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //select --- where email=?--- write jdbc code yoursele
        String sql="select * from usertable where email=?";
        List<User> userList = new ArrayList<>();
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            //Put the user object into the list
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //select --- where gender=?--- write jdbc code yoursele
        String sql="select * from usertable where gender=?";
        List<User> userList = new ArrayList<>();
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            //Put the user object into the list
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        //select --- where birthDate=?--- write jdbc code yoursele
        String sql="select * from usertable where birthdate=?";
        List<User> userList = new ArrayList<>();
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            //Put the user object into the list
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //select * from usertable--- --- write jdbc code yourself
        String sql="select * from usertable";
        List<User> userList = new ArrayList<>();
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            //Put the user object into the list
            userList.add(user);
        }
        return userList;
    }
}

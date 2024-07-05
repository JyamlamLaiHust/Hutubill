package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.Config;
import util.DBUtil;

public class ConfigDAO {

    private static final String SQL_ADD = "INSERT INTO config VALUES(DEFAULT,?,?);";
    private static final String SQL_UPDATE = "UPDATE config SET key_=?,value=? WHERE id=?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM config WHERE id = ?";
    private static final String SQL_GET = "SELECT * FROM config WHERE id=?";
    private static final String SQL_GET_ALL_WITH_PAGE = "SELECT * FROM config order by id desc limit ?,?";
    private static final String SQL_GET_TOTAL = "SELECT COUNT(*) FROM config";
    private static final String SQL_GET_BY_KEY = "SELECT * FROM config WHERE key_=?";

    public void add(Config config){
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement prep = conn.prepareStatement(SQL_ADD,new String[]{"id"});){
            prep.setString(1, config.getKey());
            prep.setString(2, config.getValue());
            if(	prep.executeUpdate()>0){
                ResultSet rs = prep.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    config.setId(id);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Config config){
        try(Connection conn =DBUtil.getConnection();
            PreparedStatement prep = conn.prepareStatement(SQL_UPDATE)){

            prep.setString(1, config.getKey());
            prep.setString(2, config.getValue());
            prep.setInt(3, config.getId());

            prep.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id){
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement prep = conn.prepareStatement(SQL_DELETE_BY_ID)){
            prep.setInt(1, id);
            prep.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Config getById(int id){
        Config config = null;

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement prep = conn.prepareStatement(SQL_GET)){
            prep.setInt(1, id);
            ResultSet rs = prep.executeQuery();
            if(rs.next()){
                config = new Config();
                config.setId(id);
                config.setKey(rs.getString("key_"));
                config.setValue(rs.getString("value"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }

    public List<Config> getConfig(){
        return getConfig(0, Short.MAX_VALUE);
    }

    public List<Config> getConfig(int start,int count){
        List<Config> configList = new ArrayList<Config>();
        Config config = null;
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement prep = conn.prepareStatement(SQL_GET_ALL_WITH_PAGE)){
            prep.setInt(1, start);
            prep.setInt(2, count);
            ResultSet rs = prep.executeQuery();

            while(rs.next()){
                config  = new Config();
                config.setId(rs.getInt("id"));
                config.setKey(rs.getString("key_"));
                config.setValue(rs.getString("value"));
                configList.add(config);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return configList;
    }


    public int getTotal(){
        int total = 0;
        try(Connection conn = DBUtil.getConnection();
            Statement state = conn.createStatement()){
            ResultSet rs = state.executeQuery(SQL_GET_TOTAL);
            if(rs.next()){
                total = rs.getInt(1);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return total;

    }


    public Config getBykey(String key){
        Config config = null;
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement prep = conn.prepareStatement(SQL_GET_BY_KEY)){
            prep.setString(1, key);
            ResultSet rs = prep.executeQuery();

            if(rs.next()){
                config = new Config();
                config.setId(rs.getInt("id"));
                config.setKey(key);
                config.setValue(rs.getString("value"));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return config;
    }
}
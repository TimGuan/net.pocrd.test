package net.pocrd.test.core.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * @author guankaiqiang Test
 */
public class TestDAO {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * c3p0 pool
     * @author guankaiqiang
     *
     */
    public static class C3P0Pool {
        private static ComboPooledDataSource mainCpds;
        static {
            mainCpds = new ComboPooledDataSource();
            try {
                mainCpds.setDriverClass("com.mysql.jdbc.Driver");
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
            mainCpds.setJdbcUrl("jdbc:mysql://localhost/gougoudai?");
            mainCpds.setUser("root");
            mainCpds.setPassword("123");
            mainCpds.setMaxStatementsPerConnection(5);
            mainCpds.setMaxStatements(10);
            mainCpds.setMaxPoolSize(10);
            mainCpds.setAcquireIncrement(20);
            mainCpds.setInitialPoolSize(5);
            mainCpds.setMinPoolSize(5);
        }
        public static DataSource getDataSource() {
            return mainCpds;
        }
        public static Connection getConnection() throws Exception {
            return mainCpds.getConnection();
        }
    }
    
    /**
     * tomcat jdbc pool
     * @author guankaiqiang
     *
     */
    public static class TomcatJDBCPool {
        private static org.apache.tomcat.jdbc.pool.DataSource datasource ;
        static {
            PoolProperties p = new PoolProperties();
            p.setUrl("jdbc:mysql://localhost/gougoudai");
            p.setDriverClassName("com.mysql.jdbc.Driver");
            p.setUsername("root");
            p.setPassword("123");
            p.setJmxEnabled(true);
            p.setTestWhileIdle(false);
            p.setTestOnBorrow(true);
            p.setTestOnReturn(false);
            p.setValidationInterval(30000);
            p.setTimeBetweenEvictionRunsMillis(30000);
            p.setMaxActive(10);
            p.setInitialSize(5);
            p.setMaxWait(10000);
            p.setRemoveAbandonedTimeout(60);
            p.setMinEvictableIdleTimeMillis(30000);
            p.setMinIdle(5);
            p.setMaxIdle(10);
            p.setLogAbandoned(true);
            p.setRemoveAbandoned(true);
            p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                    + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
            datasource= new org.apache.tomcat.jdbc.pool.DataSource();
            datasource.setPoolProperties(p);
        }
        public static DataSource getDataSource() {
            return datasource;
        }
        public static Connection getConnection() throws SQLException{
            return datasource.getConnection();
        }
    }

    
    public static final void closeQuietly(Connection conn, ResultSet rs, Statement st) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void testC3p0() {
        Connection conn = null;
        try {
            conn = C3P0Pool.getConnection();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        PreparedStatement pst = null;
        ResultSet result = null;
        int totalcount = 0;
        try {
            pst = conn.prepareCall("select count(1) from tb_product");
            result = pst.executeQuery();
            if (result.next()) {
                totalcount = result.getInt(1);
                System.out.println("========>totalcount:"+totalcount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(conn, result, pst);
        }
    }

    public void testJDBC() {
        Connection conn = null;
        try {
            conn = TomcatJDBCPool.getConnection();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        PreparedStatement pst = null;
        ResultSet result = null;
        int totalcount = 0;
        try {
            pst = conn.prepareCall("select count(1) from tb_product");
            result = pst.executeQuery();
            if (result.next()) {
                totalcount = result.getInt(1);
                System.out.println("========>totalcount:"+totalcount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(conn, result, pst);
        }
    }

    public void testCommonConnect() {
        Connection conn = null;
        try {
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost/gougoudai?user=root&password=123");
//                    .getConnection("jdbc:mysql://112.124.17.212:3306/test?useUnicode=true&amp;characterset=utf-8&user=gkq&password=gkq1990");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        PreparedStatement pst = null;
        ResultSet result = null;
        int totalcount = 0;
        try {
            pst = conn.prepareCall("select count(1) from tb_product");
            result = pst.executeQuery();
            if (result.next()) {
                totalcount = result.getInt(1);
                System.out.println("========>totalcount:"+totalcount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(conn, result, pst);
        }
    }
}

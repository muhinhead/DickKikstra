package com.dk.rmi;

import com.dk.OpticStore;
import com.dk.remote.IMessageSender;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Nick Mukhin
 */
public class ExchangeFactory {

    private static final int DB_VERSION_ID = 1;
    public static final String DB_VERSION = "0.1";
    private static String[] fixLocalDBsqls = new String[]{
        "update dbversion set version_id = " + DB_VERSION_ID + ",version = '" + DB_VERSION + "'"
    };
    private static IMessageSender exchanger;

    public static IMessageSender getExchanger(String connectString, Properties props) {
//        IMessageSender exchanger = null;
//        if (connectString.startsWith("rmi:")) {
//            try {
//                exchanger = (IMessageSender) Naming.lookup(connectString);
//                AIBclient.protocol = "rmi";
//            } catch (Exception ex) {
//                AIBclient.log("RMI server not found");
//            }
//        } else if (connectString.startsWith("jdbc:")) {
            String dbUser = props.getProperty("dbUser", "SA");
            String dbPassword = props.getProperty("dbPassword", "");
            String dbDriver = props.getProperty("dbDriverName", "org.hsqldb.jdbc.JDBCDriver");
            try {
                exchanger = createJDBCexchanger(dbDriver, connectString, dbUser, dbPassword);
                //AIBclient.protocol = "jdbc";
            } catch (Exception ex) {
                OpticStore.logAndShowErrorMessage(ex.getMessage());
            }
//        }
        return exchanger;
    }

//    public static IMessageSender createRMIexchanger(String address) throws NotBoundException, MalformedURLException, RemoteException {
//        AIBclient.protocol = "rmi";
//        return (IMessageSender) Naming.lookup("rmi://" + address + "/AIBserver");
//    }

    public static IMessageSender createJDBCexchanger(String[] dbParams) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        if (dbParams.length < 4) {
            return null;
        }
        return createJDBCexchanger(dbParams[0], dbParams[1], dbParams[2], dbParams[3]);
    }

    public static IMessageSender createJDBCexchanger(String dbDriver, String connectString,
            String dbUser, String dbPassword) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        if (dbDriver == null || dbDriver.isEmpty() || connectString == null || connectString.isEmpty()
                || dbUser == null || dbUser.isEmpty() || dbPassword == null /*|| dbPassword.isEmpty()*/) {
            throw new SQLException("Incomplete DB connection parameters");
        }
        //AIBclient.protocol = "jdbc";
        IMessageSender exchanger;
        DriverManager.registerDriver(
                (java.sql.Driver) Class.forName(dbDriver).newInstance());
        Connection connection = DriverManager.getConnection(connectString, dbUser, dbPassword);
        connection.setAutoCommit(true);
        sqlBatch(fixLocalDBsqls, connection, false);
        exchanger = new DbClientDataSender(OpticStore.getProperties());
        return exchanger;
    }

    public static void sqlBatch(String[] sqls, Connection connection, boolean tolog) {
        PreparedStatement ps = null;
        for (int i = 0; i < sqls.length; i++) {
            try {
                ps = connection.prepareStatement(sqls[i]);
                ps.execute();
                if (tolog) {
                    OpticStore.log("STATEMENT [" + sqls[i].substring(0,
                            sqls[i].length() > 60 ? 60 : sqls[i].length()) + "]... processed");
                }
            } catch (SQLException e) {
                if (tolog) {
                    OpticStore.log(e);
                }
            } finally {
                try {
                    ps.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
}

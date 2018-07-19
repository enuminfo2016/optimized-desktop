/**
 * 
 */
package com.enuminfo.optimized.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author Kumar
 */
public abstract class AbstractConnectionPool implements Runnable {
	
	private String driver, url, username, password;
    private int maxConnections;
    private boolean waitIfBusy;
    public Vector<Connection> availableConnections, busyConnections;
    private boolean connectionPending = false;
    
    protected static AbstractConnectionPool instance;
    
    public static void setInstance(AbstractConnectionPool newInstance) {
    	instance = newInstance;
    }
    
    public static AbstractConnectionPool getInstance() {
    	return instance;
    }
    
	protected AbstractConnectionPool(String driver, String url, String username, String password) throws SQLException {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		this.maxConnections = 5;
		this.waitIfBusy = true;
		availableConnections = new Vector<Connection>(5);
		busyConnections = new Vector<Connection>();
		for (int i = 0; i < 5; i++) {
			availableConnections.addElement(makeNewConnection());
		}
	}
	
	public synchronized Connection getConnection() throws SQLException {
		if (!availableConnections.isEmpty()) {
			Connection existingConnection = (Connection) availableConnections.lastElement();
			int lastIndex = availableConnections.size() - 1;
			availableConnections.removeElementAt(lastIndex);
			if (existingConnection.isClosed()) {
				notifyAll();
				return (getConnection());
			} else {
				busyConnections.addElement(existingConnection);
				return (existingConnection);
			}
		} else {
			if ((totalConnections() < maxConnections) && !connectionPending) {
				makeBackgroundConnection();
			} else if (!waitIfBusy) {
				throw new SQLException("Connection limit reached");
			}
			try {
				wait();
			} catch (InterruptedException ie) {
			}
			return (getConnection());
		}
	}

	private void makeBackgroundConnection() {
		connectionPending = true;
		try {
			Thread connectThread = new Thread(this);
			connectThread.start();
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			Connection connection = makeNewConnection();
			synchronized (this) {
				availableConnections.addElement(connection);
				connectionPending = false;
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection makeNewConnection() throws SQLException {
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println(Thread.currentThread().getName() + ": " + toString());
			return (connection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SQLException("ConnectionPool:: SQLException encountered:: " + e.getMessage());
		}
	}

	public synchronized void free(Connection connection) {
		busyConnections.removeElement(connection);
		availableConnections.addElement(connection);
		notifyAll();
	}

	private synchronized int totalConnections() {
		return (availableConnections.size() + busyConnections.size());
	}

	public synchronized void closeAllConnections() {
		closeConnections(availableConnections);
		availableConnections = new Vector<Connection>();
		closeConnections(busyConnections);
		busyConnections = new Vector<Connection>();
	}

	private void closeConnections(Vector<Connection> connections) {
		try {
			for (int i = 0; i < connections.size(); i++) {
				Connection connection = (Connection) connections.elementAt(i);
				if (!connection.isClosed()) {
					connection.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public synchronized String toString() {
		String info = "ConnectionPool(" + url + "," + username + ")" + ", available=" + availableConnections.size();
		return (info);
	}
}

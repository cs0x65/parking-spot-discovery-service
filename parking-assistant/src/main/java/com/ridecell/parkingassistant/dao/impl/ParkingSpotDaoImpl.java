package com.ridecell.parkingassistant.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ridecell.parkingassistant.dao.ParkingSpotDao;
import kanad.kore.data.dao.raw.AbstractRawDao;
import org.apache.logging.log4j.LogManager;

import com.ridecell.parkingassistant.model.ParkingSpot;


/**
 * @author Saurabh
 * git: champasheru saurabh.cse2@gmail.com
 *
 */
public class ParkingSpotDaoImpl extends AbstractRawDao<ParkingSpot> implements ParkingSpotDao {
	@Override
	public List<ParkingSpot> getAll() {
		LogManager.getLogger().info("Retrieving all parking spots...");
        String query="SELECT * FROM parking_spots";
        
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<ParkingSpot> spots = new ArrayList<>();
        try {
        	statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
            	spots.add(parse(rs));
            }
        } catch (SQLException sqle) {
        	LogManager.getLogger().error("Error:retrieving all parking spots...", sqle);
        } finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LogManager.getLogger().error("Error:retrieving parking spots", e);
			}
        }
        
        LogManager.getLogger().info("Number of all parking spots  found: "+spots.size());
        
        return spots;
	}

	@Override
	public List<ParkingSpot> getAvailable() {
		LogManager.getLogger().info("Retrieving available parking spots...");
        String query="SELECT p.* FROM parking_spots p LEFT JOIN bookings b ON p.id = b.pid where b.pid IS NULL";
        
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<ParkingSpot> spots = new ArrayList<>();
        try {
        	statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
				spots.add(parse(rs));
            }
        } catch (SQLException sqle) {
        	LogManager.getLogger().error("Error:retrieving available parking spots...", sqle);
        } finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LogManager.getLogger().error("Error:retrieving available parking spots", e);
			}
        }
        
        LogManager.getLogger().info("Number of available parking spots  found: "+spots.size());
        
        return spots;
	}

	@Override
	public List<ParkingSpot> getReserved() {
		LogManager.getLogger().info("Retrieving reserved parking spots...");
        String query="SELECT p.* FROM parking_spots p INNER JOIN bookings b ON p.id = b.pid";
        
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<ParkingSpot> spots = new ArrayList<>();
        try {
        	statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
				spots.add(parse(rs));
            }
        } catch (SQLException sqle) {
        	LogManager.getLogger().error("Error:retrieving reserved parking spots...", sqle);
        } finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LogManager.getLogger().error("Error:retrieving reserved parking spots", e);
			}
        }
        
        LogManager.getLogger().info("Number of reserved parking spots  found: "+spots.size());
        
        return spots;
	}

	private ParkingSpot parse(ResultSet rs){
		ParkingSpot parkingSpot = new ParkingSpot();
		try {
			parkingSpot.setId(rs.getLong("id"));
			parkingSpot.setLatitude(rs.getFloat("latitude"));
			parkingSpot.setLongitude(rs.getFloat("longitude"));
			parkingSpot.setAddress(rs.getString("address"));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return parkingSpot;
	}
}

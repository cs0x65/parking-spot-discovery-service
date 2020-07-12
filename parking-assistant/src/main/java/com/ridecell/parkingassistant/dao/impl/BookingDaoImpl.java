package com.ridecell.parkingassistant.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ridecell.parkingassistant.dao.BookingDao;
import kanad.kore.data.dao.raw.AbstractRawDao;
import org.apache.logging.log4j.LogManager;

import com.ridecell.parkingassistant.model.Booking;

public class BookingDaoImpl extends AbstractRawDao<Booking> implements BookingDao {

	@Override
	public Booking reserve(Booking booking) {
		String query = "INSERT INTO bookings(uid, pid, cost) VALUES(?, ?, ?)";
    	PreparedStatement statement = null;
    	
    	try{
    		statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    		
    		statement.setLong(1, booking.getUserId());
    		statement.setLong(2, booking.getParkingSpotId());
    		statement.setLong(3, booking.getCost());

    		int status = statement.executeUpdate();
    		if(status > 0){
    			LogManager.getLogger().info("Reservation created successfully!");
    			ResultSet rs = statement.getGeneratedKeys();
    			if(rs.next()){
    				booking.setId(rs.getLong(1));
    			}
    		}
    	}catch(SQLException e){
    		LogManager.getLogger().error("Couldn't complete reservation!", e);
    	}finally{
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LogManager.getLogger().error("Couldn't complete reservation!", e);
			}
    	}
    	
    	return booking;
	}

	@Override
	public void cancel(long bookingId) {
		String query = "DELETE FROM bookings WHERE id = ?";
    	PreparedStatement statement = null;
    	
    	try{
    		statement = connection.prepareStatement(query);
    		statement.setLong(1, bookingId);

    		int status = statement.executeUpdate();
    		if(status > 0){
    			LogManager.getLogger().info("Reservation cancelled successfully!");
    		}
    	}catch(SQLException e){
    		LogManager.getLogger().error("Couldn't complete reservation cancellation!", e);
    	}finally{
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LogManager.getLogger().error("Couldn't complete reservation cancellation!", e);
			}
    	}
	}

}

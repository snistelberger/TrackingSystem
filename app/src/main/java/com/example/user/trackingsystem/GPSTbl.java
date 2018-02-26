package com.example.user.trackingsystem;

/**
 * Created by User on 26.02.2018.
 */

public class GPSTbl {
    public static final String TABLE_NAME = "GPSDATA";

    public final static String initialID = "InitialID";
    public final static String longitude = "Longitude";
    public final static String latitude = "Latitude";
    public final static String altitude = "Altitude";
    public final static String datum = "Datum";
    public static final String [] ALL_COLUMNS = new String[] {initialID, longitude, latitude, altitude, datum};

    public final static String SQL_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public final static String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                initialID + "INTEGER PRIMARY KEY, " +
                longitude + "TEXT NOT NULL, " +
                latitude + "TEXT NOT NULL, " +
                altitude + "TEXT NOT NULL, " +
                datum + "TEXT NOT NULL)";
    public final static String STMT_INSERT = "INSERT INTO " + TABLE_NAME + "(" + longitude + ", " + latitude + ", " + altitude + ", " + datum + ")" + "VALUES (?,?,?,?)";
    public final static String STMT_DELETE = "DELETE FROM " + TABLE_NAME;
}

package com.acrylic.databases;

import java.util.ArrayList;

/**
 * Standard database interface.
 */
public interface Database {

    Database add(String variable, Object value);

    Object get(String variable);

    byte getByte(String variable);

    int getInteger(String variable);

    long getLong(String variable);

    float getFloat(String variable);

    double getDouble(String variable);

    String getString(String variable);

    ArrayList getList(String variable);

    Database getInstance();

}

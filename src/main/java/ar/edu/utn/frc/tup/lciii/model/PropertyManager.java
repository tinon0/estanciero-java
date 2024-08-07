package ar.edu.utn.frc.tup.lciii.model;

import java.util.ArrayList;
import java.util.List;

public class PropertyManager {
    private static PropertyManager instance;
    private List<Property> properties;

    private PropertyManager() {
        properties = new ArrayList<>();
    }

    public static synchronized PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public List<Property> getAllProperties() {
        return properties;
    }
}

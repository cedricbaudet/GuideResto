package ch.hearc.ig.guideresto.business;

/**
 * @author cedric.baudet
 * Interface to build a restaurant
 */
public interface RestaurantBuilder {

    void reset();

    RestaurantBuilderType getBuilderType();

    void setBasicAttributes(Integer id, String name, String description, String website);

    void setType(Integer id, String label, String description);

    void setType(RestaurantType type);

    void setLocalisation(String street, City city);

    void setLocalisation(Localisation localisation);

    void setEvaluation(Boolean like);

    Restaurant getRestaurant();
}

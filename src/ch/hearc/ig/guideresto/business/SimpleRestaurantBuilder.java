package ch.hearc.ig.guideresto.business;

import ch.hearc.ig.guideresto.persistence.mock.FakeItems;

/**
 * @author cedric.baudet
 * An builder implementation to build a simple restaurant MVP ;-)
 */
public class SimpleRestaurantBuilder implements RestaurantBuilder {

    private final RestaurantBuilderType builderType;
    private Restaurant restaurant;

    public SimpleRestaurantBuilder() {
        builderType = RestaurantBuilderType.SIMPLE;
    }

    public void reset() {
        this.restaurant = new Restaurant();
    }

    public RestaurantBuilderType getBuilderType() {
        return builderType;
    }

    public void setBasicAttributes(Integer id, String name, String description, String website) {
        restaurant.setId(id);
        restaurant.setName(name);
        restaurant.setDescription(description);
        restaurant.setWebsite(website);
    }

    public void setType(RestaurantType type) {
        restaurant.setType(type);
        type.getRestaurants().add(restaurant);
    }

    public void setType(Integer id, String label, String description) {
        RestaurantType newType = new RestaurantType(id, label, description);
        restaurant.setType(newType);
        newType.getRestaurants().add(restaurant);
    }

    public void setLocalisation(String street, City city) {
        restaurant.setAddress(new Localisation(street, city));
        city.getRestaurants().add(restaurant);
    }

    public void setLocalisation(Localisation localisation) {
        restaurant.setAddress(localisation);
        localisation.getCity().getRestaurants().add(restaurant);
    }

    public void setEvaluation(Boolean like) {
    }

    public Restaurant getRestaurant() {
        FakeItems.getAllRestaurants().add(restaurant);
        return restaurant;
    }
}

package ch.hearc.ig.guideresto.business;

import ch.hearc.ig.guideresto.persistence.mock.FakeItems;
import ch.hearc.ig.guideresto.presentation.Application;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cedric.baudet
 * An builder implementation to build a simple restaurant MVP ;-)
 */
public class RestaurantWithEvaluationsBuilder implements RestaurantBuilder {

    private final RestaurantBuilderType builderType;
    private Restaurant restaurant;

    public RestaurantWithEvaluationsBuilder() {
        builderType = RestaurantBuilderType.WITHEVALUATION;
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
        String ipAddress;
        try {
            ipAddress = Inet4Address.getLocalHost().toString(); // Permet de retrouver l'adresse IP locale de l'utilisateur.
        } catch (UnknownHostException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.INFO, "Error - Couldn't retreive host IP address");
            ipAddress = "Indisponible";
        }
        BasicEvaluation eval = new BasicEvaluation(1, new Date(), restaurant, like, ipAddress);
        restaurant.getEvaluations().add(eval);

    }

    public Restaurant getRestaurant() {
        FakeItems.getAllRestaurants().add(restaurant);
        return restaurant;
    }
}

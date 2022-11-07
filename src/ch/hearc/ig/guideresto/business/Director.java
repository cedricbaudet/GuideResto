package ch.hearc.ig.guideresto.business;

/**
 * @author cedric.baudet
 */
public class Director {

    private RestaurantBuilder builder;

    public Director(RestaurantBuilder builder) {
        this.builder = builder;
    }

    public void changeBuilder(RestaurantBuilder builder) {
        this.builder = builder;
    }

    public void make(Integer id, String name, String description, String website, String street, City city, RestaurantType type) {
        builder.reset();

        builder.setBasicAttributes(id, name, description, website);
        builder.setType(type);
        builder.setLocalisation(street, city);

    }

    public void make(Integer id, String name, String description, String website, String street, City city, RestaurantType type, Boolean simpleEvaluation) {
        this.make(id, name, description, website, street, city, type);

        if (builder.getBuilderType() == RestaurantBuilderType.WITHEVALUATION) {
            builder.setEvaluation(simpleEvaluation);
        }
    }
}

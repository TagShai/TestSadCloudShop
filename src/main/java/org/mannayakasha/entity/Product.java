package org.mannayakasha.entity;

/**
 * Simple JavaBean object, that represents entity product.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */

public class Product extends Entity {

    private String name;

    private Double price;

    private String description;

    private String fullDescription;

    private String image;

    private boolean novelty;

    public Product() {}

    public Product(Integer id, String name, Double price, String description, String fullDescription, boolean novelty, String image) {
        super(id);
        this.name = name;
        this.price = price;
        this.description = description;
        this.fullDescription = fullDescription;
        this.novelty = novelty;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isNovelty() {
        return novelty;
    }

    public void setNovelty(boolean novelty) {
        this.novelty = novelty;
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", price=" + price +
                ", description='" + description +
                ", fullDescription='" + fullDescription +
                ", novelty=" + novelty;
    }
}

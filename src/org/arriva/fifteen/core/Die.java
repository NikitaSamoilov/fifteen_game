package org.arriva.fifteen.core;

public abstract class Die {

    protected DieProperty property;
    protected Field parentField;

    public int getRating() {
        return property.rating;
    }
    
    public void setRating(int rating) {
        property.rating = rating;
    }

    public int getRow() {
        return property.row;
    }


    public int getCol() {
        return property.col;
    }


    public Die(Field parentField, DieProperty property) {
        this.parentField = parentField;
        this.property = property;
    }

}

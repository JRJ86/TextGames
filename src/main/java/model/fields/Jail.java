package model.fields;

public abstract class Jail extends Field {

    String description;

    //--------------- Getters & Setters --------------------------------------------------------------------------------

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package iss.nus.server36.models;

public class Weather {
    
    private String name;
    private Float temp;
    private Float temp_min;
    private Float temp_max;
    private Float feels_like;
    private String main;
    private String description;
    private String icon;
    
    @Override
    public String toString() {
        return "Weather [name=" + name + ", temp=" + temp + ", temp_min=" + temp_min + ", temp_max=" + temp_max
                + ", feels_like=" + feels_like + ", main=" + main + ", description=" + description + ", icon=" + icon
                + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Float temp_min) {
        this.temp_min = temp_min;
    }

    public Float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Float temp_max) {
        this.temp_max = temp_max;
    }

    public Float getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Float feels_like) {
        this.feels_like = feels_like;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    

}

package me.nilme.exercise.java.concurrent.diancai;

/**
 * @Auther: yehan
 * @Date: 19/6/27 16:50
 * @Description:
 */
public class Food {

    private String name;

    private Integer price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Food() {
    }

    public Food(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}

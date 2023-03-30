package me.nilme.exercise.java.concurrent.diancai;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: yehan
 * @Date: 19/6/27 16:48
 * @Description: 菜单
 */
public class Menu {


    /**
     * 总金额
     */
    private Integer totalAmount;

    /**
     * 菜
     */
    private List<Food> foodList;

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}

package me.nilme.exercise.java.concurrent.diancai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: yehan
 * @Date: 19/6/27 16:55
 * @Description: 菜单组件
 */
public class MenuComponent {


    //蔬菜
    private static List<Food> vegetableFoodList = new ArrayList<>();
    //肉菜
    private static List<Food> meatFoodList = new ArrayList<>();
    //水产
    private static List<Food> fishFoodList = new ArrayList<>();
    //汤
    private static List<Food> soupFoodList = new ArrayList<>();
    //冷菜
    private static List<Food> coldFoodList = new ArrayList<>();


    /**
     * 重新初始化菜单
     */
    private static void reinitializeFood(){
        vegetableFoodList.clear();
        meatFoodList.clear();
        fishFoodList.clear();
        soupFoodList.clear();
        coldFoodList.clear();

        vegetableFoodList.add(new Food("香菇青菜", 12));
        vegetableFoodList.add(new Food("麻辣豆腐", 12));
        vegetableFoodList.add(new Food("酸辣土豆丝", 12));
        vegetableFoodList.add(new Food("本芹三丝", 15));
        vegetableFoodList.add(new Food("韭菜炒蛋", 15));
        vegetableFoodList.add(new Food("番茄炒蛋", 15));
        vegetableFoodList.add(new Food("酱爆茄子", 15));
        vegetableFoodList.add(new Food("鸡蛋炒粉丝", 15));
        vegetableFoodList.add(new Food("干菜刀豆", 15));
        vegetableFoodList.add(new Food("干锅花菜", 16));
        vegetableFoodList.add(new Food("干锅包菜", 16));
        vegetableFoodList.add(new Food("干锅土豆", 16));
        vegetableFoodList.add(new Food("家常日本豆腐", 18));
        vegetableFoodList.add(new Food("一品娃娃菜", 20));



        meatFoodList.add(new Food("小炒鸡",20));
        meatFoodList.add(new Food("小炒肉",20));
        meatFoodList.add(new Food("水煮肉片",20));
        meatFoodList.add(new Food("糖醋里脊",20));
        meatFoodList.add(new Food("宫保鸡丁",20));
        meatFoodList.add(new Food("醋烧鸡",28));
        meatFoodList.add(new Food("番茄牛腩",32));


        fishFoodList.add(new Food("红烧带鱼",20));
        fishFoodList.add(new Food("红烧鱼块",25));
        fishFoodList.add(new Food("椒盐带鱼",26));
        fishFoodList.add(new Food("鲈鱼",28));
        fishFoodList.add(new Food("明虾",30));
        fishFoodList.add(new Food("酸菜黑鱼",38));
        fishFoodList.add(new Food("剁椒鱼头",38));
        fishFoodList.add(new Food("麻辣小龙虾",38));


        soupFoodList.add(new Food("雪菜豆腐汤",8));
        soupFoodList.add(new Food("番茄蛋花汤",10));
        soupFoodList.add(new Food("紫菜蛋花汤",10));
        soupFoodList.add(new Food("鱼头豆腐汤",25));


        coldFoodList.add(new Food("手拍黄瓜",15));
        coldFoodList.add(new Food("凉拌松花蛋",16));
        coldFoodList.add(new Food("凉拌黑木耳",16));
        coldFoodList.add(new Food("卤鸭",28));
        coldFoodList.add(new Food("白斩鸡",38));
        coldFoodList.add(new Food("五香牛肉",30));
    }





    public static void main(String[] args) {

        Integer vegetableCount = 5;//素菜个数
        Integer meatFoodCount = 2;//炒菜个数
        Integer fishFoodCount = 1;//水产个数
        Integer soupFoodCount = 2;//汤个数
        Integer coldFoodCount = 2;//冷菜个数
        Integer ticketCount = 16;//饭票数
        Integer upperAmount = ticketCount * 15;
        Menu menu = null;
        //尝试生成菜单10次
        for (int i = 0; i < 10; i++) {
            //重新初始化菜单
            reinitializeFood();
            menu = generateMenu(vegetableCount, meatFoodCount, fishFoodCount, soupFoodCount, coldFoodCount);
            if (menu.getTotalAmount() <= upperAmount){
                break;
            }
        }
        if (menu.getTotalAmount() > upperAmount){
            System.out.println("点的菜太多，给的钱太少，生成不了符合的菜单");
            return;
        }
        //打印
        System.out.println("#############点菜单#############");
        System.out.println("########菜名#######价格########");

        for (Food food : menu.getFoodList()) {
            System.out.println(food.getName()+"______"+food.getPrice());
        }
        System.out.println("总计:"+menu.getTotalAmount());

    }








    public static Menu generateMenu(Integer vegetableCount, Integer meatFoodCount,
                                    Integer fishFoodCount, Integer soupFoodCount, Integer coldFoodCount){
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.addAll(generateFood(vegetableCount,vegetableFoodList));
        foodList.addAll(generateFood(meatFoodCount,meatFoodList));
        foodList.addAll(generateFood(fishFoodCount,fishFoodList));
        foodList.addAll(generateFood(soupFoodCount,soupFoodList));
        foodList.addAll(generateFood(coldFoodCount,coldFoodList));
        //米饭必点
        foodList.add(new Food("米饭",12));
        Integer totalAmount = 0;
        //总计
        for (Food food : foodList) {
            totalAmount = totalAmount + food.getPrice();
        }
        Menu menu = new Menu();
        menu.setTotalAmount(totalAmount);
        menu.setFoodList(foodList);
        return menu;
    }





    /**
     * 随意点某一类的菜
     * @param orderFoodCount
     * @param waitOrderFoodList
     * @return
     */
    public static List<Food> generateFood(Integer orderFoodCount, List<Food> waitOrderFoodList){
        List<Food> alreadyOrderfoodList = new ArrayList<>();
        Random random = new Random();
        if (null != orderFoodCount && orderFoodCount > 0){
            for (int i = 0; i < orderFoodCount; i++) {
                Food food = waitOrderFoodList.get(random.nextInt(waitOrderFoodList.size()));
                alreadyOrderfoodList.add(food);
                //选单后移除菜品
                waitOrderFoodList.remove(food);
            }
        }
        return alreadyOrderfoodList;
    }






}

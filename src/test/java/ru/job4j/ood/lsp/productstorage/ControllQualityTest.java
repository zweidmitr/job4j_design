package ru.job4j.ood.lsp.productstorage;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ControllQualityTest {
    List<Storage> storageList;
    ControllQuality controlFood;

    @Before
    public void init() {
        this.storageList = List.of(new Warehouse(), new Shop(), new Trash());
        this.controlFood = new ControllQuality(storageList);
    }

    @Test
    public void whenFoodAddToTrash() {
        Food crisps = new Crisps("Pringles",
                LocalDate.now().minusDays(2),
                LocalDate.now().minusDays(222),
                125, 50);
        controlFood.controll(crisps);
        Storage trash = storageList.get(2);
        assertThat(trash.getFoodList(), is(List.of(crisps)));
    }

    @Test
    public void whenFoodAddToShop() {
        Food chilli = new Chilli("Халапеньо",
                LocalDate.now().plusDays(365),
                LocalDate.now().minusDays(135),
                100, 7);
        controlFood.controll(chilli);
        Storage shop = storageList.get(1);
        assertThat(shop.getFoodList(), is(List.of(chilli)));
    }

    @Test
    public void whenFoodAddToShopWithDiscount() {
        Food chilli = new Chilli("Халапеньо",
                LocalDate.now().plusDays(15),
                LocalDate.now().minusDays(365),
                100, 35);
        controlFood.controll(chilli);
        assertThat(chilli.getPrice(), is(65.0));
    }

    @Test
    public void whenFoodAddToWarehouse() {
        Food olive = new Olivier("ДваЧасаКрошил",
                LocalDate.now().plusDays(333),
                LocalDate.now().minusDays(33),
                9999.99, 0.17);
        controlFood.controll(olive);
        Storage wareHouse = storageList.get(0);
        assertThat(wareHouse.getFoodList(), is(List.of(olive)));
    }

    @Test
    public void whenResortAllFood() {
        List<Food> foods = List.of(
                new Olivier("ДваЧасаКрошил",
                        LocalDate.now().plusDays(333),
                        LocalDate.now().minusDays(33),
                        9999.99, 0.17),
                new Chilli("Халапеньо",
                        LocalDate.now().plusDays(365),
                        LocalDate.now().minusDays(135),
                        100, 7));
        for (Food food : foods) {
            controlFood.relocate(food);
        }
        storageList.get(1).getFoodList().get(0).setExpiryDate(LocalDate.now());
        storageList.get(0).getFoodList().get(0).setExpiryDate(LocalDate.now());
        controlFood.resort();
        assertThat(storageList.get(2).getFoodList().get(0).getName(), is("ДваЧасаКрошил"));
        assertThat(storageList.get(2).getFoodList().get(1).getName(), is("Халапеньо"));
    }
}
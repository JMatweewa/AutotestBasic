package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CashbackHackServiceTest {
    CashbackHackService cashbackHackService = new CashbackHackService();

    @Test
    public void shouldCalculateRemainAverageValue() {
        int amount = 550;
        Assert.assertEquals(cashbackHackService.remain(amount), 450);
    }

    @Test
    public void shouldCalculateRemainValueNull() {
        int amount = 0;
        Assert.assertEquals(cashbackHackService.remain(amount), 1000);
    }

    @Test
    public void shouldCalculateRemainValue1() {
        int amount = 1;
        Assert.assertEquals(cashbackHackService.remain(amount), 999);
    }

    @Test
    public void shouldCalculateRemainNegativeValue() {
        int amount = -1; // производит расчет при отрицательном балансе, желательно проверить требования
        Assert.assertEquals(cashbackHackService.remain(amount), 1001);
    }

    @Test
    public void shouldCalculateRemainValue999() {
        int amount = 999;
        Assert.assertEquals(cashbackHackService.remain(amount), 1);
    }

    @Test
    public void shouldCalculateRemainValueFinalBoundary1000() {
        int amount = 1000; // при покупке ровно на 1000р предлагает купить ещё на 1000р.
        Assert.assertEquals(cashbackHackService.remain(amount), 0);
    }

    @Test
    public void shouldCalculateRemainValue1001() {
        int amount = 1001;
        Assert.assertEquals(cashbackHackService.remain(amount), 999);
    }
}
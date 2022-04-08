package ru.netology.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class CashbackHackServiceTest {
    CashbackHackService cashbackHackService = new CashbackHackService();

    @Test
    public void shouldCalculateRemainAverageValue() {
        int amount = 550;
        assertEquals(450, cashbackHackService.remain(amount));
    }

    @Test
    public void shouldCalculateRemainValueNull() {
        int amount = 0;
        assertEquals(1000, cashbackHackService.remain(amount));
    }

    @Test
    public void shouldCalculateRemainValue1() {
        int amount = 1;
        assertEquals(999, cashbackHackService.remain(amount));
    }

    @Test
    public void shouldCalculateRemainNegativeValue() {
        int amount = -1; // производит расчет при отрицательном балансе, желательно проверить требования
        assertEquals(1001, cashbackHackService.remain(amount));
    }

    @Test
    public void shouldCalculateRemainValue999() {
        int amount = 999;
        assertEquals(1, cashbackHackService.remain(amount));
    }

    @Test
    public void shouldCalculateRemainValueFinalBoundary1000() {
        int amount = 1000; // при покупке ровно на 1000р предлагает купить ещё на 1000р.
        assertEquals(0, cashbackHackService.remain(amount));
    }

    @Test
    public void shouldCalculateRemainValue1001() {
        int amount = 1001;
        assertEquals(999, cashbackHackService.remain(amount));
    }
}
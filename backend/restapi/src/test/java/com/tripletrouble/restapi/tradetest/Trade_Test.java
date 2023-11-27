package com.portfolio.restapi.tradetest;

import com.portfolio.restapi.entities.Trade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;




public class Trade_Test {
    /*Trade tr;
    @BeforeEach
    void beforeEach(){
      tr = new Trade("Appl",678.90,50,"BUY",0);
    }

    @Test
    void buyorsell_String_check(){

        String result = tr.getBuyOrSell();
        String result_uppercase =result.toUpperCase();
        assertThat(result).isIn("BUY","SELL");
    }*/
    @Test
    void nullStockticker_throwsException(){
        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, ()-> new Trade(null,98.0,700,"BUY",0));
        assertThat(exception.getMessage().equals("Stockticker can't be null"));
    }
    @Test
    void minusStockprice_throwsException(){
        assertThrows(IllegalArgumentException.class,()->new Trade("Appl",-78,100,"BUY",1));
    }

    @Test
    void check_buyorSell_throwsException(){
        assertThrows(IllegalArgumentException.class,()->new Trade("Appl",78,100,"abc",1));
    }

    @Test
    void checkVolume_throwsException(){
        assertThrows(IllegalArgumentException.class,()->new Trade("Appl",78,-9,"buy",1));
    }
}

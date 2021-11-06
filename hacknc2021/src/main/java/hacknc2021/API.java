package hacknc2021;
import java.math.BigInteger;
import java.util.List;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.AssetBalance;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.TickerPrice;

import io.api.etherscan.*;
import io.api.etherscan.model.Balance;
import io.api.etherscan.core.impl.EtherScanApi;
import io.api.etherscan.model.EthNetwork;
import io.api.etherscan.model.Price;




public class API {
    private String ETHAPIKEY = "YDCBXKWQUHHSDM4DB7256IVVERDUNXHM4K";
    private String BINANCEAPIKEY = "";
    private String BINANCESECRETKEY = "";
    private String provider;
    private String ethAddress;
    private BinanceApiClientFactory factory;
    private BinanceApiRestClient client;
    private EtherScanApi api;
    private Account account;

 
    public API(String provider, String ethString){
        if(provider != "eth"){
            throw new IllegalArgumentException();
        }
        else{
            this.provider = provider;
            this.api = new EtherScanApi(ETHAPIKEY);
            this.ethAddress = ethString;
        }
    }

    public API(String provider){
        if(provider != "binance"){
            throw new IllegalArgumentException();
        }
        this.provider = provider;
        this.factory = BinanceApiClientFactory.newInstance(BINANCEAPIKEY, BINANCESECRETKEY);
        this.client = factory.newRestClient();
        this.account = client.getAccount();
    }


    public List<AssetBalance> getBinanceAccountBalance(){
        return account.getBalances();
    }

    public String getBinanceBalanceCoin(String coin){
        return account.getAssetBalance(coin).getFree();
    }

    public String getBinancePrice(String coin){
        TickerPrice tick = new TickerPrice();
        tick.setSymbol(coin);
        return tick.getPrice();
    }

    public String getBinanceSpecificPrice(String coin){
        Double price = Double.parseDouble(getBinancePrice(coin)) * Double.parseDouble(getBinanceBalanceCoin(coin));
        return price.toString();
    }

    public List<Candlestick> getCandleStickData(String coin, CandlestickInterval interval){
        List<Candlestick> candlesticks = client.getCandlestickBars(coin, interval);
        return candlesticks;
    }


    public String getHigh(String coin, CandlestickInterval inter){
        List<Candlestick> dataList = getCandleStickData(coin, inter);
        return dataList.get(0).getHigh();
    }

    public String getLow(String coin, CandlestickInterval inter){
        List<Candlestick> dataList = getCandleStickData(coin, inter);
        return dataList.get(0).getLow();
    }

    public BigInteger getEthBalance(){
        //work
        Balance balance = api.account().balance(ethAddress);
        return balance.getEther();
    }

    public Double getEthPrice(){
        //work
        Price price = api.stats().lastPrice();
        return price.inUsd();
    }

    public String getMyEthCost(){
        //work
        Double price = getEthPrice() * getEthBalance().intValue(); 
        return price.toString();
    }

   

    //current price
    //CSV for previous prices
    //
}

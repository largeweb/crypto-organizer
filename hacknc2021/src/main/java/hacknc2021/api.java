package hacknc2021;
import java.math.BigInteger;
import java.util.List;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.AssetBalance;
import com.binance.api.client.domain.market.TickerPrice;

import io.api.etherscan.*;
import io.api.etherscan.core.impl.EtherScanApi;
import io.api.etherscan.model.Balance;
import io.api.etherscan.model.EthNetwork;
import io.api.etherscan.model.Price;
public class api {

    private String provider;
    private String ethAddress;
    private BinanceApiClientFactory factory;
    private BinanceApiRestClient client;
    private EtherScanApi api;
    private Account account;
 
    public api(String provider, String ethString){
        if(provider != "eth"){
            throw new IllegalArgumentException();
        }
        else{
            this.provider = provider;
            this.api = new EtherScanApi(EthNetwork.MAINNET);
        }
    }

    public api(String provider, String key, String secret){
        this.provider = provider;
        this.factory = BinanceApiClientFactory.newInstance(key, secret);
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

    public BigInteger getEthBalance(String ethAddress){
        Balance balance = api.account().balance(ethAddress);
        return balance.getEther();
    }

    public Price getEthPrice(){
        Price price = api.stats().lastPrice();
        return price;
    }

    //current price
    //CSV for previous prices
    //
}

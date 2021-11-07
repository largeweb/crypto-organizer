package hacknc2021;


interface trading{


//Buy coin
//Returns true/false based on success of operation
boolean buyCoin(String name);

//Sell coin
//Returns true/false based on success of operation
boolean sellCoin(String name);


//Trade coin
//Returns true/false based on success of operation
boolean tradeCoin(String name);

}
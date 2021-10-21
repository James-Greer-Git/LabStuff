import React, { Component } from "react";
import { stockArray } from "./stocks.js";

const localStocks = stockArray;

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { buying: [], selling: [], sArray: localStocks };
    this.buyStock = this.buyStock.bind(this);
    this.sellStock = this.sellStock.bind(this);
  } // end constructor

  buyStock(itemID){
    let foundObj = this.state.sArray.filter(
      this.findObjectBySymbol(itemID)
    );
    this.setState({buying: this.state.buying.concat(foundObj)});
  }
  emptyBuyStock(){
    this.setState({buying: []})
  }

  sellStock(itemID){
    let foundObj = this.state.sArray.filter(
      this.findObjectBySymbol(itemID)
    );
    this.setState({selling: this.state.selling.concat(foundObj)});
  }
  emptySellStock(itemID){
    this.setState({selling: []})
  }

  findObjectBySymbol(symbolToFind){
    return function (stockObject){
      return stockObject.Symbol === symbolToFind;
    };
  }

  render() {
    return (
      <div className="App">
        <h1>CS385 Stocks and Shares</h1>
        <ul>
          {this.state.sArray.map((s) => (
            <li key={s.Symbol}>
              <b>{s.Symbol}</b>, <i>{s.Company}</i> ${s.Price}
              <button onClick = {() => this.buyStock(s.Symbol)}>
                Buy
                </button>
              <button onClick = {() => this.sellStock(s.Symbol)}>
                Sell
                </button>
            </li>
          ))}
        </ul>

        <hr />
        <p>
          Total stock objects (BUY): {this.state.buying.length}
          <button onClick = {() => this.emptyBuyStock()}>Empty BuyStock</button>
          <br />
          Total stock objects (SELL): {this.state.selling.length}
          <button onClick = {() => this.emptySellStock()}>Empty SellStock</button>
        </p>
      </div>
    ); // end of return statement
  } // end of render function
} // end of class

export default App;

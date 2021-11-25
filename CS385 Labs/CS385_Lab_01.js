import React, { Component } from "react";


class App extends Component {
  render() {
    
    var alpha = 20;
    var beta = 100;
    var gamma = 1000;
    var x = "CS385";
    var y = "App Development";

    return (
      <div className="App">
        Sum of Alpha, beta and gamma: {alpha + beta + gamma}. {'\n'}
        Product of Alpha, beta and gamma: {alpha * beta * gamma}. {'\n'}
        (Alpha + Beta + Gamma)*10: {alpha*10 + beta*10 + gamma*10}. {'\n'}
        String x: {x}
        String y: {y}
        String x Uppercase: {x.toUpperCase()}
        String y Lowercase: {y.toLowerCase()}
        
      </div>
    );
  }
}
export default App;

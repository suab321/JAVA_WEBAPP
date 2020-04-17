import React from 'react';
import{
  BrowserRouter as Router,
  Switch,Route,Link, Redirect
} from 'react-router-dom'
import Test from './Components/Test';
class App extends React.Component{
  constructor(props){
    super(props);
    this.handle=this.handle.bind(this);
  }
  handle(){
    console.log(this.props);
  }
  render(){
    return(
      <Router>
      <div>
          {/* <Link to="/node_modules">Prac</Link> */}
          <Switch>
            <Route exact strict path="/:path" component={Test}/>
            <Route component={Test}/>
          </Switch>
      </div>
  </Router>
  )
  }
}

export default App;

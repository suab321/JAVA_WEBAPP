import React from 'react';
import Axios from 'axios';
import{
    BrowserRouter as Router,
    Switch,Route,Link, Redirect
  } from 'react-router-dom'

class Test extends React.Component{
    constructor(props){
        super(props);
        console.log("Test")
        this.state={
            curUrl:'',
            contents:[]        
        }
    }
    componentDidMount(){
        var path=this.props.location.pathname.substr(1);
        Axios.post(`http://localhost:3002/path`,{name:path}).then(res=>{
            this.setState({contents:res.data.contents,curUrl:path})
            console.log(res);
        }).catch(err=>{
            console.log(err);
        })
    }

    render(){
        const render=this.state.contents.map(i=>{
            const route="/"+i.Info.name;
            const arr=i.Info.name.split('/');
            // console.log(arr.length);
            const name=arr[arr.length-1];
            // console.log(name)
            // console.log(route);
            return(
                
                <Router>
                    <div>
                        {/* <Switch>
                            <Route exact strict path={route} component={Test}/>
                        </Switch> */}
                        <a href={route}>{name}</a>
                        {/* <Route path={route} component={Test}/> */}
                    </div>
                </Router>
            )
        })
        return(
            <div>
                {render}
            </div>
        );
    }
}

export default Test;
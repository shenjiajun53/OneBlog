import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';

class Index extends React.Component{
    constructor(props){
        super(props)
    }

    render(){
        return (
            <div>
                <h1>
                    hhhhhhhhhhhhhhhh
                </h1>
                <div>
                    1111111111111111
                </div>
            </div>
        )
    }
}

ReactDOM.render(
    <Index/>,
    document.getElementById('root')
);

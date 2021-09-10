import React, {Component, useState, useEffect} from 'react';
import Header from './components/Header';
import './App.css';
import PrimeNumber from './components/PrimeNumber';

function App () {
    return (
        <div className="App">
            <Header/>
            <PrimeNumber/>
        </div>
    )
}

export default App;
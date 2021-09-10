import React, {Component, useState, useEffect} from 'react';
import Button from './Button'
import InputText from './InputText'
import ResultBox from './ResultBox'
import LoadSpinner from './LoadSpinner';

const PrimeNumber = () => {
    const [isLoaded, setIsLoaded] = useState(true);
    const [primeNumbers, setPrimeNumbers] = useState("");
    const [numberRangeInputValue, setNumberRangeInputValue] = useState("");
    
    const onChangeInputValue = (e) => {
        setNumberRangeInputValue(e.target.value);
    };  
    const generatePrimeNumbers = async (e) => {
        setIsLoaded(false);
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ numberOrRange: numberRangeInputValue })
        };
        const response = await fetch('/api/primenumber/getPrimeNumbersInRange', requestOptions);
        const data = await response.json();
        setPrimeNumbers(data);
        setIsLoaded(true);
    };
    return (
        <div>
            <h1>Prime Number Generator</h1>
            <InputText placeholder="Enter Number" onChangeInputValue={onChangeInputValue}/>
            <Button title="Generate Prime Numbers" onClick={generatePrimeNumbers}/>
            <ResultBox results={primeNumbers}/>
            {!isLoaded &&<LoadSpinner />}
        </div>
    )
}
export default PrimeNumber

import React from 'react'
import '../App.css';
function InputText({onChangeInputValue,placeholder}) {

    return (
        <input type="text" className="inputtxt" placeholder={placeholder} onKeyUp={onChangeInputValue} />
    )
}

export default InputText

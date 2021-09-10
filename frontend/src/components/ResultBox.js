import React from 'react'
import '../App.css';
function ResultBox({results}) {
    return (
        <div>
            <h1>List Of Prime Numbers({results.length})</h1>
            <textarea type="text" className="selectbox" value={results}>
        </textarea>
        </div>
    )
}

export default ResultBox

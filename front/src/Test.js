import { useEffect, useState } from 'react';
import { postJson } from './api';
import JsonTester from './components/JsonTester';



function Test() {

    const [data, setData] = useState(null);
    let jsonData = {
        strData1: '111',
        strData2: '222',
        strData3: '333'
      }
  
    useEffect(() => {
        postJson(jsonData).then((res) => setData(res.data));
    }, []);
  
    if(data === null){
      return <div>Loading...</div>
    }
  
    return (
        <div className="App">
        <header className="App-header">
          <JsonTester data={data}/>
        </header>
      </div>
    );
  }

  export default Test;
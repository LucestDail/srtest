import { useEffect, useState } from 'react';
import './App.css';
import { getKoreaeximApi } from './api';
import KoreaeximComponent from './components/getKoreaexim';

function Koreaexim() {

  const [data, setData] = useState(null);
 
  useEffect(() => {
    getKoreaeximApi().then((res) => setData(res.data));
  }, []);

  if(data === null){
    return <div>Loading...</div>
  }

  return (
    <div className="App">
      <header className="App-header">
        <KoreaeximComponent data={data}/>
      </header>
    </div>
  );
}

export default Koreaexim;

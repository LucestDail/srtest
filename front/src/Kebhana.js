import { useEffect, useState } from 'react';
import './App.css';
import { getKebhanaApi } from './api';
import KebhanaComponent from './components/getKebhana';


function Kebhana() {

  const [data, setData] = useState(null);

  useEffect(() => {
    getKebhanaApi().then((res) => setData(res.data));
  }, []);

  if(data === null){
    return <div>Loading...</div>
  }

  return (
    <div className="App">
      <header className="App-header">
        <KebhanaComponent data={data}/>
      </header>
    </div>
  );
}

export default Kebhana;

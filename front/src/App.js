import { useEffect, useState } from 'react';
import './App.css';
import { getHello } from './api';
import Hello from './components/Hello';


function App() {

  const [data, setData] = useState(null);

  useEffect(() => {
    getHello().then((res) => setData(res.data));
  }, []);

  if(data === null){
    return <div>Loading...</div>
  }

  return (
    <div className="App">
      <header className="App-header">
        <Hello data={data}/>
      </header>
    </div>
  );
}

export default App;

import logo from './logo.svg';
import './App.css';
import useForm from './Hooks/userForm';


function App() {

  

  const {  handlechange, value, error } = useForm();

  return (
    <div className="App">
      <form>
   

      <input type="email" name="email"  placeholder='email' onChange={handlechange}></input>

        <input type="password" name="password" placeholder='pass' onChange={handlechange}></input>
        { error.password && <h4>{error.password}</h4> } 
        <input type="text" name="username" placeholder='name' onChange={handlechange}></input>
        { error.username && <h4>{error.username}</h4> } 
        <input type="submit" value="Submit"></input>
        
      </form>
    </div>
  );
}

export default App;

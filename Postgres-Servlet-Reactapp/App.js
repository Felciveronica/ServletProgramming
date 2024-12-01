import React from "react";
import './App.css';

export default function App()
{
 const handlesubmit=(event)=>
 {
   event.preventDefault();
   const data=new FormData(event.target);

   fetch("http://localhost:8080/UserManagement/login?user="+data.get("name")+"&pass="+data.get("password"),{crossDomain:true})
   .then((res)=>res.json())
   .then((data)=>{

   if(data.status==="success")
   {
    alert("sucesss");
   }
   else{
    alert("failed");
   }
   });

 }

   return(   
  
      <div className="App">
   <form  onSubmit={handlesubmit}>
   <div className="form-group">
    <label>name</label>
    <input type="text" className="form-control" placeholder="enter name" name='name' ></input>
    </div>
    <div className="form-group">
    <label>pass</label>
    <input type="password" className="form-control" placeholder="enter name"  name='pwd'></input>
    </div>
   
   <button type="submit" >Submit</button>
    
   </form>

      </div>


   ) ;
}
 /**   
import React from "react";
import './App.css';

export default function App() {
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.target);
    //http://localhost:8080/UserManagement/login?user=felci&pass=felci 
    fetch(`http://localhost:8080/UserManagement/login?user=${data.get('name')}&pass=${data.get('password')}`, {
      crossDomain: true,
    })
      .then((res) => res.json())
      .then((data) => {
        if (data.status === "success") {
          alert("Success! you are logged in");
        } else {
          alert("Failed");
        }
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("An error occurred during submission.");
      });
  };

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Name</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter name"
            name="name"
          ></input>
        </div>
        <div className="form-group">
          <label>Password</label>
          <input
            type="password"
            className="form-control"
            placeholder="Enter password"
            name="password"
          ></input>
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}
**/
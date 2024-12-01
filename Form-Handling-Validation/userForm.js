 import { useState } from "react"
import {omit} from "lodash"



const useForm=()=>
{
   const[value, getvalue]=useState({});
   const[error, setError]=useState({});

   const handlechange=(event)=>
   {
    event.persist();

     let val=event.target.value;
     let name=event.target.name;
     console.log(val);
     
     getvalue({ ...value, [name]:val})
     console.log(value[name]);
     console.log(name);

     validate(event,name,val);

   }

   const validate=(event,name,value)=>
   {    //console.log("console"+value.length);
      switch(name)
      { case 'username':
             
            {console.log("value in console    "+value[name]);
      
            if(value.length<8)
            { console.log("case----");
                setError({...error, username:'User name should be at least 8 characters long'});
            }

            else{
                     let obj=omit(error, "username");
                     setError(obj);
            }}
            case 'password':
                {
                    if(! new RegExp(  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/  )) 
                    {
                        setError({...error, password:'Password should contain at least 8 characters, including one uppercase letter, one lowercase letter, one number, and one special character'});
                    }
                    else{
                        let obj=omit(error,'password');
                        setError(obj);
                    }
                }
        }
   }

   return{
    handlechange, value,error
   };
}

export default useForm;

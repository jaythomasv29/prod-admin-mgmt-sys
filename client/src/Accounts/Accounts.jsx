import React, { useEffect, useState } from 'react'
import { v4 as uuidv4 } from 'uuid';


function Accounts() {
  const [accounts, setAccounts] = useState([]);
  console.log(accounts)
  useEffect(() => {
    const fetchAccounts = async () => {
      const response = await fetch("/accounts/all");
      const data = await response.json();
      setAccounts(data);
      
    }
    fetchAccounts();
  }, [])

  return (
   <div>
    <p>Accounts</p>
    <table className="table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Email</th>
          <th>Gender</th>
          <th>Telephone</th>
          <th>Role(s)</th>
          <th>Action</th>
        </tr>
      </thead>

      <tbody>
      {
        accounts.map(account => (
          <tr key={account.id}>
            <td>{account.fullname}</td>
            <td>{account.email}</td>
            <td>{account.gender}</td>
            <td>{account.telephone}</td>
            <td>
              {
                account.roles.map(role => (
                  <p key={uuidv4()} className="font-xs">{role.name}</p>
                ))
              }
            </td>
            <td>
              <button className="btn btn-sm btn-primary mx-1">Edit</button>
              <button className="btn btn-sm btn-danger">Delete</button>
            </td>
          </tr>
        ))
      }
      </tbody>
    </table>
   </div>
  )
}

export default Accounts
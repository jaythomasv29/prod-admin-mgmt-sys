import React, { useEffect, useState } from 'react'

function Businesses() {
  const [businesses, setBusinesses] = useState([]);
  console.log(businesses)
  useEffect(() => {
    const fetchBusinesses = async () => {
      const response = await fetch("/businesses/all");
      const data = await response.json();
      setBusinesses(data);
      
    }
    fetchBusinesses();
  }, [])

  return (
   <div>
    <p>Businesses</p>
    <table className="table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Email</th>
          <th>Address</th>
          <th>Telephone</th>
          <th>Action</th>
        </tr>
      </thead>

      <tbody>
      {
        businesses.map(business => (
          <tr key={business.id}>
            <td>{business.name}</td>
            <td>{business.email}</td>
            <td>{business.address}</td>
            <td>{business.telephone}</td>
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

export default Businesses
import React, { useState, useEffect } from 'react';

export const ApiFetch = () => {
  const [addresses, setAddresses] = useState([]);

  const [address, setAddress] = useState('');
  const [district, setDistrict] = useState('');
  const [city_id, setCity_id] = useState('');
  const [phone, setPhone] = useState('');
  const [location, setLocation] = useState('');
  const [last_update, setLast_update] = useState('');

  useEffect(() => {
    // APIをfetchする(呼び出す)
    fetch('http://localhost:8080/api/Address', { method: 'GET' })
      // レスポンスのデータ形式をjsonに設定
      .then((res) => res.json())
      // APIから渡されるレスポンスデータ(data)をstateにセットする
      .then((data) => {
        setAddresses(data);
      });
  }, []);

  const handleSubmit = (event) => {
    fetch('http://localhost:8080/api/Address', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        address: address,
        district: district,
        city_id: city_id,
        phone: phone,
        // location: location,
        last_update: last_update,
      }),
    }).then(
      function (response) {
        // レスポンス結果
        response.json().then((json) => {
          addresses.push(json);
        });
      },
      function (error) {
        // エラー内容
        console.log(error);
      }
    );
  };

  return (
    <div>
      <table border={1}>
        <tbody>
          {addresses.map((address) => (
            <tr key={address.address_id}>
              <td>{address.address}</td>
              <td>{address.district}</td>
              <td>{address.city_id}</td>
              <td>{address.phone}</td>
              <td>{address.last_update}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div>
        address:{' '}
        <input onChange={(e) => setAddress(e.target.value)} value={address} />
      </div>
      <div>
        district:{' '}
        <input onChange={(e) => setDistrict(e.target.value)} value={district} />
      </div>
      <div>
        city_id:{' '}
        <input onChange={(e) => setCity_id(e.target.value)} value={city_id} />
      </div>
      <div>
        phone:{' '}
        <input onChange={(e) => setPhone(e.target.value)} value={phone} />
      </div>
      <div>
        location:{' '}
        <input onChange={(e) => setLocation(e.target.value)} value={location} />
      </div>
      <div>
        last_update:{' '}
        <input
          onChange={(e) => setLast_update(e.target.value)}
          value={last_update}
        />
      </div>
      <div>
        <button onClick={handleSubmit}>送信</button>
      </div>
    </div>
  );
};

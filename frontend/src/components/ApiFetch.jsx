import React, { useState, useEffect } from "react";

export const ApiFetch = () => {
	const [addresses, setAddress] = useState([]);

	useEffect(() => {
		// APIをfetchする(呼び出す)
		fetch("http://localhost:8080/api/Address", { method: "GET" })
			// レスポンスのデータ形式をjsonに設定
			.then((res) => res.json())
			// APIから渡されるレスポンスデータ(data)をstateにセットする
			.then((data) => {
				setAddress(data[0]);
			});
	}, []);

	return (
		<div>
			<ul>
				<li>{addresses.address_id}</li>
				<li>{addresses.address}</li>
			</ul>
		</div>
	);
};

<%--
  Created by IntelliJ IDEA.
  User: junil
  Date: 26. 10. 27.
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid #222;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #222;
            width: 200px;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>상품명</th>
                <th>가격</th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>

    <script>

        async function getProductList() {
            const response = await fetch("http://localhost:8080/api/products", {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                }
            });
            // const responseText = await response.text(); //그냥 json 문자열
            // const responseJson = JSON.parse(responseText); //json -> object변환
            const responseJson = await response.json();
            console.log(response)
            // console.log(responseText)
            console.log(responseJson)
            const tbody = document.querySelector("tbody");
            // console.log(responseJson.map((product, index) => (
            //     `
            //         <tr>
            //             <td>\${index + 1}</td>
            //             <td>\${product.productName}</td>
            //             <td>\${product.price}</td>
            //         </tr>
            //     `
            // )));
            tbody.innerHTML = responseJson.map((product, index) => (
                `
                    <tr>
                        <td>\${index + 1}</td>
                        <td>\${product.productName}</td>
                        <td>\${product.price}</td>
                    </tr>
                `
            )).join("");
        }

        getProductList();

    </script>
</body>
</html>

<?php
$server = "localhost";
$user = "root";
$pass = "";
$database = "test";
$conn = new mysqli($server,$user,$pass,$database);
if($conn->connect_error){
echo "Failed !";
} else
echo "Sucess";
?>
<?php
require 'conn.php';
createuser();
function createuser(){
	global $conn;
	$user = $_POST["user"];
	$pass = $_POST["pass"];
	$query = "Insert into pass(user ,pass) values ($user,$pass) ;";
	mysqli_query($conn,$query) or die(mysqli_error($conn));
	mysqli_close($conn);
	
?>
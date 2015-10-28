<?php
$con = mysql_connect("localhost","root","") or die(mysql_error());
 
        // Selecing database
$db = mysql_select_db("androidhive") or die(mysql_error()) or die(mysql_error());
$username = $_POST['username'];
$password = $_POST['password'];
$query_search = "select * from tbl_user where username = '".$username."' AND password = '".$password. "'";
$query_exec = mysql_query($query_search) or die(mysql_error());
$rows = mysql_num_rows($query_exec);
//echo $rows;
 if($rows == 0) { 
 echo "No Such User Found"; 
 }
 else  {
	echo "User Found"; 
}
?>

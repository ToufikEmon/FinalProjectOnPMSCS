<?php
$con = mysqli_connect("localhost","root","","final_project") or die(mysql_error());
 
        // Selecing database
$db = mysqli_select_db($con,"final_project") or die(mysql_error()) or die(mysql_error());
$mobile_number = $_POST['mobile_number'];
$pin = $_POST['pin'];
$query_search = "select * from payment_clearence where mobile_number = '".$mobile_number."' AND pin = '".$pin. "'";
$query_exec = mysqli_query($con,$query_search) or die(mysql_error());
$rows = mysqli_num_rows($query_exec);
//echo $rows;
 if($rows == 0) { 
 echo "No Such User Found"; 
 }
 else  {
	echo "User Found"; 
}
?>
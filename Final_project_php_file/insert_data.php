<?php
 
/*
 * Following code will create a new product row
 * All product details are read from HTTP Post Request
 */
 
// array for JSON response
$response = array();
 
// check for required fields
if (isset($_POST['applicant_name']) && isset($_POST['father_name']) && isset($_POST['mother_name'])&& isset($_POST['nationality'])&& isset($_POST['permanent_address'])&& isset($_POST['present_address'])&& isset($_POST['contact_number']) && isset($_POST['email'])&& isset($_POST['date_of_birth'])&& isset($_POST['sex'])&& isset($_POST['blood_group'])
&& isset($_POST['degree1']) && isset($_POST['degree2'])&& isset($_POST['degree3'])&& isset($_POST['degree4'])&& isset($_POST['group1'])&& isset($_POST['group2'])
 && isset($_POST['group3'])&& isset($_POST['group4'])&& isset($_POST['board1'])&& isset($_POST['board2'])&& isset($_POST['board3']) && isset($_POST['board4'])
 && isset($_POST['ssc_cgpa'])&& isset($_POST['hsc_cgpa'])&& isset($_POST['hons_cgpa'])&& isset($_POST['others_cgpa']) && isset($_POST['passing_year1'])
 && isset($_POST['passing_year2'])&& isset($_POST['passing_year3'])&& isset($_POST['passing_year4'])&& isset($_POST['organization']) && isset($_POST['status'])) {
 
    
	$applicant_name = $_POST['applicant_name'];
	$father_name = $_POST['father_name'];
	$mother_name = $_POST['mother_name'];
	$nationality = $_POST['nationality'];
	$permanent_address = $_POST['permanent_address'];
	$present_address = $_POST['present_address'];
	$contact_number = $_POST['contact_number'];
	$email = $_POST['email'];
	$date_of_birth = $_POST['date_of_birth'];
	$sex = $_POST['sex'];
	$blood_group = $_POST['blood_group'];
	$degree1 = $_POST['degree1'];
	$degree2 = $_POST['degree2'];
	$degree3 = $_POST['degree3'];
	$degree4 = $_POST['degree4'];
	$group1 = $_POST['group1'];
	$group2 = $_POST['group2'];
	$group3 = $_POST['group3'];
	$group4 = $_POST['group4'];
	$board1 = $_POST['board1'];
	$board2 = $_POST['board2'];
	$board3 = $_POST['board3'];
	$board4 = $_POST['board4'];
	$ssc_cgpa = $_POST['ssc_cgpa'];
	$hsc_cgpa = $_POST['hsc_cgpa'];
	$hons_cgpa = $_POST['hons_cgpa'];
	$others_cgpa = $_POST['others_cgpa'];
	$passing_year1 = $_POST['passing_year1'];
	$passing_year2 = $_POST['passing_year2'];
	$passing_year3 = $_POST['passing_year3'];
	$passing_year4 = $_POST['passing_year4'];
	$organization = $_POST['organization'];
	$status = $_POST['status'];
	
	$image = $_POST["image"];
	
	
	  $ImageName = $applicant_name.".png";
    // Decode Image
    $binary=base64_decode($image);
    header('Content-Type: bitmap; charset=utf-8');
    // Images will be saved under 'www/imgupload/uplodedimages' folder
    $file = fopen('images/'.$ImageName, 'wb');
    // Create File
    fwrite($file, $binary);
    fclose($file);
      
       
       // $filePath = "images/".$ImageName; // path of the file to store
		//echo $filepath;
        //echo "file ".$filePath;
        // check if file exits
        //if (file_exists($filePath)) {
          //  unlink($filePath); // delete the old file
        //} 
       //  create a new empty file
        //$myfile = fopen($filePath, "w") or die("Unable to open file!");
       //  add data to that file
        //file_put_contents($filePath, base64_decode($image));
	
 
    // include db connect class
   // require_once __DIR__ . '/db_connect.php';
 
    // connecting to db
    //$db = new DB_CONNECT();
    $con = mysql_connect("localhost","root","") or die(mysql_error());
 
        // Selecing database
        $db = mysql_select_db("final_project") or die(mysql_error()) or die(mysql_error());
		
		
		
		 $applicant_roll = "1531001";


      $sqlTemp = "select * from `final_project`.`insert_data` ORDER BY applicant_roll DESC";
      $retval  = mysql_query($sqlTemp);

      while($row = mysql_fetch_array(($retval))){
        $applicant_roll = $row['applicant_roll']+1;
        break;
      }
 
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO insert_data(applicant_name,father_name,mother_name,nationality,permanent_address,present_address,contact_number,email,date_of_birth,sex,blood_group,degree1,degree2,degree3,degree4,group1,group2,group3,group4,board1,board2,board3,board4,ssc_cgpa,hsc_cgpa,hons_cgpa,others_cgpa,passing_year1,passing_year2,passing_year3,passing_year4,organization,status,applicant_roll,imageName) 
VALUES('$applicant_name','$father_name','$mother_name','$nationality','$permanent_address','$present_address','$contact_number','$email','$date_of_birth','$sex','$blood_group','$degree1','$degree2','$degree3','$degree4','$group1','$group2','$group3','$group4','$board1','$board2','$board3','$board4','$ssc_cgpa','$hsc_cgpa','$hons_cgpa','$others_cgpa','$passing_year1','$passing_year2','$passing_year3','$passing_year4','$organization','$status','$applicant_roll','$ImageName')");
 
    // check if row inserted or not
    if ($result) {
        // successfully inserted into database
        $response["success"] = 1;
        $response["message"] = "Product successfully created.";
 
        // echoing JSON response
        echo json_encode($response);
    } else {
        // failed to insert row
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred.";
 
        // echoing JSON response
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>
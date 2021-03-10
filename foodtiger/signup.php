<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['Name']) && isset($_POST['Email']) && isset($_POST['PhoneNo']) && isset($_POST['Address']) && isset($_POST['Password'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("customer", $_POST['Name'], $_POST['Email'], $_POST['PhoneNo'], $_POST['Address'], $_POST['Password'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>

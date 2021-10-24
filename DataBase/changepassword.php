<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['password'])&& isset($_POST['email'])) {
    if ($db->dbConnect()) {
        if ($db->changepassword("users", $_POST['password'], $_POST['email'])) {
            echo "Password actualizada";
        } else echo "Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";



?>

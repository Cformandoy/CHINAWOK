<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['email'])&& isset($_POST['username'])) {
    if ($db->dbConnect()) {
        if ($db->forgotpassword("users", $_POST['email'], $_POST['username'])) {
            echo "Usuario verificado";
        } else echo "Usuario no encontrado verifique Email";
    } else echo "Error: Database connection";
} else echo "All fields are required"; 

?>
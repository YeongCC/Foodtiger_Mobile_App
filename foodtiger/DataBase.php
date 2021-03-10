<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $Email, $Password)
    {
        $Email = $this->prepareData($Email);
        $Password = $this->prepareData($Password);
        $this->sql = "select * from " . $table . " where Email = '" . $Email . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbEmail = $row['Email'];
            $dbPassword = $row['Password'];
            if ($dbEmail == $Email && password_verify($Password, $dbPassword)) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function signUp($table, $Name, $Email, $PhoneNo,$Address ,$Password)
    {
        $Name = $this->prepareData($Name);
        $Email = $this->prepareData($Email);
        $PhoneNo = $this->prepareData($PhoneNo);
        $Address = $this->prepareData($Address);
        $Password = $this->prepareData($Password);
        $Password = password_hash($Password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $table . " (Name, Email,PhoneNo ,Address, Password) VALUES ('" . $Name . "','" . $Email . "','" . $PhoneNo . "','" . $Address . "','" . $Password . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

}

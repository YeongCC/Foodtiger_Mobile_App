<?php
require "DataBase.php";
$data = new DataBase();
$sql = "Select name,imageUrl,description,c_id from category";
$result = $data->dbConnect()->prepare($sql);
$result ->execute();
$result -> bind_result($nameFood,$imageUrl,$description,$c_id);
$category = array();
while($result ->fetch()){
$temp = array();
$temp['name']= $nameFood;
$temp['imageUrl']= $imageUrl;
$temp["description"]=$description;
$temp["c_id"]=$c_id;
array_push($category,$temp);
}
  echo json_encode($category);
?>


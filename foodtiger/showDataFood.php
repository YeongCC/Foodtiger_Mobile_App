<?php
require "DataBase.php";
$data = new DataBase();
$sql = "Select nameFood,imageUrl,rate,description,f_id,cart_id,price from food";
$result = $data->dbConnect()->prepare($sql);
$result ->execute();
$result -> bind_result($nameFood,$imageUrl,$rate,$description,$f_id,$cart_id,$price);
$foods = array();
while($result ->fetch()){
$temp = array();
$temp['nameFood']= $nameFood;
$temp['imageUrl']= $imageUrl;
$temp['rate']=$rate;
$temp["description"]=$description;
$temp["f_id"]=$f_id;
$temp["cart_id"]=$cart_id;
$temp["price"]=$price;
array_push($foods,$temp);
}
  echo json_encode($foods);
?>


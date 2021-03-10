-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2021-03-10 22:13:48
-- 服务器版本： 10.4.8-MariaDB
-- PHP 版本： 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `foodtiger`
--

-- --------------------------------------------------------

--
-- 表的结构 `food`
--

CREATE TABLE `food` (
  `f_id` int(11) NOT NULL,
  `cart_id` int(10) NOT NULL,
  `nameFood` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `imageFood` varchar(500) NOT NULL,
  `price` int(30) NOT NULL,
  `imageUrl` varchar(500) NOT NULL,
  `rate` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `food`
--

INSERT INTO `food` (`f_id`, `cart_id`, `nameFood`, `description`, `imageFood`, `price`, `imageUrl`, `rate`) VALUES
(5, 2, 'Char kway teowv', 'Char kway teow  is a popular noodle dish from Maritime Southeast Asia, notably in Indonesia, Malaysia, Singapore, and Brunei. In Hokkien, Char means â€œstir-friedâ€ and kway teow refers to flat rice noodles. The dish is considered a national favourite in', '../../image/food/char kway teow.jpg', 20, 'http://192.168.0.137/php/project2-master/image/food/char%20kway%20teow.jpg', 5),
(6, 2, 'Bak kut teh', 'Bak kut teh is a pork rib dish cooked in broth popularly served in Malaysia and Singapore where there is a predominant Hoklo and Teochew community, and also in neighbouring areas like Indonesia in Riau Islands and Southern Thailand.', '../../image/food/Bak Kut Teh.jpg', 8, 'http://192.168.0.137/php/project2-master/image/food/Bak%20Kut%20Teh.jpg', 4.9),
(8, 3, 'Pizza', 'Pizza is a savory dish of Italian origin consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients', '../../image/food/pizza.jpg', 12, 'http://192.168.0.137/php/project2-master/image/food/pizza.jpg', 4.5),
(9, 3, 'Burger', 'Burger is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled. ... A hamburger topped with cheese is called a cheeseburger', '../../image/food/burger.jpg', 8, 'http://192.168.0.137/php/project2-master/image/food/burger.jpg', 3.8),
(10, 3, 'Beef', 'Beef, flesh of mature cattle, as distinguished from veal, the flesh of calves. The best beef is obtained from early maturing, special beef breeds. High-quality beef has firm, velvety, fine-grained lean, bright red in colour and well-marbled. The fat is sm', '../../image/food/beef.jpg', 15, 'http://192.168.0.137/php/project2-master/image/food/beef.jpg', 4.5),
(11, 4, 'Roti Canai', 'Roti canai is made from dough which is usually composed of fat (usually ghee), flour and water; some recipes also include sweetened condensed milk. The dough is repeatedly kneaded, flattened, oiled, and folded before proofing, creating layers.', '../../image/food/roti canai.jpeg', 3, 'http://192.168.0.137/php/project2-master/image/food/roti%20canai.jpeg', 4.5),
(12, 4, 'Dosa', 'A dosa is a rice pancake, originating from South India, made from a fermented batter. It is somewhat similar to a crepe in appearance. Its main ingredients are rice and black gram, ground together in a fine, smooth batter with a dash of salt.', '../../image/food/tosei.jpg', 2, 'http://192.168.0.137/php/project2-master/image/food/tosei.jpg', 3.8),
(14, 4, 'Maggi goreng', 'Maggi goreng is a style of cooking instant noodles, in particular the Maggi product range, which is common in Malaysia. It is commonly served at Indian Muslim (or Mamak) food stalls in Malaysia and Singapore.', '../../image/food/maggi goreng.jpg', 6, 'http://192.168.0.137/php/project2-master/image/food/maggi%20goreng.jpg', 5),
(17, 5, 'Kimchi', 'Kimchi is Korean terminology for fermented vegetables, and encompasses salt and seasoned vegetables. Kimchi is a traditional Korean dish consisting of pickled vegetables, which is mainly served as a side dish with every meal, but also can be served as a m', '../../image/food/Kimchi.jpg', 8, 'http://192.168.0.137/php/project2-master/image/food/Kimchi.jpg', 1),
(18, 5, 'Bibimbap ', 'Bibimbap sometimes romanized as bi bim bap or bi bim bop, is a Korean rice dish. The term  sometimes romanized as bi bim bap or bi bim bop, is a Korean rice dish.', '../../image/food/bibimbap.jpg', 10, 'http://192.168.0.137/php/project2-master/image/food/bibimbap.jpg', 2.3),
(19, 5, 'Japchae', 'Japchae is a sweet and savory dish of stir-fried glass noodles and vegetables that is popular in Korean cuisine.Japchae is typically prepared with dangmyeon (ë‹¹ë©´, å”éºµ), a type of cellophane noodles made from sweet potato starch; the noodles are topp', '../../image/food/Japchae.jpg', 13, 'http://192.168.0.137/php/project2-master/image/food/Japchae.jpg', 5),
(21, 7, 'Nasi Lemak', 'Nasi lemak is a dish that comprises rice made fragrant with coconut cream and pandan leaves. A light meal that is believed to be Malay in origin, it is traditionally accompanied by fried anchovies, sliced cucumbers, fried fish known as ikan selar, and a s', '../../image/food/malay food.jpg', 4, 'http://192.168.0.137/php/project2-master/image/food/malay%20food.jpg', 4.5),
(22, 11, 'Tom Yum', 'Tom yum is characterised by its distinct hot and sour flavours, with fragrant spices and herbs generously used in the broth. The soup is also made with fresh ingredients such as lemongrass, kaffir lime leaves, galangal, lime juice, fish sauce, and crushed', '../../image/food/tomyam.jpg', 10, 'http://192.168.0.137/php/project2-master/image/food/tomyam.jpg', 5),
(25, 2, 'Mala XiangGuo', 'Spicy', '../../image/food/mala.jpeg', 25, 'http://192.168.0.137/php/project2-master/image/food/mala.jpeg', 3.8);

--
-- 转储表的索引
--

--
-- 表的索引 `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`f_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `food`
--
ALTER TABLE `food`
  MODIFY `f_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

CREATE TABLE IF NOT EXISTS `categories` (
    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100)
    -- `parent_category_id` INTEGER,

    -- FOREIGN KEY (parent_category_id) REFERENCES categories (id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `products` (
    `id`  INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `price` DOUBLE NOT NULL,
    `description` VARCHAR(100),
    `full_description` TEXT,
    `image` VARCHAR(255) NOT NULL,
    `novelty` BIT NOT NULL,
    `category_id` INTEGER,

    FOREIGN KEY (category_id) REFERENCES categories (id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `users` (
    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `roles` (
    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `user_roles` (
    `user_id` INTEGER NOT NULL,
    `role_id` INTEGER NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `order_statuses` (
    `id` INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

/* Если статус "NEW", то товары добавляются к этому заказу.
	Если польователь нажал "Оплатить заказ" и успешно его оплатил, то статус меняется на "PAID" - пользователю показывается
	надпись: "Ожидается подтверждение платежа". После часа ожидания статус автоматически меняется на "SHIPPED" и остается (Можно стразу станавливать статус в значение "SHIPPED")
	таким до тех пор, пока товар не прибудет в страну назначения. По прибытии в страну назначения статус заказа меняется
	на "DELIVERED". Если пользователь подтверждает получение заказа, то статус меняется на "CLOSED".
*/
CREATE TABLE IF NOT EXISTS `orders` (
    `id` INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` INTEGER(11) NOT NULL,
    `status_id` INTEGER(11) DEFAULT 1,
    `total` DOUBLE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (status_id) REFERENCES order_statuses (id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `order_items` (
    `id` INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `product_id` INTEGER(11) NOT NULL,
    `order_id` INTEGER(11) NOT NULL,
    `quantity` INTEGER(11) NOT NULL,
    `price` DOUBLE NOT NULL,

    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (order_id) REFERENCES orders (id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `wishes` (
    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` INTEGER NOT NULL,
    `product_id` INTEGER NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `shipments_information` (
  `id` INTEGER(11) NOT NULL,
  `order_id` INTEGER(11) NOT NULL,
  `country` VARCHAR(255) NOT NULL,
  `phone_number` VARCHAR(255) NOT NULL,
  `address_line_1` VARCHAR(255) NOT NULL,
  `address_line_2` VARCHAR(255) DEFAULT NULL,
  `zip` VARCHAR(255) NOT NULL,
  `shipment_tracking_number` VARCHAR(255) NOT NULL,
  `shipment_placed_date` DATETIME NOT NULL,

  FOREIGN KEY (order_id) REFERENCES orders (id)
)
    ENGINE = INNODB
    DEFAULT CHARACTER SET utf8;
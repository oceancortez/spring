CREATE TABLE `wproject`.`category_product` (
  `ProductID` INT(11) NOT NULL,
  `CategoryID` INT(11) NOT NULL,
  INDEX `fk_category_product_2_idx` (`CategoryID` ASC),
  INDEX `fk_category_product_products_idx` (`ProductID` ASC),
  CONSTRAINT `fk_category_product_products`
    FOREIGN KEY (`ProductID`)
    REFERENCES `wproject`.`Products` (`ProductID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_product_categories`
    FOREIGN KEY (`CategoryID`)
    REFERENCES `wproject`.`Categories` (`CategoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
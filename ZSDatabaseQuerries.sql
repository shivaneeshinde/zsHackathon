CREATE TABLE PRODUCT
   ( PRODUCT_ID SERIAL NOT NULL,
     PRODUCT_NAME varchar(600),
     IMAGE_URL varchar(600)  ,
     DETAILS varchar(600) ,
     PRICE  varchar(600),
    PRIMARY KEY (PRODUCT_ID)
    );
    
select * from PRODUCT;
    
INSERT INTO PRODUCT (PRODUCT_NAME, IMAGE_URL, DETAILS, PRICE) VALUES ('coffe', 'https://5.imimg.com/data5/SELLER/Default/2021/7/YI/CP/WI/19591746/nestle-nescafe-classic-1-5grmas-sachet-pack-of-64-500x500.png', 'Nescafe', '150');

INSERT INTO PRODUCT (PRODUCT_NAME, IMAGE_URL, DETAILS, PRICE) VALUES ('tea', 'https://www.bigbasket.com/media/uploads/p/l/266575_16-red-label-tea.jpg', 'Red Lebel', '100');
INSERT INTO PRODUCT (PRODUCT_NAME, IMAGE_URL, DETAILS, PRICE) VALUES ('aaple', 'https://images.everydayhealth.com/images/apples-101-about-1440x810.jpg?sfvrsn=f86f2644_1', 'Apples', '150');
INSERT INTO PRODUCT (PRODUCT_NAME, IMAGE_URL, DETAILS, PRICE) VALUES ('cookies', 'https://bakerpedia.com/wp-content/uploads/2017/07/48714766_m-e1501018129557.jpg', 'Cookies', '150');
INSERT INTO PRODUCT (PRODUCT_NAME, IMAGE_URL, DETAILS, PRICE) VALUES ('maggie', 'https://assets-news-bcdn.dailyhunt.in/cmd/resize/400x400_80/fetchdata16/images/e8/01/1d/e8011d667776de8f4b876157012671df21d05b1d801945e460db135fc9dcd5a6.jpg', 'Maggie', '150');
INSERT INTO PRODUCT (PRODUCT_NAME, IMAGE_URL, DETAILS, PRICE) VALUES ('pasta', 'https://m.media-amazon.com/images/I/81MFVshMr6L._SL1500_.jpg', 'Pasta', '150');
INSERT INTO PRODUCT (PRODUCT_NAME, IMAGE_URL, DETAILS, PRICE) VALUES ('tomato', 'https://m.media-amazon.com/images/I/71DYmqoq-VL._SL1024_.jpg', 'Tomato', '150');





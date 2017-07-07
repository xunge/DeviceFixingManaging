CREATE TABLE staff (
    staff_no INT(6) AUTO_INCREMENT,
    staff_name VARCHAR(20) NOT NULL,
    staff_password VARCHAR(12) NOT NULL,
    staff_character VARCHAR(20) NOT NULL,
    CONSTRAINT pk_staff_no PRIMARY KEY (staff_no),
    CONSTRAINT uq_staff_name UNIQUE KEY (staff_name),
    CONSTRAINT ck_staff_character CHECK (staff_character IN ('客服' , '任务调度',
        '技术工程师',
        '库管',
        '运营监督',
        '财务',
        'Timer'))
);

insert into staff values (1, 'kefu1', '5555', '客服');
insert into part_detail values(2, 0, 3);

CREATE TABLE customer (
    customer_idno VARCHAR(18),
    customer_visittime DATE,
    customer_character VARCHAR(20),
    customer_companyname VARCHAR(20),
    customer_housephone VARCHAR(11),
    customer_mobilephone VARCHAR(11) NOT NULL,
    customer_address VARCHAR(50) NOT NULL,
    customer_postcode VARCHAR(6),
    customer_linkman VARCHAR(20) NOT NULL,
    customer_email VARCHAR(30),
    CONSTRAINT customerr_idno PRIMARY KEY (customer_idno),
    CONSTRAINT ck_customer_character CHECK (customer_character IN ('家庭用户' , '单位用户',
        '代理商',
        '签约用户')),
    CONSTRAINT customer_mobilephone UNIQUE (customer_mobilephone)
);

CREATE TABLE report_record (
    report_record_no INT(6) AUTO_INCREMENT,
    customer_idno VARCHAR(18),
    report_equip_no INT(20),
    report_time DATE,
    predict_price INT(10),
    predict_complete_time DATE,
    report_status VARCHAR(20),
    CONSTRAINT pk_report_record_no PRIMARY KEY (report_record_no),
    CONSTRAINT ck_report_statement CHECK (report_status IN ('进行中' , '结束', '撤销')),
    CONSTRAINT fk_customer_idno FOREIGN KEY (customer_idno)
        REFERENCES customer (customer_idno),
    CONSTRAINT fk_report_equip_no FOREIGN KEY (report_equip_no)
        REFERENCES report_equipment (report_equip_no)
);

CREATE TABLE report_equipment (
    report_equip_no INT(20) AUTO_INCREMENT,
    product_type VARCHAR(20),
    report_equip_brand VARCHAR(20),
    report_equip_model VARCHAR(20),
    report_equip_series VARCHAR(20),
    report_equip_absent VARCHAR(20),
    report_equip_problem VARCHAR(50) NOT NULL,
    report_equip_problem_type VARCHAR(20) NOT NULL,
    report_equip_appearance VARCHAR(20),
    report_equip_password VARCHAR(20),
    report_equip_data VARCHAR(20),
    report_equip_hdd VARCHAR(20),
    report_equip_memory VARCHAR(20),
    report_equip_pc VARCHAR(20),
    report_equip_ac VARCHAR(20),
    report_equip_battery VARCHAR(20),
    report_equip_cd VARCHAR(20),
    CONSTRAINT pk_report_equip_no PRIMARY KEY (report_equip_no),
    CONSTRAINT ck_product_type CHECK (product_type IN ('台式机' , '笔记本',
        '投影仪',
        '打印机',
        '其他')),
    CONSTRAINT ck_report_equip_problem_type CHECK (report_equip_problem_type IN ('固定性故障' , '间隙性故障'))
);

CREATE TABLE repair_record (
    repair_record_no INT(6) AUTO_INCREMENT,
    report_record_no INT(6),
    repair_person_no INT(6),
    repair_time DATE,
    test_record VARCHAR(50),
    repair_record VARCHAR(50),
    repair_test_time DATE,
    work_amount VARCHAR(50),
    person_price DOUBLE(10 , 2 ),
    material_price DOUBLE(10 , 2 ),
    repair_promise VARCHAR(50),
    attention VARCHAR(50),
    repair_status VARCHAR(30),
    repair_delay VARCHAR(30),
    CONSTRAINT pk_repair_record_no PRIMARY KEY (repair_record_no),
    CONSTRAINT fk_repair_person_no FOREIGN KEY (repair_person_no)
        REFERENCES staff (staff_no),
    CONSTRAINT fk_report_record_no FOREIGN KEY (report_record_no)
        REFERENCES report_record (report_record_no),
    CONSTRAINT ck_repair_status CHECK (repair_status IN ('未分配' , '已分配', '已维修', '撤销')),
    CONSTRAINT ck_repair_delay CHECK (repair_delay IN ('一般' , '比较严重', '严重'))
);

CREATE TABLE part (
    part_no INT(20) AUTO_INCREMENT,
    part_name VARCHAR(20) NOT NULL,
    part_size VARCHAR(20),
    part_price DOUBLE(10 , 2 ) NOT NULL,
    part_num INT(10) NOT NULL,
    part_warn_num INT(10) NOT NULL,
    part_status VARCHAR(20),
    CONSTRAINT pk_part_no PRIMARY KEY (part_no),
    CONSTRAINT ck_part_status CHECK (part_status IN ('正常' , '警戒', '警示', '缺货'))
);

CREATE TABLE part_detail (
    part_detail_no INT(20) AUTO_INCREMENT,
    repair_record_no INT(6),
    part_no INT(20),
    part_detail_num INT(20) NOT NULL,
    part_detail_status VARCHAR(20) NOT NULL,
    CONSTRAINT pk_part_detail_no PRIMARY KEY (part_detail_no),
    CONSTRAINT fk_part_no FOREIGN KEY (part_no)
        REFERENCES part (part_no),
    CONSTRAINT fk_repair_record_no FOREIGN KEY (repair_record_no)
        REFERENCES repair_record (repair_record_no),
    CONSTRAINT ck_part_detail_status CHECK (part_detail_status IN ('未出库' , '已出库', '未入库', '已入库'))
);

CREATE TABLE price (
    price_no INT(6) AUTO_INCREMENT,
    price_time DATE,
    price DOUBLE(10 , 2 ),
    CONSTRAINT pk_price_no PRIMARY KEY (price_no)
);

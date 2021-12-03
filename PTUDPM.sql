create database ptpmud;
use ptpmud;

create table TaiSan (
	MaTS varchar(30) NOT NULL PRIMARY KEY,
    TenTS varchar(50) NOT NULL,
    LoaiTS varchar(50) NOT NULL,
    TinhTrang varchar(30) NOT NULL,
    SoLuong int
    );
    
CREATE TABLE NguoiMuon (
	TenTK varchar(30) NOT NULL PRIMARY KEY,
    MK varchar(30) NOT NULL,
    Email varchar(30) NOT NULL,
    SDT varchar(30) NOT NULL,
    ChucVu varchar(30)
    );
    
CREATE TABLE ThuHoi (
	MaTH int NOT NULL AUTO_INCREMENT,
    NgayTH date,
    PRIMARY KEY (MaTH),
    MaTS varchar(30),
    CONSTRAINT FK_TaiSan FOREIGN KEY (MaTS)
    REFERENCES TaiSan(MaTS),
    TenTK varchar(30),
    CONSTRAINT FK_TK FOREIGN KEY (TenTK)
    REFERENCES NguoiMuon(TenTK)
    );
    
CREATE TABLE BanGiao (
	MaBG int NOT NULL AUTO_INCREMENT,
    NgayBG date,
    PRIMARY KEY (MaBG),
    MaTS varchar(30),
    CONSTRAINT FK_TaiSan1 FOREIGN KEY (MaTS)
    REFERENCES TaiSan(MaTS),
    TenTK varchar(30),
    CONSTRAINT FK_TK1 FOREIGN KEY (TenTK)
    REFERENCES NguoiMuon(TenTK)
    );
 insert into TaiSan values ("MT1","May Tinh","TB Dien Tu","Moi",20);
 insert into TaiSan values ("SGK1","Toan 10","Sach","Moi",50);
 insert into TaiSan values ("SGK2","Ngu Van 10","Sach","Moi",50);
 insert into TaiSan values ("SGK3","Vat Ly 10","Sach","Moi",50);
 insert into TaiSan values ("MC1","May Chieu","TB Dien Tu","Moi",20);
 
 insert into NguoiMuon values ("ToanDV","ToanDV","toandv@gmail.com","0338761232","Giao Vien");
 insert into NguoiMuon values ("HuyLQ","HuyLQ","huylq@gmail.com","0338761233","Giao Vien");
 insert into NguoiMuon values ("HoangNM","HoangNM","hoangnm@gmail.com","0338761238","Giao Vien");
 
 
 



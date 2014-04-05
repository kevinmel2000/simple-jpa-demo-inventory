SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO `daftarbarang` (`DTYPE`, `id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `faktur_id`, `gudang_id`, `supplier_id`) VALUES ('PenerimaanBarang',-7,'2014-02-22 07:00:00','N',NULL,NULL,'P7','2014-03-04',-5,-1,-3);
INSERT INTO `daftarbarang` (`DTYPE`, `id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `faktur_id`, `gudang_id`, `supplier_id`) VALUES ('PenerimaanBarang',-6,'2014-02-22 07:00:00','N',NULL,NULL,'P6','2014-03-04',-4,-1,-3);
INSERT INTO `daftarbarang` (`DTYPE`, `id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `faktur_id`, `gudang_id`, `supplier_id`) VALUES ('PenerimaanBarang',-5,'2014-02-22 07:00:00','N',NULL,NULL,'P5','2014-03-04',NULL,-1,-2);
INSERT INTO `daftarbarang` (`DTYPE`, `id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `faktur_id`, `gudang_id`, `supplier_id`) VALUES ('PenerimaanBarang',-4,'2014-02-22 07:00:00','N',NULL,NULL,'P4','2014-03-03',-3,-1,-2);
INSERT INTO `daftarbarang` (`DTYPE`, `id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `faktur_id`, `gudang_id`, `supplier_id`) VALUES ('PenerimaanBarang',-3,'2014-02-22 07:00:00','N',NULL,NULL,'P3','2014-03-15',NULL,-1,-1);
INSERT INTO `daftarbarang` (`DTYPE`, `id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `faktur_id`, `gudang_id`, `supplier_id`) VALUES ('PenerimaanBarang',-2,'2014-02-22 07:00:00','N',NULL,NULL,'P2','2014-03-14',NULL,-1,-1);
INSERT INTO `daftarbarang` (`DTYPE`, `id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `faktur_id`, `gudang_id`, `supplier_id`) VALUES ('PenerimaanBarang',-1,'2014-02-22 07:00:00','N',NULL,NULL,'P1','2014-03-13',NULL,-1,-1);
INSERT INTO `daftarbarang_listitembarang` (`DaftarBarang_id`, `jumlah`, `produk_id`, `listItemBarang_ORDER`) VALUES (-7,2,-1,0);
INSERT INTO `daftarbarang_listitembarang` (`DaftarBarang_id`, `jumlah`, `produk_id`, `listItemBarang_ORDER`) VALUES (-6,1,-3,0);
INSERT INTO `daftarbarang_listitembarang` (`DaftarBarang_id`, `jumlah`, `produk_id`, `listItemBarang_ORDER`) VALUES (-6,2,-1,1);
INSERT INTO `daftarbarang_listitembarang` (`DaftarBarang_id`, `jumlah`, `produk_id`, `listItemBarang_ORDER`) VALUES (-5,1,-2,0);
INSERT INTO `daftarbarang_listitembarang` (`DaftarBarang_id`, `jumlah`, `produk_id`, `listItemBarang_ORDER`) VALUES (-4,2,-2,0);
INSERT INTO `daftarbarang_listitembarang` (`DaftarBarang_id`, `jumlah`, `produk_id`, `listItemBarang_ORDER`) VALUES (-3,4,-3,0);
INSERT INTO `daftarbarang_listitembarang` (`DaftarBarang_id`, `jumlah`, `produk_id`, `listItemBarang_ORDER`) VALUES (-2,3,-2,0);
INSERT INTO `daftarbarang_listitembarang` (`DaftarBarang_id`, `jumlah`, `produk_id`, `listItemBarang_ORDER`) VALUES (-1,5,-1,0);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-7,NULL,NULL,1800.00,1,NULL,-1,0);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-6,NULL,NULL,1700.00,1,NULL,-1,0);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-5,NULL,NULL,1000.00,2,NULL,-1,0);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-4,NULL,NULL,2000.00,1,NULL,-3,0);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-4,NULL,NULL,1900.00,2,NULL,-1,1);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-3,NULL,NULL,1400.00,3,NULL,-2,0);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-2,NULL,4.00,1500.00,2,NULL,-1,0);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-1,100.00,1.00,1000.00,5,NULL,-1,0);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-1,NULL,2.00,2000.00,3,NULL,-2,1);
INSERT INTO `faktur_listitemfaktur` (`Faktur_id`, `potonganLangsung`, `potonganPersen`, `harga`, `jumlah`, `keterangan`, `produk_id`, `listItemFaktur_ORDER`) VALUES (-1,NULL,3.00,3000.00,4,NULL,-3,2);
INSERT INTO `fakturbeli` (`id`, `createdDate`, `deleted`, `potonganLangsung`, `potonganPersen`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `status`, `hutang_id`, `supplier_id`) VALUES (-7,'2014-02-22 07:00:00','N',NULL,NULL,NULL,NULL,'FA7','2014-03-05',1,NULL,-2);
INSERT INTO `fakturbeli` (`id`, `createdDate`, `deleted`, `potonganLangsung`, `potonganPersen`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `status`, `hutang_id`, `supplier_id`) VALUES (-6,'2014-02-22 07:00:00','N',NULL,NULL,NULL,NULL,'FA6','2014-03-05',0,NULL,-2);
INSERT INTO `fakturbeli` (`id`, `createdDate`, `deleted`, `potonganLangsung`, `potonganPersen`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `status`, `hutang_id`, `supplier_id`) VALUES (-5,'2014-02-22 07:00:00','N',NULL,NULL,NULL,NULL,'FA5','2014-03-04',2,-2,-3);
INSERT INTO `fakturbeli` (`id`, `createdDate`, `deleted`, `potonganLangsung`, `potonganPersen`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `status`, `hutang_id`, `supplier_id`) VALUES (-4,'2014-02-22 07:00:00','N',NULL,NULL,NULL,NULL,'FA4','2014-03-04',1,-1,-3);
INSERT INTO `fakturbeli` (`id`, `createdDate`, `deleted`, `potonganLangsung`, `potonganPersen`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `status`, `hutang_id`, `supplier_id`) VALUES (-3,'2014-02-22 07:00:00','N',NULL,NULL,NULL,NULL,'FA3','2014-03-03',0,NULL,-2);
INSERT INTO `fakturbeli` (`id`, `createdDate`, `deleted`, `potonganLangsung`, `potonganPersen`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `status`, `hutang_id`, `supplier_id`) VALUES (-2,'2014-02-22 07:00:00','N',100.00,2.00,NULL,NULL,'FA2','2014-03-02',1,NULL,-1);
INSERT INTO `fakturbeli` (`id`, `createdDate`, `deleted`, `potonganLangsung`, `potonganPersen`, `keterangan`, `modifiedDate`, `nomor`, `tanggal`, `status`, `hutang_id`, `supplier_id`) VALUES (-1,'2014-02-22 07:00:00','N',NULL,1.00,NULL,NULL,'FA1','2014-03-01',0,NULL,-1);
INSERT INTO `gudang` (`id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nama`, `utama`) VALUES (-7,'2014-02-22 07:00:00','N',NULL,NULL,'Warehouse F','\0');
INSERT INTO `gudang` (`id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nama`, `utama`) VALUES (-6,'2014-02-22 07:00:00','N',NULL,NULL,'Warehouse E','\0');
INSERT INTO `gudang` (`id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nama`, `utama`) VALUES (-5,'2014-02-22 07:00:00','N',NULL,NULL,'Warehouse D','\0');
INSERT INTO `gudang` (`id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nama`, `utama`) VALUES (-4,'2014-02-22 07:00:00','N',NULL,NULL,'Warehouse C','\0');
INSERT INTO `gudang` (`id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nama`, `utama`) VALUES (-3,'2014-02-22 07:00:00','N',NULL,NULL,'Warehouse B','\0');
INSERT INTO `gudang` (`id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nama`, `utama`) VALUES (-2,'2014-02-22 07:00:00','N',NULL,NULL,'Warehouse A','\0');
INSERT INTO `gudang` (`id`, `createdDate`, `deleted`, `keterangan`, `modifiedDate`, `nama`, `utama`) VALUES (-1,'2014-02-22 07:00:00','N',NULL,NULL,'Gudang','');
INSERT INTO `hutang` (`id`, `createdDate`, `deleted`, `jatuhTempo`, `jumlah`, `lunas`, `modifiedDate`) VALUES (-2,'2014-02-22 07:00:00','N','2014-04-04',2000.00,'',NULL);
INSERT INTO `hutang` (`id`, `createdDate`, `deleted`, `jatuhTempo`, `jumlah`, `lunas`, `modifiedDate`) VALUES (-1,'2014-02-22 07:00:00','N','2014-04-04',5800.00,'\0',NULL);
INSERT INTO `hutang_listpembayaran` (`Hutang_id`, `jumlah`, `tanggal`, `listPembayaran_ORDER`) VALUES (-2,2000.00,'2014-04-03',0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-21,'\0',7,'2013-03-01','2013-03-31','2014-03-20 07:00:00','N',NULL,-11,1);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-20,'\0',10,'2013-03-01','2013-03-31','2014-03-20 07:00:00','N',NULL,-8,2);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-19,'\0',5,'2013-03-01','2013-03-31','2014-03-20 07:00:00','N',NULL,-1,2);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-18,'\0',10,'2010-01-01','2010-01-31','2014-02-22 07:00:00','N',NULL,-14,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-17,'\0',4,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-13,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-16,'\0',9,'2014-02-01','2014-02-28','2014-02-22 07:00:00','N',NULL,-12,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-15,'\0',8,'2014-02-01','2014-02-28','2014-02-22 07:00:00','N',NULL,-11,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-14,'\0',7,'2014-02-01','2014-02-28','2014-02-22 07:00:00','N',NULL,-10,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-13,'\0',1,'2014-02-01','2014-02-28','2014-02-22 07:00:00','N',NULL,-9,1);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-12,'\0',5,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-9,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-11,'\0',2,'2014-02-01','2014-02-28','2014-02-22 07:00:00','N',NULL,-8,1);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-10,'\0',2,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-8,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-9,'\0',3,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-7,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-8,'\0',2,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-6,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-7,'\0',3,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-5,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-6,'\0',5,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-4,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-5,'\0',10,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-3,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-4,'\0',2,'2014-02-01','2014-02-28','2014-02-22 07:00:00','N',NULL,-2,1);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-3,'\0',2,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-2,0);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-2,'\0',2,'2014-01-01','2014-01-31','2014-02-22 07:00:00','N',NULL,-1,1);
INSERT INTO `periodeitemstok` (`id`, `arsip`, `jumlah`, `tanggalMulai`, `tanggalSelesai`, `createdDate`, `deleted`, `modifiedDate`, `riwayat_id`, `listPeriodeRiwayat_ORDER`) VALUES (-1,'\0',3,'2013-12-01','2013-12-31','2014-02-22 07:00:00','N',NULL,-1,0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-18,NULL,3,NULL,'2010-01-01',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-18,NULL,5,NULL,'2010-01-10',1);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-18,NULL,2,NULL,'2010-01-20',2);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-17,NULL,4,NULL,'2014-01-07',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-16,NULL,9,NULL,'2014-02-22',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-15,NULL,8,NULL,'2014-02-15',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-14,NULL,7,NULL,'2014-02-15',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-13,NULL,1,NULL,'2014-02-02',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-12,NULL,3,NULL,'2014-01-01',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-12,NULL,2,NULL,'2014-01-30',1);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-11,NULL,2,NULL,'2014-02-02',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-10,NULL,2,NULL,'2014-01-01',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-9,NULL,3,NULL,'2014-01-15',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-8,NULL,2,NULL,'2014-01-15',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-7,NULL,3,NULL,'2014-01-15',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-6,NULL,3,NULL,'2014-01-10',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-6,NULL,2,NULL,'2014-01-12',1);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-5,NULL,10,NULL,'2014-01-15',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-4,NULL,2,NULL,'2014-02-08',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-3,NULL,2,NULL,'2014-01-10',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-2,NULL,2,NULL,'2014-01-15',0);
INSERT INTO `periodeitemstok_listitem` (`PeriodeItemStok_id`, `daftarBarang_id`, `jumlah`, `keterangan`, `tanggalItemStok`, `listItem_ORDER`) VALUES (-1,NULL,3,NULL,'2013-12-20',0);
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-11,'2014-02-22 07:00:00','N',100.00,10,0,NULL,'Produk Z');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-10,'2014-02-22 07:00:00','N',1400.00,0,0,NULL,'Produk J');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-9,'2014-02-22 07:00:00','N',300.00,0,0,NULL,'Produk I');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-8,'2014-02-22 07:00:00','N',400.00,0,0,NULL,'Produk H');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-7,'2014-02-22 07:00:00','N',100.00,0,0,NULL,'Produk G');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-6,'2014-02-22 07:00:00','N',800.00,0,0,NULL,'Produk F');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-5,'2014-02-22 07:00:00','N',500.00,0,0,NULL,'Produk E');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-4,'2014-02-22 07:00:00','N',13000.00,0,0,NULL,'Produk D');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-3,'2014-02-22 07:00:00','N',900.00,28,0,NULL,'Produk C');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-2,'2014-02-22 07:00:00','N',1500.00,27,0,NULL,'Produk B');
INSERT INTO `produk` (`id`, `createdDate`, `deleted`, `harga`, `jumlah`, `jumlahAkanDikirim`, `modifiedDate`, `nama`) VALUES (-1,'2014-02-22 07:00:00','N',1000.00,37,0,NULL,'Produk A');
INSERT INTO `region` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`) VALUES (-5,'2014-02-22 07:00:00','N',NULL,'Region E');
INSERT INTO `region` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`) VALUES (-4,'2014-02-22 07:00:00','N',NULL,'Region D');
INSERT INTO `region` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`) VALUES (-3,'2014-02-22 07:00:00','N',NULL,'Region C');
INSERT INTO `region` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`) VALUES (-2,'2014-02-22 07:00:00','N',NULL,'Region B');
INSERT INTO `region` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`) VALUES (-1,'2014-02-22 07:00:00','N',NULL,'Region A');
INSERT INTO `sales` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`, `gudang_id`) VALUES (-7,'2014-02-22 07:00:00','N',NULL,'Sales Luar Kota D',NULL,-5);
INSERT INTO `sales` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`, `gudang_id`) VALUES (-6,'2014-02-22 07:00:00','N',NULL,'Sales Luar Kota C',NULL,-4);
INSERT INTO `sales` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`, `gudang_id`) VALUES (-5,'2014-02-22 07:00:00','N',NULL,'Sales Luar Kota B',NULL,-3);
INSERT INTO `sales` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`, `gudang_id`) VALUES (-4,'2014-02-22 07:00:00','N',NULL,'Sales Luar Kota A',NULL,-2);
INSERT INTO `sales` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`, `gudang_id`) VALUES (-3,'2014-02-22 07:00:00','N',NULL,'Sales Dalam Kota B',NULL,-1);
INSERT INTO `sales` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`, `gudang_id`) VALUES (-2,'2014-02-22 07:00:00','N',NULL,'Sales Dalam Kota A',NULL,-1);
INSERT INTO `sales` (`id`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`, `gudang_id`) VALUES (-1,'2014-02-22 07:00:00','N',NULL,'Sales Showroom','021-xxx-yyy',-1);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-14,10,'2014-02-22 07:00:00','N',NULL,-1,-11);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-13,4,'2014-02-22 07:00:00','N',NULL,-5,-3);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-12,9,'2014-02-22 07:00:00','N',NULL,-4,-3);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-11,15,'2014-02-22 07:00:00','N',NULL,-1,-3);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-10,7,'2014-02-22 07:00:00','N',NULL,-3,-2);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-9,6,'2014-02-22 07:00:00','N',NULL,-2,-2);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-8,14,'2014-02-22 07:00:00','N',NULL,-1,-2);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-7,3,'2014-02-22 07:00:00','N',NULL,-7,-1);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-6,2,'2014-02-22 07:00:00','N',NULL,-6,-1);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-5,3,'2014-02-22 07:00:00','N',NULL,-5,-1);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-4,5,'2014-02-22 07:00:00','N',NULL,-4,-1);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-3,10,'2014-02-22 07:00:00','N',NULL,-3,-1);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-2,4,'2014-02-22 07:00:00','N',NULL,-2,-1);
INSERT INTO `stokproduk` (`id`, `jumlah`, `createdDate`, `deleted`, `modifiedDate`, `gudang_id`, `produk_id`) VALUES (-1,10,'2014-02-22 07:00:00','N',NULL,-1,-1);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-11,'Manado','2014-02-22 07:00:00','N',NULL,'Kalbe Farma',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-10,'Minahasa','2014-02-22 07:00:00','N',NULL,'Surya Esa Perkasa',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-9,'Semarang','2014-02-22 07:00:00','N',NULL,'Berlian Laju Tanker',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-8,'Lampung','2014-02-22 07:00:00','N',NULL,'Asia Natural Resources',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-7,'Papua','2014-02-22 07:00:00','N',NULL,'Asiaplast Industries',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-6,'Pontianak','2014-02-22 07:00:00','N',NULL,'Alfa Retalindo',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-5,'Palembang','2014-02-22 07:00:00','N',NULL,'Majapahit Securities',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-4,'Bali','2014-02-22 07:00:00','N',NULL,'Polychem Indonesia',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-3,'Surabaya','2014-02-22 07:00:00','N',NULL,'Ace Hardware Indonesia',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-2,'Bandung','2014-02-22 07:00:00','N',NULL,'ABM Ivestama',NULL);
INSERT INTO `supplier` (`id`, `alamat`, `createdDate`, `deleted`, `modifiedDate`, `nama`, `nomorTelepon`) VALUES (-1,'Jakarta','2014-02-22 07:00:00','N',NULL,'Astra Agro Lestari','021-4616555');

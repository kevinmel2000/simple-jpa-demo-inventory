/*
 * Copyright 2014 Jocki Hendry.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package project.penjualan

import domain.event.PesanStok
import domain.exception.DataDuplikat
import domain.exception.DataTidakBolehDiubah
import domain.exception.MelebihiBatasKredit
import domain.exception.StokTidakCukup
import domain.faktur.BilyetGiro
import domain.faktur.Pembayaran
import domain.inventory.DaftarBarangSementara
import domain.inventory.Gudang
import domain.pembelian.PenerimaanBarang
import domain.penjualan.BuktiTerima
import domain.penjualan.FakturJual
import domain.penjualan.FakturJualEceran
import domain.penjualan.FakturJualOlehSales
import domain.penjualan.Konsumen
import domain.penjualan.StatusFakturJual
import project.inventory.GudangRepository
import domain.inventory.ItemBarang
import domain.inventory.Produk
import domain.pengaturan.KeyPengaturan
import org.joda.time.LocalDate
import project.user.NomorService
import simplejpa.SimpleJpaUtil
import simplejpa.transaction.Transaction
import util.SwingHelper
import griffon.util.*

@Transaction
class FakturJualRepository {

    NomorService nomorService
    GudangRepository gudangRepository

    List<FakturJual> cari(LocalDate tanggalMulaiSearch, LocalDate tanggalSelesaiSearch, String nomorSearch, String konsumenSearch, def statusSearch) {
        findAllFakturJualByDslFetchComplete([orderBy: 'tanggal,nomor', excludeDeleted: false]) {
            if (!nomorSearch) {
                tanggal between(tanggalMulaiSearch, tanggalSelesaiSearch)
            } else {
                nomor like("%${nomorSearch}%")
            }
            if (statusSearch != SwingHelper.SEMUA) {
                and()
                status eq(statusSearch)
            }
            if (konsumenSearch) {
                and()
                konsumen__nama like("%${konsumenSearch}%")
            }
        }
    }

    List<FakturJualEceran> cariFakturJualEceran(LocalDate tanggalMulaiSearch, LocalDate tanggalSelesaiSearch, String nomorSearch, String namaPembeliSearch, def statusSearch) {
        findAllFakturJualEceranByDslFetchComplete([orderBy: 'tanggal,nomor', excludeDeleted: false]) {
            if (!nomorSearch) {
                tanggal between(tanggalMulaiSearch, tanggalSelesaiSearch)
            } else {
                nomor like("%${nomorSearch}%")
            }
            if (statusSearch != SwingHelper.SEMUA) {
                and()
                status eq(statusSearch)
            }
            if (namaPembeliSearch) {
                and()
                namaPembeli like("%${namaPembeliSearch}%")
            }
        }
    }

    List<FakturJualOlehSales> cariFakturJualOlehSales(LocalDate tanggalMulaiSearch, LocalDate tanggalSelesaiSearch, String nomorSearch, String salesSearch, String konsumenSearch, def statusSearch) {
        findAllFakturJualOlehSalesByDslFetchComplete([orderBy: 'tanggal,nomor', excludeDeleted: false]) {
            if (!nomorSearch) {
                tanggal between(tanggalMulaiSearch, tanggalSelesaiSearch)
            } else {
                nomor like("%${nomorSearch}%")
            }
            if (statusSearch != SwingHelper.SEMUA) {
                and()
                status eq(statusSearch)
            }
            if (salesSearch) {
                and()
                konsumen__sales__nama like("%${salesSearch}%")
            }
            if (konsumenSearch) {
                and()
                konsumen__nama like("%${konsumenSearch}%")
            }
        }
    }

    List<FakturJualOlehSales> cariFakturJualUntukPengiriman(LocalDate tanggalMulaiSearch, LocalDate tanggalSelesaiSearch, String nomorSearch, String konsumenSearch, def statusSearch) {
        findAllFakturJualOlehSalesByDslFetchPengeluaranBarang([orderBy: 'tanggal,nomor']) {
            if (!nomorSearch) {
                tanggal between(tanggalMulaiSearch, tanggalSelesaiSearch)
            } else {
                nomor like("%${nomorSearch}%")
            }
            if (statusSearch != SwingHelper.SEMUA) {
                and()
                status eq(statusSearch)
            }
            if (konsumenSearch) {
                and()
                konsumen__nama like("%${konsumenSearch}%")
            }
        }
    }

    List<FakturJualOlehSales> cariFakturJualUntukBuktiTerima(LocalDate tanggalMulaiSearch, LocalDate tanggalSelesaiSearch, String nomorFakturSearch, String nomorSuratJalanSearch, String konsumenSearch, def statusSearch) {
        findAllFakturJualOlehSalesByDslFetchPengeluaranBarang([orderBy: 'tanggal,nomor']) {
            if (!nomorFakturSearch) {
                tanggal between(tanggalMulaiSearch, tanggalSelesaiSearch)
            } else {
                nomor like("%${nomorFakturSearch}%")
            }
            if (statusSearch != SwingHelper.SEMUA) {
                and()
                status eq(statusSearch)
            }
            if (nomorSuratJalanSearch) {
                and()
                pengeluaranBarang__nomor like("%${nomorSuratJalanSearch}%")
            }
            if (konsumenSearch) {
                and()
                konsumen__nama like("%${konsumenSearch}%")
            }
        }
    }

    public List<FakturJualOlehSales> cariPiutang(LocalDate tanggalMulaiSearch, LocalDate tanggalSelesaiSearch, String nomorSearch,
            String konsumenSearch, StatusPiutangSearch statusPiutangSearch = StatusPiutangSearch.SEMUA) {
        findAllFakturJualOlehSalesByDslFetchPiutang([orderBy: 'tanggal,nomor', excludeDeleted: false]) {
            if (!nomorSearch && (statusPiutangSearch != StatusPiutangSearch.AKAN_JATUH_TEMPO) && (statusPiutangSearch != StatusPiutangSearch.BELUM_LUNAS)) {
                tanggal between(tanggalMulaiSearch, tanggalSelesaiSearch)
            }
            if (nomorSearch) {
                and()
                nomor like("%${nomorSearch}%")
            }
            if (konsumenSearch) {
                and()
                konsumen__nama like("%${konsumenSearch}%")
            }
            if (statusPiutangSearch == StatusPiutangSearch.AKAN_JATUH_TEMPO) {
                and()
                jatuhTempo between(LocalDate.now().plusDays(1), LocalDate.now().plusDays(7))
                and()
                status eq(StatusFakturJual.DITERIMA)
            } else {
                List statusSearch = []
                if ((statusPiutangSearch == StatusPiutangSearch.BELUM_LUNAS) || (statusPiutangSearch == StatusPiutangSearch.SEMUA)) {
                    statusSearch << StatusFakturJual.DITERIMA
                }
                if ((statusPiutangSearch == StatusPiutangSearch.LUNAS) || (statusPiutangSearch == StatusPiutangSearch.SEMUA)) {
                    statusSearch << StatusFakturJual.LUNAS
                }
                and()
                status isIn(statusSearch)
            }
        }
    }

    public List<FakturJualOlehSales> cariPiutang(String nomorReferensi) {
        executeQuery("SELECT f FROM FakturJualOlehSales f JOIN FETCH f.piutang.listPembayaran p WHERE p.referensi.nomor = :nomorReferensi",
            [:], [nomorReferensi: nomorReferensi])
    }

    FakturJual buatFakturJualOlehSales(FakturJualOlehSales fakturJual, boolean tanpaLimit = false, List<ItemBarang> bonus) {
        fakturJual.listItemFaktur.each { it.produk = findProdukById(it.produk.id) }
        bonus.each { it.produk = findProdukById(it.produk.id) }
        fakturJual.tambahBonus(bonus)
        buatFakturJualOlehSales(fakturJual, tanpaLimit)
    }

    FakturJual buatFakturJualOlehSales(FakturJualOlehSales fakturJual, boolean tanpaLimit = false) {
        fakturJual.listItemFaktur.each { it.produk = findProdukById(it.produk.id) }
        fakturJual.konsumen = findKonsumenById(fakturJual.konsumen.id)
        Konsumen konsumen = fakturJual.konsumen

        // Periksa apakah jumlah barang yang tersedia cukup
        DaftarBarangSementara stokYangDibutuhkan = fakturJual.barangYangHarusDikirim()
        stokYangDibutuhkan.items.each { ItemBarang itemBarang ->
            Produk produk = findProdukById(itemBarang.produk.id)
            Gudang gudang = fakturJual.kirimDariGudangUtama? gudangRepository.cariGudangUtama(): fakturJual.konsumen.sales.gudang
            int jumlahTersedia = gudang.utama? produk.jumlahReadyGudangUtama(): produk.stok(gudang).jumlah
            if (jumlahTersedia < itemBarang.jumlah) {
                throw new StokTidakCukup(produk.nama, itemBarang.jumlah, jumlahTersedia, gudang)
            }
        }

        // Periksa limit bila perlu
        if (!tanpaLimit) {
            List<String> pesanKesalahan = []
            if (!konsumen.bolehKredit(fakturJual.total(), pesanKesalahan)) {
                throw new MelebihiBatasKredit(konsumen, pesanKesalahan)
            }
        }

        // Hitung tanggal jatuh tempo
        fakturJual.jatuhTempo = fakturJual.tanggal.plusDays(SimpleJpaUtil.instance.repositoryManager.findRepository('Pengaturan').getValue(KeyPengaturan.MASA_JATUH_TEMPO))

        persist(fakturJual)

        // Perlakuan khusus untuk faktur jual luar kota
        if (!fakturJual.konsumen.sales.dalamKota() && !fakturJual.kirimDariGudangUtama) {
            fakturJual.listItemFaktur.each {
                it.produk = findProdukById(it.produk.id)
            }
            fakturJual.kirim('Luar Kota')
            fakturJual.tambah(new BuktiTerima(fakturJual.tanggal, 'Luar Kota'))
        }

        // Tambahkan faktur jual yang baru dibuat pada konsumen yang bersangkutan
        konsumen.tambahFakturBelumLunas(fakturJual)

        // Ubah nilai harga jual terakhir untuk konsumen ini
        fakturJual.listItemFaktur.each {
            konsumen.hargaTerakhir[it.produk] = it.harga
        }

        fakturJual
    }

    FakturJualEceran buatFakturJualEceran(FakturJualEceran fakturJualEceran) {

        // Periksa apakah barang dalam gudang utama mencukupi
        Gudang gudangUtama = (SimpleJpaUtil.instance.repositoryManager.findRepository('GudangRepository') as GudangRepository).cariGudangUtama()
        fakturJualEceran.listItemFaktur.each {
            it.produk = findProdukById(it.produk.id)
            int jumlahTersedia = it.produk.stok(gudangUtama).jumlah
            if (it.produk.jumlahReadyGudangUtama() < it.jumlah) {
                throw new StokTidakCukup(it.produk.nama, it.jumlah, jumlahTersedia, gudangUtama)
            }
        }

        persist(fakturJualEceran)
        fakturJualEceran
    }

    FakturJual buat(FakturJual fakturJual, boolean tanpaLimit = false, List<ItemBarang> bonus = []) {
        fakturJual.nomor = nomorService.buatNomorFakturJual(fakturJual)
        if (findFakturJualByNomor(fakturJual.nomor)) {
            throw new DataDuplikat(fakturJual)
        }

        if (fakturJual instanceof FakturJualOlehSales) {
            if (bonus && !bonus.empty) {
                fakturJual = buatFakturJualOlehSales(fakturJual, tanpaLimit, bonus)
            } else {
                fakturJual = buatFakturJualOlehSales(fakturJual, tanpaLimit)
            }
        } else {
            fakturJual = buatFakturJualEceran(fakturJual)
        }

        ApplicationHolder.application.event(new PesanStok(fakturJual, false))
        fakturJual
    }

    FakturJualOlehSales bayar(FakturJualOlehSales fakturJualOlehSales, Pembayaran pembayaran, BilyetGiro bilyetGiro = null) {
        fakturJualOlehSales = findFakturJualOlehSalesById(fakturJualOlehSales.id)
        bilyetGiro = bilyetGiro?: pembayaran.bilyetGiro
        if(bilyetGiro) {
            if (bilyetGiro.id == null) {
                persist(bilyetGiro)
            } else {
                bilyetGiro = findBilyetGiroById(bilyetGiro.id)
            }
            pembayaran.bilyetGiro = bilyetGiro
        }
        fakturJualOlehSales.bayar(pembayaran)
        fakturJualOlehSales
    }

    FakturJualOlehSales hapusPembayaran(FakturJualOlehSales fakturJualOlehSales, Pembayaran pembayaran) {
        fakturJualOlehSales = findFakturJualOlehSalesById(fakturJualOlehSales.id)
        fakturJualOlehSales.hapusPembayaran(pembayaran)
        fakturJualOlehSales
    }

    FakturJual update(FakturJual fakturJual) {
        FakturJual mergedFakturJual = findFakturJualById(fakturJual.id)
        if (!mergedFakturJual || !mergedFakturJual.status.bolehDiubah) {
            throw new DataTidakBolehDiubah(fakturJual)
        }
        mergedFakturJual.with {
            tanggal = fakturJual.tanggal
            diskon = fakturJual.diskon
            keterangan = fakturJual.keterangan
        }
        if (fakturJual instanceof FakturJualOlehSales) {
            FakturJualOlehSales nilaiFakturBaru = (FakturJualOlehSales) fakturJual
            ((FakturJualOlehSales)mergedFakturJual).with {
                // TODO:  Apakah boleh mengubah sales?  Ini akan mempengaruhi status faktur karena proses
                // TODO:  pengiriman berbeda antara sales dalam kota dan sales luar kota.
                //sales = nilaiFakturBaru.sales

                // Periksa limit bila mengubah konsumen
                if (konsumen != nilaiFakturBaru.konsumen) {
                    konsumen = findKonsumenById(nilaiFakturBaru.konsumen.id)
                    List<String> pesanKesalahan = []
                    if (!konsumen.bolehKredit(mergedFakturJual.total(), pesanKesalahan)) {
                        throw new MelebihiBatasKredit(konsumen, pesanKesalahan)
                    }
                }
            }
        } else if (fakturJual instanceof FakturJualEceran) {
            ((FakturJualEceran)mergedFakturJual).with {
                namaPembeli = ((FakturJualEceran)fakturJual).namaPembeli
            }
        }
        mergedFakturJual
    }

    FakturJual hapus(FakturJual fakturJual) {
        fakturJual = findFakturJualById(fakturJual.id)
        if (!fakturJual || !fakturJual.status.bolehDiubah) {
            throw new DataTidakBolehDiubah(fakturJual)
        }
        fakturJual.deleted = 'Y'
        ApplicationHolder.application.event(new PesanStok(fakturJual, true))

        // Hapus dari konsumen bila perlu
        if (fakturJual instanceof FakturJualOlehSales) {
            fakturJual.konsumen.hapusFakturBelumLunas(fakturJual)
        }
        fakturJual
    }

    FakturJualEceran antar(FakturJualEceran fakturJualEceran) {
        fakturJualEceran = findFakturJualEceranById(fakturJualEceran.id)
        fakturJualEceran.antar()
        fakturJualEceran
    }

    FakturJualEceran batalAntar(FakturJualEceran fakturJualEceran) {
        fakturJualEceran = findFakturJualEceranById(fakturJualEceran.id)
        fakturJualEceran.batalAntar()
        fakturJualEceran
    }

    FakturJualEceran bayar(FakturJualEceran fakturJualEceran) {
        fakturJualEceran = findFakturJualEceranById(fakturJualEceran.id)
        fakturJualEceran.bayar()
        fakturJualEceran
    }

    FakturJualOlehSales kirim(FakturJualOlehSales faktur, String alamatTujuan, LocalDate tanggalKirim = LocalDate.now(), String keterangan = null) {
        faktur = findFakturJualOlehSalesById(faktur.id)
        faktur.kirim(alamatTujuan, tanggalKirim, keterangan)
        faktur
    }

    FakturJualOlehSales buatSuratJalan(FakturJualOlehSales faktur, String alamatTujuan, LocalDate tanggalKirim = LocalDate.now(), String keterangan = null) {
        faktur = findFakturJualOlehSalesById(faktur.id)
        faktur.buatSuratJalan(alamatTujuan, tanggalKirim, keterangan)
        faktur
    }

    FakturJualOlehSales kirimSuratJalan(FakturJualOlehSales faktur) {
        faktur = findFakturJualOlehSalesById(faktur.id)
        faktur.kirimSuratJalan()
        faktur
    }

    FakturJualOlehSales batalKirim(FakturJualOlehSales faktur) {
        faktur = findFakturJualOlehSalesById(faktur.id)
        faktur.hapusPengeluaranBarang()
        faktur
    }

    FakturJualOlehSales terima(FakturJualOlehSales faktur, BuktiTerima buktiTerima) {
        faktur = findFakturJualOlehSalesById(faktur.id)
        faktur.tambah(buktiTerima)
        faktur
    }

    FakturJualOlehSales retur(FakturJualOlehSales faktur, PenerimaanBarang penerimaanBarang) {
        faktur = findFakturJualOlehSalesByIdFetchItems(faktur.id)
        if (!faktur) {
            throw new DataTidakBolehDiubah(faktur)
        }
        penerimaanBarang.items.each { it.produk = findProdukById(it.produk.id) }
        faktur.tambahRetur(penerimaanBarang)
        persist(penerimaanBarang)
        faktur
    }

    FakturJualOlehSales hapusRetur(FakturJualOlehSales faktur, String nomorPenerimaanBarang) {
        faktur = findFakturJualOlehSalesByIdFetchItems(faktur.id)
        if (!faktur) {
            throw new DataTidakBolehDiubah(faktur)
        }
        faktur.hapusRetur(nomorPenerimaanBarang)
        faktur
    }

    FakturJualOlehSales hapusBuktiTerima(FakturJualOlehSales faktur) {
        faktur = findFakturJualOlehSalesById(faktur.id)
        faktur.hapusBuktiTerima()
        faktur
    }

    DaftarBarangSementara hitungBarangYangHarusDikirim() {
        DaftarBarangSementara hasil
        findAllFakturJualOlehSalesByDslFetchPengeluaranBarang {
            status eq(StatusFakturJual.DIBUAT)
        }.each { FakturJualOlehSales f ->
            if (!hasil) {
                hasil = f.barangYangHarusDikirim()
            } else {
                hasil += f.barangYangHarusDikirim()
            }
        }
        def items = (hasil?.normalisasi()?:[]).sort {it.produk.nama}
        new DaftarBarangSementara(items, 1)
    }

    public enum StatusPiutangSearch {
        SEMUA('Semua'), BELUM_LUNAS('Belum Lunas'), LUNAS('Lunas'), AKAN_JATUH_TEMPO('Akan Jatuh Tempo')

        String description

        public StatusPiutangSearch(String description) {
            this.description = description
        }

        @Override
        String toString() {
            description
        }
    }

}

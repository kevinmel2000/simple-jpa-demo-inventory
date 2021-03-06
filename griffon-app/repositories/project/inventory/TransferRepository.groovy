/*
 * Copyright 2015 Jocki Hendry.
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
package project.inventory

import domain.event.TransferStok
import domain.exception.DataDuplikat
import domain.exception.DataTidakBolehDiubah
import domain.exception.StokTidakCukup
import domain.inventory.Transfer
import project.user.NomorService
import simplejpa.transaction.Transaction
import org.joda.time.*

@Transaction
class TransferRepository {

    def app
    NomorService nomorService

    List<Transfer> cari(LocalDate tanggalMulaiSearch, LocalDate tanggalSelesaiSearch, String nomorSearch,
                               String asalSearch, String tujuanSearch) {
        findAllTransferByDsl([orderBy: 'tanggal,nomor', excludeDeleted: false]) {
            if (!nomorSearch) {
                tanggal between(tanggalMulaiSearch, tanggalSelesaiSearch)
            } else {
                nomor like("%${nomorSearch}%")
            }
            if (asalSearch) {
                and()
                gudang__nama like("%${asalSearch}%")
            }
            if (tujuanSearch) {
                and()
                tujuan__nama like("%${tujuanSearch}%")
            }
        }
    }

    Transfer buat(Transfer transfer) {
        transfer.nomor = nomorService.buatNomor(NomorService.TIPE.TRANSFER)
        if (findTransferByNomor(transfer.nomor)) {
            throw new DataDuplikat(transfer)
        }
        if (transfer.gudang.equals(transfer.tujuan)) {
            throw new IllegalStateException('Gudang asal dan gudang tujuan tidak boleh sama!')
        }
        transfer.items.each {
            it.produk = findProdukById(it.produk.id)
            int jumlahTersedia = it.produk.stok(transfer.gudang).jumlah
            if (jumlahTersedia < it.jumlah) {
                throw new StokTidakCukup(it.produk.nama, it.jumlah, jumlahTersedia, transfer.gudang)
            }
        }
        persist(transfer)
        app?.event(new TransferStok(transfer))
        transfer
    }

    Transfer update(Transfer transfer) {
        Transfer mergedTransfer = findTransferById(transfer.id)
        if (!mergedTransfer) {
            throw new DataTidakBolehDiubah(mergedTransfer)
        }
        mergedTransfer.with {
            nomor = transfer.nomor
            tanggal = transfer.tanggal
            keterangan = transfer.keterangan
        }
        mergedTransfer
    }

    Transfer hapus(Transfer transfer) {
        transfer = findTransferById(transfer.id)
        if (!transfer) {
            throw new DataTidakBolehDiubah(transfer)
        }
        transfer.deleted = 'Y'
        app?.event(new TransferStok(transfer, true))
        transfer
    }


}


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
package project.laporan

import project.penjualan.FakturJualRepository
import org.joda.time.LocalDate
import javax.swing.SwingUtilities

@SuppressWarnings("GroovyUnusedDeclaration")
class LaporanPenjualanPerRegionController {

    LaporanPenjualanPerRegionModel model
    def view
    FakturJualRepository fakturJualRepository

    void mvcGroupInit(Map args) {
        model.tanggalMulaiCari = LocalDate.now().withDayOfMonth(1)
        model.tanggalSelesaiCari = LocalDate.now().withDayOfMonth(1).plusMonths(1).minusDays(1)
        execInsideUISync {
            model.regionList.clear()
        }
        List region = fakturJualRepository.findAllRegion([orderBy: 'nama'])
        execInsideUISync {
            model.regionList.addAll(region)
        }
    }

    def tampilkanLaporan = {
        model.result = fakturJualRepository.findAllFakturJualOlehSalesByDslFetchItems([orderBy: 'konsumen__region__nama,tanggal,nomor']) {
            tanggal between(model.tanggalMulaiCari, model.tanggalSelesaiCari)
            if (model.region.selectedItem) {
                and()
                konsumen__region eq(model.region.selectedItem)
                or()
                konsumen__region__bagianDari eq(model.region.selectedItem)
            }
        }
        model.params.'tanggalMulaiCari' = model.tanggalMulaiCari
        model.params.'tanggalSelesaiCari' = model.tanggalSelesaiCari
        close()
    }

    def reset = {
        model.tanggalMulaiCari = LocalDate.now().withDayOfMonth(1)
        model.tanggalSelesaiCari = LocalDate.now().withDayOfMonth(1).plusMonths(1).minusDays(1)
        model.region.selectedItem = null
    }

    def batal = {
        model.batal = true
        close()
    }

    def close = {
        execInsideUISync { SwingUtilities.getWindowAncestor(view.mainPanel).visible = false }
    }

}

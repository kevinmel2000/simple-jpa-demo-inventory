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

import domain.Container
import domain.faktur.ItemFaktur
import domain.penjualan.*
import ca.odell.glazedlists.*
import ca.odell.glazedlists.swing.*
import groovy.beans.Bindable
import org.jdesktop.swingx.combobox.ListComboBoxModel
import org.joda.time.*
import javax.swing.event.*
import simplejpa.swing.*
import org.jdesktop.swingx.combobox.EnumComboBoxModel
import project.main.MainGroupModel.FakturEceranViewMode

class FakturJualEceranModel {

    FakturEceranViewMode mode
    @Bindable boolean showPenerimaan
    @Bindable boolean showFakturJual
    @Bindable boolean showNilaiUang
    @Bindable boolean allowAddFakturJual

    @Bindable Long id
    @Bindable String nomor
    @Bindable LocalDate tanggal
    @Bindable String namaPembeli
    @Bindable BigDecimal diskonPotonganPersen
    @Bindable BigDecimal diskonPotonganLangsung
    @Bindable String keterangan
    List<ItemFaktur> listItemFaktur = []

    @Bindable String nomorSearch
    @Bindable String namaPembeliSearch
    @Bindable LocalDate tanggalMulaiSearch
    @Bindable LocalDate tanggalSelesaiSearch
    ListComboBoxModel statusSearch = new ListComboBoxModel(Container.app.searchEnum(StatusFakturJual))

    BasicEventList<FakturJualEceran> fakturJualEceranList = new BasicEventList<>()

    @Bindable String informasi

}
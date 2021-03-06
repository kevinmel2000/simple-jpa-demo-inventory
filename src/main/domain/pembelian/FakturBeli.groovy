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
package domain.pembelian

import domain.exception.DataTidakBolehDiubah
import domain.faktur.Faktur
import domain.faktur.KewajibanPembayaran
import groovy.transform.*
import org.hibernate.annotations.Type
import org.joda.time.LocalDate
import simplejpa.DomainClass
import javax.persistence.*
import javax.validation.constraints.*

@DomainClass @Entity @Canonical @ToString(excludes='hutang')
class FakturBeli extends Faktur {

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
    KewajibanPembayaran hutang

    @NotNull @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    LocalDate jatuhTempo

    void setJatuhTempoPer(int hari) {
        jatuhTempo = tanggal.plusDays(hari)
    }

    KewajibanPembayaran buatHutang() {
        if (hutang) {
            throw new DataTidakBolehDiubah(this)
        }
        hutang = new KewajibanPembayaran(jumlah: total())
    }

    boolean sudahJatuhTempo(LocalDate padaTanggal = LocalDate.now()) {
        padaTanggal.equals(jatuhTempo) || padaTanggal.isAfter(jatuhTempo)
    }

}


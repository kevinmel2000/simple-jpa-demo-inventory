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

import domain.pembelian.Supplier
import domain.exception.DataDuplikat
import simplejpa.transaction.Transaction

@Transaction
class SupplierRepository {

    public List<Supplier> cari(String nama) {
        findAllSupplierByDsl([excludeDeleted: false]) {
            if (nama) {
                nama like("%${nama}%")
            }
        }
    }

    public Supplier buat(Supplier supplier) {
        if (findSupplierByNama(supplier.nama)) {
            throw new DataDuplikat(supplier)
        }
        persist(supplier)
        supplier
    }
}
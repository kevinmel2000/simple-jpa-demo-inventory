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
package domain.pembelian;

public enum StatusPurchaseOrder {

    DIBUAT("Dibuat", true, true, true),
    DIPROSES("Diproses", true, true, true),
    OK("OK", false, false, false),
    LUNAS("Lunas", false, false, false);

    private String desc;
    private boolean bolehDiubah;
    private boolean fakturBolehDiubah;
    private boolean penerimaanBolehDiubah;

    StatusPurchaseOrder(String desc, boolean bolehDiubah, boolean fakturBolehDiubah, boolean penerimaanBolehDiubah) {
        this.desc = desc;
        this.bolehDiubah = bolehDiubah;
        this.fakturBolehDiubah = fakturBolehDiubah;
        this.penerimaanBolehDiubah = penerimaanBolehDiubah;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isBolehDiubah() {
        return bolehDiubah;
    }

    public void setBolehDiubah(boolean bolehDiubah) {
        this.bolehDiubah = bolehDiubah;
    }

    public boolean isFakturBolehDiubah() {
        return fakturBolehDiubah;
    }

    public void setFakturBolehDiubah(boolean fakturBolehDiubah) {
        this.fakturBolehDiubah = fakturBolehDiubah;
    }

    public boolean isPenerimaanBolehDiubah() {
        return penerimaanBolehDiubah;
    }

    public void setPenerimaanBolehDiubah(boolean penerimaanBolehDiubah) {
        this.penerimaanBolehDiubah = penerimaanBolehDiubah;
    }

    @Override
    public String toString() {
        return desc;
    }

}
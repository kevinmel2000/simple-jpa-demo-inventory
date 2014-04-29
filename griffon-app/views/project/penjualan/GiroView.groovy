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

import net.miginfocom.swing.MigLayout
import org.jdesktop.swingx.prompt.PromptSupport

import java.awt.FlowLayout

import static ca.odell.glazedlists.gui.AbstractTableComparatorChooser.SINGLE_COLUMN
import static javax.swing.SwingConstants.CENTER

application() {

    panel(id: 'mainPanel') {
        borderLayout()

        panel(constraints: PAGE_START) {
            flowLayout(alignment: FlowLayout.LEADING)
            dateTimePicker(id: 'tanggalMulaiSearch', localDate: bind('tanggalMulaiSearch', target: model, mutual: true), timeVisible: false)
            label(' s/d ')
            dateTimePicker(id: 'tanggalSelesaiSearch', localDate: bind('tanggalSelesaiSearch', target: model, mutual: true), timeVisible: false)
            textField(id: 'nomorSeriSearch', columns: 20, text: bind('nomorSeriSearch', target: model, mutual: true), actionPerformed: controller.search)
            button(app.getMessage('simplejpa.search.label'), actionPerformed: controller.search)
        }

        scrollPane(constraints: CENTER) {
            glazedTable(id: 'table', list: model.bilyetGiroList, sortingStrategy: SINGLE_COLUMN, onValueChanged: controller.tableSelectionChanged) {
                glazedColumn(name: '', property: 'deleted', width: 20) {
                    templateRenderer(exp: { it == 'Y' ? 'D' : '' })
                }
                glazedColumn(name: 'Nomor Seri', property: 'nomorSeri')
                glazedColumn(name: 'Tanggal Penerbitan', property: 'tanggalPenerbitan') {
                    templateRenderer(exp: {it?.toString('dd-MM-yyyy')})
                }
                glazedColumn(name: 'Tanggal Efektif', property: 'tanggalEfektif') {
                    templateRenderer(exp: {it?.toString('dd-MM-yyyy')})
                }
                glazedColumn(name: 'Tanggal Pencairan', property: 'tanggalPencairan') {
                    templateRenderer(exp: {it?.toString('dd-MM-yyyy')})
                }
            }
        }

        panel(id: "form", layout: new MigLayout('', '[right][left][left,grow]', ''), constraints: PAGE_END, focusCycleRoot: true) {
            label('Nomor Seri:')
            textField(id: 'nomorSeri', columns: 50, text: bind('nomorSeri', target: model, mutual: true), errorPath: 'nomorSeri')
            errorLabel(path: 'nomorSeri', constraints: 'wrap')
            label('Tanggal Penerbitan:')
            dateTimePicker(id: 'tanggalPenerbitan', localDate: bind('tanggalPenerbitan', target: model, mutual: true), errorPath: 'tanggalPenerbitan', timeVisible: false)
            errorLabel(path: 'tanggalPenerbitan', constraints: 'wrap')
            label('Tanggal Efektif:')
            dateTimePicker(id: 'tanggalEfektif', localDate: bind('tanggalEfektif', target: model, mutual: true), errorPath: 'tanggalEfektif', timeVisible: false)
            errorLabel(path: 'tanggalEfektif', constraints: 'wrap')

            panel(constraints: 'span, growx, wrap') {
                flowLayout(alignment: FlowLayout.LEADING)
                button(app.getMessage("simplejpa.dialog.save.button"), actionPerformed: {
                    if (model.id != null) {
                        if (JOptionPane.showConfirmDialog(mainPanel, app.getMessage("simplejpa.dialog.update.message"),
                                app.getMessage("simplejpa.dialog.update.title"), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) != JOptionPane.YES_OPTION) {
                            return
                        }
                    }
                    controller.save()
                    form.getFocusTraversalPolicy().getFirstComponent(form).requestFocusInWindow()
                })
                button('Cairkan', actionPerformed: controller.cairkan, visible: bind {table.isRowSelected})
                button(app.getMessage("simplejpa.dialog.delete.button"), visible: bind {
                    table.isRowSelected
                }, actionPerformed: {
                    if (JOptionPane.showConfirmDialog(mainPanel, app.getMessage("simplejpa.dialog.delete.message"),
                            app.getMessage("simplejpa.dialog.delete.title"), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        controller.delete()
                    }
                })
                button(app.getMessage("simplejpa.dialog.cancel.button"), visible: bind {
                    table.isRowSelected
                }, actionPerformed: controller.clear)
            }
        }
    }


}

PromptSupport.setPrompt('Nomor Seri...', nomorSeriSearch)

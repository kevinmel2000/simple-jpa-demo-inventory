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
package util

import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTabbedPane
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import griffon.core.GriffonApplication
import griffon.util.*

class MainTabbedPane extends JTabbedPane {

    GriffonApplication app

    MainTabbedPane() {
        this.app = ApplicationHolder.application
    }

    void addMVCTab(String mvcType, def args, String caption) {
        int idx = app.mvcGroupManager.groups.keySet().findAll { it.replaceAll('\\(\\d+\\)','').trim().equals(caption)}.size() + 1
        String mvcName = idx == 1? caption: "$caption ($idx)"
        def (m, v, c) = app.mvcGroupManager.createMVCGroup(mvcType, mvcName, args)
        addTab(mvcName, v.mainPanel)
        int tabIndex = tabCount-1
        setTabComponentAt(tabIndex, new ButtonTabComponent(mvcName))
        setSelectedIndex(tabIndex)
    }

    class ButtonTabComponent extends JPanel {

        String mvcName

        public ButtonTabComponent(String mvcName) {
            super(new FlowLayout(FlowLayout.LEFT, 0, 0))
            this.mvcName = mvcName
            setOpaque(false)
            JLabel label = new JLabel() {
                @Override
                String getText() {
                    int i = indexOfTabComponent(ButtonTabComponent.this)
                    i != -1? getTitleAt(i): null
                }
            }
            label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5))
            add(label)
            add(new CloseButton())
            setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0))
        }

        class CloseButton extends JButton implements ActionListener {

            private final int SIZE = 17;

            public CloseButton() {
                setPreferredSize(new Dimension(SIZE, SIZE))
                setToolTipText('Tutup tab ini')
                setContentAreaFilled(false)
                setFocusable(false)
                setBorderPainted(false)
                addActionListener(this)
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g)
                Graphics2D g2 = (Graphics2D) g.create()
                if (getModel().isPressed()) {
                    g2.translate(1,1)
                }
                g2.setStroke(new BasicStroke(2))
                g2.setColor(Color.BLACK)
                int delta = 6
                g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1)
                g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1)
                g2.dispose()
            }

            @Override
            void actionPerformed(ActionEvent e) {
                int i = indexOfTabComponent(ButtonTabComponent.this)
                if (i != -1) {
                    MainTabbedPane.this.app.mvcGroupManager.destroyMVCGroup(mvcName)
                    MainTabbedPane.this.remove(i)
                }
            }
        }
    }

}
